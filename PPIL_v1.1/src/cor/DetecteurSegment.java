package cor;

import graphics.objects.DrawableShapes;
import graphics.objects.Segment;


public class DetecteurSegment extends DetecteurForme{
	
	private DrawableShapes Shape;
		
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
	public DrawableShapes deserialize(String requete) {
		String[] data = requete.split(";");
		String color;
		if (Integer.parseInt(data[this.indexOf(data, "groupID") + 1]) != -1) {
			color = data[this.indexOf(data, "groupColor") + 1];
		}
		else {
			color = data[this.indexOf(data, "shapeColor") + 1];
		}
		double x1, y1, x2, y2; 
		x1 = Double.parseDouble(data[this.indexOf(data, "list") + 1]);
		y1 = Double.parseDouble(data[this.indexOf(data, "list") + 2]);
		x2 = Double.parseDouble(data[this.indexOf(data, "list") + 3]);
		y2 = Double.parseDouble(data[this.indexOf(data, "list") + 4]);
		this.Shape = new Segment(color,x1,y1,x2,y2);
		return Shape;
	}
}
