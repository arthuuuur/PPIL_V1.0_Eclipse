package shapes;

import java.awt.Color;
import java.awt.Graphics;

import ui.World;

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
	public void draw(Graphics g, World world) {
		int[] locxPoints = new int[this.nbPoints];
		int[] locyPoints = new int[this.nbPoints];
		for (int i = 0; i < this.nbPoints; i++) {
			locxPoints[i] = world.getCoordX(this.xPoints[i]);
			locyPoints[i] = world.getCoordY(this.yPoints[i]);
		}
		g.setColor(color);
		g.drawPolygon(locxPoints, locyPoints, this.nbPoints);
	}
}
