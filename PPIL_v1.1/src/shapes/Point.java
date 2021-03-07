package shapes;

import java.awt.Color;
import java.awt.Graphics;

import ui.World;

/**
 * This class simply represente a point with an abscissa and an ordinate
 */
public class Point implements DrawableShapes {

	/**
	* The point's abscissa
	*/
	private double x;
	
	/**
	* The point's ordinate
	*/
	private double y;
	
	/**
	 * Point's constructor
	 * 
	 * @param x The point's abscissa
	 * @param y The point's ordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Getter of x
	 * 
	 * @return The point's abscissa
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Getter of y
	 * 
	 * @return The point's ordinate
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * Setter of x 
	 * 
	 * @param x The point's abscissa
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Setter of y The point's ordinate 
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Allow to draw a point in the world
	 * 
	 * @param g The graphical context, which includes the drawing area for the shapes
	 * @param world The world in which the point will be draw
	 */
	@Override
	public void draw(Graphics g, World world) {
		int xloc = world.getCoordX(this.x);
        int yloc = world.getCoordY(this.y);
        g.setColor(Color.RED);
        g.drawOval(xloc - 2, yloc - 2, 4, 4);
        g.fillOval(xloc - 2, yloc - 2, 4, 4);
	}

}
