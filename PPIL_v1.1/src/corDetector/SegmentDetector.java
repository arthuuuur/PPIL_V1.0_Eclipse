package corDetector;

import shapes.Shapes;
import shapes.Point;
import shapes.Segment;

/**
 * ShapeDetector to find segment in the request from the client
 */
public class SegmentDetector extends ShapeDetector{
	
	/**
	 * the segment that will be created thanks to the deserialize function 
	 * if a segment is detected in the client's request.
	 *
	 * @see #deserialize
	 */
	private Shapes Shape;
		
	/**
	 * Default DetecteurSegment's constructor
	 */
	public SegmentDetector() {
		super();
	}
	
	/**
	 * allows to know if the analysis of the request has led to the detection of a segment
	 * 
	 * @param requete the requete to analysis
	 * @return True if detected, else false
	 */
	@Override
	public boolean estDetectee(String[] requete) {
		if (requete != null) {
			if(requete[this.indexOf(requete, "type") + 1].compareTo("1") == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is use when we have found a segment in the request thanks to the reponsability's chain
	 * it will retrieve all the construction information of the shape in the request in order to create it.
	 * 
	 * @param requete the request to be deserialize
	 * @return The segment corresponding to the request informations 
	 */
	@Override
	public Shapes deserialize(String[] requete) {
		String color;
		if (isGrouped(requete)) {
			color = requete[this.indexOf(requete, "groupColor") + 1];
		}
		else {
			color = requete[this.indexOf(requete, "shapeColor") + 1];
		}
		double x1, y1, x2, y2; 
		x1 = Double.parseDouble(requete[this.indexOf(requete, "list") + 1]);
		y1 = Double.parseDouble(requete[this.indexOf(requete, "list") + 2]);
		x2 = Double.parseDouble(requete[this.indexOf(requete, "list") + 3]);
		y2 = Double.parseDouble(requete[this.indexOf(requete, "list") + 4]);
		Point p1 = new Point(x1,y1);
		Point p2 = new Point(x2,y2);
		this.Shape = new Segment(color,p1,p2);
		return Shape;
	}
}
