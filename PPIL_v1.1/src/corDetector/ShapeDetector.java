package corDetector;

import shapes.Shapes;
import ui.Window;

/**
 * ShapeDetector is the abstract base class for all detector of shape 
 * which allow to recognize and process the different data that the 
 * client sends to the server. It's a repsonsability's chain.
 */
public abstract class ShapeDetector {
	
	/**
	 * The next detector in the repsonsability's chain
	 */
	private ShapeDetector suivant = null;
	
	/**
	 * Set the next ShapeDetector in the repsonsability's chain
	 * 
	 * @param d the next ShapeDetector of the responsability's chain
	 */
	public void setSuivant(ShapeDetector d) {
		suivant = d;
	}
	
	/**
	 * Find the index of a specific string in an string array
	 * If the specific string isn't in the string array return -1.
	 * 
	 * @param data   The string array 
	 * @param val    The specific string you are looking for in the string array
	 * @return       The index of val in data, or -1 if isn't present 
	 */
	public int indexOf(String[] data, String val ) {
		for (int i = 0; i < data.length; i ++) {
			if(data[i].matches(val)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Determine if a shape is grouped or not
	 * 
	 * @param requete the requete with information about the shape
	 * @return true if grouped, else false
	 */
	public boolean isGrouped(String[] requete) {
		return Integer.parseInt(requete[this.indexOf(requete, "ID") + 1]) != Integer.parseInt(requete[this.indexOf(requete, "groupID") + 1]);
	}
	
	/**
	 * allows to know if the analysis of the request has led to the detection of a shape
	 * 
	 * @param requete the requete to analysis
	 * @return True if detected, else false
	 */
	public abstract boolean estDetectee(String[] requete);
	
	/**
	 * This method is use when we have found a shape in the request thanks to the reponsability's chain
	 * it will retrieve all the construction information of the shape in the request in order to create it.
	 * 
	 * @param requete the request to be deserialize
	 * @return The shape corresponding to the request informations 
	 */
	protected abstract Shapes deserialize(String[] requete);
	
	/**
	 * The main function of the responsability's chain
	 * this method passes the request to each ShapeDetector 
	 * until one of them has detected a shape, otherwise returns null
	 * If a shape is detected, create it with the specific information of 
	 * the request and add it to the ShapesManager of the world.
	 * 
	 * @param requete the requete to be analyzed and deserialize in a shape
	 * @param W The window which contains the world in which we will add the shape
	 *
	 * @see #deserialize
	 * @see Window
	 * @see ui.World
	 */
	public void detecter(String[] requete, Window W){
		if(estDetectee(requete)) {
			W.getWorld().getShapesManager().addShape(deserialize(requete));
		}
		else if(suivant != null)
			suivant.detecter(requete, W);
		else
			System.out.println("La requete ne correspond à aucune forme connue");
	}
}
