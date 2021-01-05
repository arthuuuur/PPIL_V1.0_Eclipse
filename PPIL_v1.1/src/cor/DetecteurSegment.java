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
		if (requete != null) {
			String[] data = requete.split(";");
			if(data[this.indexOf(data, "type") + 1].compareTo("1") == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public DrawableObject deserialize(String requete) {
		String[] data = requete.split(";");
		int id = Integer.parseInt(data[this.indexOf(data, "ID") + 1]);
		String color = data[this.indexOf(data, "color") + 1];
		double x1, y1, x2, y2; 
		x1 = Double.parseDouble(data[this.indexOf(data, "list") + 1]);
		y1 = Double.parseDouble(data[this.indexOf(data, "list") + 2]);
		x2 = Double.parseDouble(data[this.indexOf(data, "list") + 3]);
		y2 = Double.parseDouble(data[this.indexOf(data, "list") + 4]);
		this.Shape = new Segment(id,color,x1,y1,x2,y2);
		return Shape;
	}
}
