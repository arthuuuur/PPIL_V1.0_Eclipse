package cor;

import graphics.objects.DrawableObject;
import graphics.objects.Polygon;

public class DetecteurPolygone extends DetecteurForme{
	
	private DrawableObject Shape;
		
	public DetecteurPolygone() {
		super();
	}
	
	@Override
	public boolean estDetectee(String requete) {
		if (requete != null) {
			String[] data = requete.split(";");
			if(data[this.indexOf(data, "type") + 1].compareTo("3") == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public DrawableObject deserialize(String requete) {
		String[] data = requete.split(";");
		String color;
		if (Integer.parseInt(data[this.indexOf(data, "groupID") + 1]) != -1) {
			color = data[this.indexOf(data, "groupColor") + 1];
		}
		else {
			color = data[this.indexOf(data, "shapeColor") + 1];
		}
		int nbPoints = Integer.parseInt(data[this.indexOf(data, "nbPoint") + 1]);
		int[] xPoints = new int[nbPoints];
		int[] yPoints = new int[nbPoints];
		int x = 0;
		int y = 0;
		for (int i = 0; i < nbPoints*2; i++) {
			if ( i % 2 == 0) {
				xPoints[x++] = Integer.parseInt(data[this.indexOf(data, "list") + 1 + i]);
			}else {
				yPoints[y++] = Integer.parseInt(data[this.indexOf(data, "list") + 1 + i]);
			}
		}
		this.Shape = new Polygon(color, nbPoints, xPoints, yPoints);
		return Shape;
	}
}