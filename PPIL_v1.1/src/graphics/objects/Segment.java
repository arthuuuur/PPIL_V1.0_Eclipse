package graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import graphics2D.World2D;

public class Segment implements DrawableObject {

	private int ID;
	private Color color;
	private Point p1, p2;
		
	public Segment(int ID, String color, double x1, double y1, double x2, double y2) {
		this.ID = ID;
		this.color = new MyColor().getColor(color);
		this.p1 = new Point(x1,y1);
		this.p2 = new Point(x2,y2);
	}
	
	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void draw(Graphics g, World2D panel) {
		int xloc1 = panel.getLocalCoordX(this.p1.getX());
        int yloc1 = panel.getLocalCoordY(this.p1.getY());
        int xloc2 = panel.getLocalCoordX(this.p2.getX());
        int yloc2 = panel.getLocalCoordY(this.p2.getY());
        g.setColor(color);
        g.drawLine(xloc1, yloc1, xloc2, yloc2);
	}
}
