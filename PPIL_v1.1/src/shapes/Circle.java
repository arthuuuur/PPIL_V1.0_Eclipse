package shapes;

import java.awt.Color;
import java.awt.Graphics;

import ui.World;

public class Circle implements DrawableShapes {
	
	private Color color;
	private Point center;
	private double radius;
		
	public Circle(String color, double x, double y, double radius) {
		this.color = new MyColor().getColor(color);
		this.center = new Point(x,y);
		this.radius = radius * World.ECHELLE * 2;
	}
	
	@Override
	public void draw(Graphics g, World panel) {
		int xloc1 = panel.getCoordX(this.center.getX());
        int yloc1 = panel.getCoordY(this.center.getY());
        g.setColor(color);
        g.drawOval(xloc1 - (int)this.radius / 2, yloc1 - (int)this.radius / 2, (int)this.radius, (int)this.radius);
	}
}
