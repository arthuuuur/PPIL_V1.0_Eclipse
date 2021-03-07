package shapes;

import java.awt.Color;
import java.awt.Graphics;

import ui.World;

/**
 * This class simply represente a segment with 2 points for both of his extremities and a color
*/
public class Segment implements DrawableShapes  {

	/**
	 * Segment's color
	 */
	private Color color;
	
	/**
	 * Both extremities of the segment
	 */
	private Point p1, p2;
		
	/**
	 * Segment's constructor
	 * The color in string format in converted in awt.Color thanks to MyColor class
	 * 
	 * @param color Segment's color
	 * @param p1 First extremity
	 * @param p2 Second extremity
	 * 
	 *  @see #MyColor
	 */
	public Segment(String color, Point p1, Point p2) {
		this.color = new MyColor().getColor(color);
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Allow to draw a segment in the world
	 * 
	 * @param g The graphical context, which includes the drawing area for the shapes
	 * @param world The world in which the segment will be draw
	 */
	@Override
	public void draw(Graphics g, World world) {
		int xloc1 = world.getCoordX(this.p1.getX());
        int yloc1 = world.getCoordY(this.p1.getY());
        int xloc2 = world.getCoordX(this.p2.getX());
        int yloc2 = world.getCoordY(this.p2.getY());
        g.setColor(color);
        g.drawLine(xloc1, yloc1, xloc2, yloc2);
	}
}
