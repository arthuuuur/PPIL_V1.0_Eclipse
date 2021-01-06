package cor;

import graphics.objects.Circle;
import graphics.objects.DrawableObject;

public class DetecteurCercle extends DetecteurForme{
	
	private DrawableObject Shape;
		
	public DetecteurCercle() {
		super();
	}
	
	@Override
	public boolean estDetectee(String requete) {
		if (requete != null) {
			String[] data = requete.split(";");
			if(data[this.indexOf(data, "type") + 1].compareTo("2") == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public DrawableObject deserialize(String requete) {
		String[] data = requete.split(";");
		int id = Integer.parseInt(data[this.indexOf(data, "ID") + 1]);
		String color = data[this.indexOf(data, "shapeColor") + 1];
		double centerx, centery, radius; 
		centerx = Double.parseDouble(data[this.indexOf(data, "center") + 1]);
		centery = Double.parseDouble(data[this.indexOf(data, "center") + 2]);
		radius = Double.parseDouble(data[this.indexOf(data, "radius") + 1]);
		this.Shape = new Circle(id,color,centerx,centery,radius);
		return Shape;
	}
}