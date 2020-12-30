package cor;

import graphics.objects.DrawableObject;
import graphics.objects.Segment;


public class DetecteurSegment extends DetecteurForme{
	
	private DrawableObject Shape;
		
	public DetecteurSegment() {
		super();
	}
	
	@Override
	public boolean estDetectee(String requete) {
		String[] data = requete.split(";");
		if(data[1].compareTo("1") == 0) {
			return true;
		}
		return false;
	}

	@Override
	public DrawableObject extraire(String requete) {
		String[] data = requete.split(";");
		this.Shape = new Segment(Integer.parseInt(data[3]), data[5], Double.parseDouble(data[6]),Double.parseDouble(data[7]), Double.parseDouble(data[8]), Double.parseDouble(data[9]));
		return Shape;
	}
}
