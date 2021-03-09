package corDetector;

import shapes.Circle;
import shapes.Shapes;
import shapes.Point;

/**
 * ShapeDetector to find circle in the request from the client
 */
public class CircleDetector extends ShapeDetector{
	
	/**
	 * the circle that will be created thanks to the deserialize function 
	 * if a circle is detected in the client's request.
	 *
	 * @see #deserialize
	 */
	private Shapes Shape;
	
	/**
	 * Default DetecteurCercle's constructor
	 */
	public CircleDetector() {
		super();
	}
	
	/**
	 * allows to know if the analysis of the request has led to the detection of a cirlce
	 * 
	 * @param requete the requete to analysis
	 * @return True if detected, else false
	 */
	@Override
	public boolean estDetectee(String[] requete) {
		if (requete != null) {
			if(requete[this.indexOf(requete, "type") + 1].compareTo("2") == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method is use when we have found a circle in the request thanks to the reponsability's chain
	 * it will retrieve all the construction information of the shape in the request in order to create it.
	 * 
	 * @param requete the request to be deserialize
	 * @return The circle corresponding to the request informations 
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
		double centerx, centery, radius; 
		centerx = Double.parseDouble(requete[this.indexOf(requete, "center") + 1]);
		centery = Double.parseDouble(requete[this.indexOf(requete, "center") + 2]);
		Point center = new Point(centerx, centery);
		radius = Double.parseDouble(requete[this.indexOf(requete, "radius") + 1]);
		this.Shape = new Circle(color,center,radius);
		return Shape;
	}
}