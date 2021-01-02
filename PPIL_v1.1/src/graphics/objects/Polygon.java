package graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import graphics2D.World2D;

public class Polygon implements DrawableObject {
	
	private int ID;
	private Color color;
	private int[] xPoints;
	private int[] yPoints;
	private int nbPoints;
	
	public Polygon(int ID, String color, int nbPoint, int[] xPoints, int[] yPoints) {
		this.ID = ID;
		this.color = new MyColor().getColor(color);
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nbPoints = nbPoint;
	}
	
	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void draw(Graphics g, World2D panel) {
		int[] locxPoints = new int[this.nbPoints];
		int[] locyPoints = new int[this.nbPoints];
		for (int i = 0; i < this.nbPoints; i++) {
			locxPoints[i] = panel.getLocalCoordX(this.xPoints[i]);
			locyPoints[i] = panel.getLocalCoordY(this.yPoints[i]);
		}
		g.setColor(color);
		g.drawPolygon(locxPoints, locyPoints, this.nbPoints); // !!!!! tableau des co x et y en int mais devrait etre en double !!!!!
	}
}
