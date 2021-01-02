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
		String[] data = requete.split(";");
		if(data[1].compareTo("2") == 0) {
			return true;
		}
		return false;
	}

	@Override
	public DrawableObject deserialize(String requete) {
		String[] data = requete.split(";");
		this.Shape = new Circle(Integer.parseInt(data[3]), data[5], Double.parseDouble(data[7]),Double.parseDouble(data[8]), Double.parseDouble(data[10]));
		return Shape;
	}
}