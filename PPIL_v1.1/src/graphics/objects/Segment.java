package graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import graphics2D.World;

public class Segment implements DrawableShapes {

	private Color color;
	private Point p1, p2;
		
	public Segment(String color, double x1, double y1, double x2, double y2) {
		this.color = new MyColor().getColor(color);
		this.p1 = new Point(x1,y1);
		this.p2 = new Point(x2,y2);
	}
	


	@Override
	public void draw(Graphics g, World panel) {
		int xloc1 = panel.getCoordX(this.p1.getX());
        int yloc1 = panel.getCoordY(this.p1.getY());
        int xloc2 = panel.getCoordX(this.p2.getX());
        int yloc2 = panel.getCoordY(this.p2.getY());
        g.setColor(color);
        g.drawLine(xloc1, yloc1, xloc2, yloc2);
	}
}
