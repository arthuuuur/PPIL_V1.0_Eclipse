package shapes;

import java.awt.Color;
import java.awt.Graphics;

import ui.World;

/**
 * This class simply represente a cirlce with a center, a radius and a color
 */
public class Circle implements DrawableShapes {
	
	/**
	 * The circle's color
	 */
	private Color color;

	/**
	 * The circle's center
	 */
	private Point center;
	
	/**
	 * The cirlce's radius
	 */
	private double radius;
		
	/**
	 * Circle's constructor 
	 * The color in string format in converted in awt.Color thanks to MyColor class
	 * 
	 * @param color The circle's color
	 * @param center The cirlce's center
	 * @param radius The cirlce's radius
	 * 
	 * @see MyColor
	 */
	public Circle(String color, Point center, double radius) {
		this.color = new MyColor().getColor(color);
		this.center = center;
		this.radius = radius * World.SCALE * 2;
	}
	
	/**
	 * Allow to draw a Circle in the world
	 * 
	 * @param g The graphical context, which includes the drawing area for the shapes
	 * @param world The world in which the circle will be draw
	 */
	@Override
	public void draw(Graphics g, World world) {
		int xloc1 = world.getCoordX(this.center.getX());
        int yloc1 = world.getCoordY(this.center.getY());
        g.setColor(color);
        g.drawOval(xloc1 - (int)this.radius / 2, yloc1 - (int)this.radius / 2, (int)this.radius, (int)this.radius);
	}
}
