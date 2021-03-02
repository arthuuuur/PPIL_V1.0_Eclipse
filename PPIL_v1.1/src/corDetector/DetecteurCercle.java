package corDetector;

import shapes.Circle;
import shapes.DrawableShapes;

public class DetecteurCercle extends DetecteurForme{
	
	private DrawableShapes Shape;
		
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
	public DrawableShapes deserialize(String requete) {
		String[] data = requete.split(";");
		String color;
		if (Integer.parseInt(data[this.indexOf(data, "groupID") + 1]) != -1) {
			color = data[this.indexOf(data, "groupColor") + 1];
		}
		else {
			color = data[this.indexOf(data, "shapeColor") + 1];
		}
		double centerx, centery, radius; 
		centerx = Double.parseDouble(data[this.indexOf(data, "center") + 1]);
		centery = Double.parseDouble(data[this.indexOf(data, "center") + 2]);
		radius = Double.parseDouble(data[this.indexOf(data, "radius") + 1]);
		this.Shape = new Circle(color,centerx,centery,radius);
		return Shape;
	}
}