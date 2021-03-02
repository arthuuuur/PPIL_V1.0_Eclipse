package shapes;

import java.awt.Color;
import java.awt.Graphics;

import ui.World;

public class Point implements DrawableShapes {

	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public void draw(Graphics g, World world) {
		int xloc = world.getCoordX(this.x);
        int yloc = world.getCoordY(this.y);
        g.setColor(Color.RED);
        g.drawOval(xloc - 2, yloc - 2, 4, 4);
        g.fillOval(xloc - 2, yloc - 2, 4, 4);
	}

}
