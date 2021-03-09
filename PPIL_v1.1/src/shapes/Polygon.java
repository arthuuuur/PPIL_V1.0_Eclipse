package shapes;

import java.awt.Color;
import java.awt.Graphics;

import ui.World;

/**
 * This class simply represente a polygon with 2 array for the x and y coordinate of his points, the point's number of the polygon and his color
 */
public class Polygon implements Shapes {
	
	/**
	 * Polygon's color
	 */
	private Color color;
	
	/**
	 * Array of all the x coordinate of each polygon's points
	 */
	private int[] xPoints;
	
	/**
	 * Array of all the y coordinate of each polygon's points
	 */
	private int[] yPoints;
	
	/**
	 * The point's number of the polygon
	 */
	private int nbPoints;
	
	/**
	 * Polygon's constructor
	 * The color in string format in converted in awt.Color thanks to MyColor class
	 * 
	 * @param color Polygon's color
	 * @param nbPoint The point's number of the polygon
	 * @param xPoints Array of all the x coordinate of each polygon's points
	 * @param yPoints Array of all the y coordinate of each polygon's points
	 * 
	 *  @see MyColor
	 */
	public Polygon(String color, int nbPoint, int[] xPoints, int[] yPoints) {
		this.color = new MyColor().getColor(color);
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nbPoints = nbPoint;
	}
	
	/**
	 * Allow to draw a polygon in the world
	 * 
	 * @param g The graphical context, which includes the drawing area for the shapes
	 * @param world The world in which the polygon will be draw
	 */
	@Override
	public void draw(Graphics g, World world) {
		int[] locxPoints = new int[this.nbPoints];
		int[] locyPoints = new int[this.nbPoints];
		for (int i = 0; i < this.nbPoints; i++) {
			locxPoints[i] = world.getCoordX(this.xPoints[i]);
			locyPoints[i] = world.getCoordY(this.yPoints[i]);
		}
		g.setColor(color);
		g.drawPolygon(locxPoints, locyPoints, this.nbPoints);
	}
}
