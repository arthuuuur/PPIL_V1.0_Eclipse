package graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import graphics2D.World;

public class Polygon implements DrawableShapes {
	
	private Color color;
	private int[] xPoints;
	private int[] yPoints;
	private int nbPoints;
	
	public Polygon(String color, int nbPoint, int[] xPoints, int[] yPoints) {
		this.color = new MyColor().getColor(color);
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nbPoints = nbPoint;
	}
	


	@Override
	public void draw(Graphics g, World panel) {
		int[] locxPoints = new int[this.nbPoints];
		int[] locyPoints = new int[this.nbPoints];
		for (int i = 0; i < this.nbPoints; i++) {
			locxPoints[i] = panel.getCoordX(this.xPoints[i]);
			locyPoints[i] = panel.getCoordY(this.yPoints[i]);
		}
		g.setColor(color);
		g.drawPolygon(locxPoints, locyPoints, this.nbPoints);
	}
}
