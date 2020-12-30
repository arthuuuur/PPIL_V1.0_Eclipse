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
		String[] data = requete.split(";");
		if(data[1].compareTo("3") == 0) {
			return true;
		}
		return false;
	}

	@Override
	public DrawableObject extraire(String requete) {
		String[] data = requete.split(";");
		int[] xPoints = new int[Integer.parseInt(data[7])];
		int[] yPoints = new int[Integer.parseInt(data[7])];
		int x = 0;
		int y = 0;
		for (int i = 9; i < data.length; i++) {
			if ( i % 2 == 1) {
				xPoints[x++] = Integer.parseInt(data[i]);
			}else {
				yPoints[y++] = Integer.parseInt(data[i]);
			}
		}
		this.Shape = new Polygon(Integer.parseInt(data[3]), data[5], Integer.parseInt(data[7]), xPoints, yPoints);
		return Shape;
	}
}