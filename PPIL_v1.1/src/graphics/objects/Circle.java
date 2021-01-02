package graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import graphics2D.World2D;

public class Circle implements DrawableObject {
	
	private int ID;
	private Color color;
	private Point center;
	private double radius;
		
	public Circle(int ID,String color, double x, double y, double radius) {
		this.ID = ID;
		this.color = new MyColor().getColor(color);
		this.center = new Point(x,y);
		this.radius = radius * World2D.ECHELLE / World2D.ECHELLE_BASE * 2;
	}
	
	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void draw(Graphics g, World2D panel) {
		int xloc1 = panel.getLocalCoordX(this.center.getX());
        int yloc1 = panel.getLocalCoordY(this.center.getY());
        g.setColor(color);
        g.drawOval(xloc1 - (int)this.radius/2, yloc1 - (int)this.radius/2, (int)this.radius, (int)this.radius); // !!!!! attention ici cast en int mais le radius devrait rester un double !!!!!
	}
}
