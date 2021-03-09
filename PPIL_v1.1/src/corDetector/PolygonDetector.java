package corDetector;

import shapes.Shapes;
import shapes.Polygon;

/**
 * ShapeDetector to find polygon in the request from the client
 */
public class PolygonDetector extends ShapeDetector{
	
	/**
	 * the polygon that will be created thanks to the deserialize function 
	 * if a polygon is detected in the client's request.
	 *
	 * @see #deserialize
	 */
	private Shapes Shape;
	
	/**
	 * Default DetecteurPolygon's constructor
	 */
	public PolygonDetector() {
		super();
	}
	
	/**
	 * allows to know if the analysis of the request has led to the detection of a polygon
	 * 
	 * @param requete the requete to analysis
	 * @return True if detected, else false
	 */
	@Override
	public boolean estDetectee(String[] requete) {
		if (requete != null) {
			if(requete[this.indexOf(requete, "type") + 1].compareTo("3") == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is use when we have found a polygon in the request thanks to the reponsability's chain
	 * it will retrieve all the construction information of the shape in the request in order to create it.
	 * 
	 * @param requete the request to be deserialize
	 * @return The polygon corresponding to the request informations 
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
		int nbPoints = Integer.parseInt(requete[this.indexOf(requete, "nbPoint") + 1]);
		int[] xPoints = new int[nbPoints];
		int[] yPoints = new int[nbPoints];
		int x = 0;
		int y = 0;
		for (int i = 0; i < nbPoints*2; i++) {
			if ( i % 2 == 0) {
				xPoints[x++] = Integer.parseInt(requete[this.indexOf(requete, "list") + 1 + i]);
			}else {
				yPoints[y++] = Integer.parseInt(requete[this.indexOf(requete, "list") + 1 + i]);
			}
		}
		this.Shape = new Polygon(color, nbPoints, xPoints, yPoints);
		return Shape;
	}
}