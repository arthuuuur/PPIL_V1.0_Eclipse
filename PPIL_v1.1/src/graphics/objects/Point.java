package graphics.objects;

import java.awt.Color;
import java.awt.Graphics;

import graphics2D.World2D;

public class Point implements DrawableObject {

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
	public int getID() {
		return -1;
	}

	@Override
	public void draw(Graphics g, World2D panel) {
		int xloc = panel.getLocalCoordX(this.x);
        int yloc = panel.getLocalCoordY(this.y);

        int[] xPoints = {xloc + 5, xloc - 5, xloc - 5, xloc + 5, xloc + 5};
        int[] yPoints = {yloc + 5, yloc + 5, yloc - 5, yloc - 5, yloc + 5};

        g.setColor(Color.cyan);
        g.drawPolyline(xPoints, yPoints, 5);
	}

}
