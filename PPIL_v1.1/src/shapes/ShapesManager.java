package shapes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import ui.World;

/**
 * this class groups in a list all the shapes of the world 
 */
public class ShapesManager{
	
	/**
	 * The list of all shapes contained in the world
	 */
	private List<DrawableShapes> objects; 
	
	/**
	 * The world which contains the shapes
	 */
	private World W;
	
	/**
	 * ShapeManager's constructor
	 * 
	 * @param W The world which will contains the shapes
	 */
    public ShapesManager(World W) {
    	this.W = W;
        this.objects = new ArrayList<>();
    }
    
    /**
     * Clear the list of DrawableShapes
     */
    public void clear() {
    	this.objects.clear();
    }
    
    /**
     * Add a shapes into the list of drawableShapes
     * 
     * @param obj The shape to add to the list
     */
    public void addObject(DrawableShapes obj) {
    	this.objects.add(obj);
        W.repaint();
    }
    
    /**
     * Remove a shapes from the list of drawableShapes
     * 
     * @param obj The shape to remove from the list
     */
    public void removeObject(DrawableShapes obj) {
    	this.objects.remove(obj);
    	 W.repaint();
    }
  	
    /**
	 * Allow to draw all the shapes of the list in the world
	 * 
	 * @param g The graphical context, which includes the drawing area for the shapes
	 * @param world The world in which the circle will be draw
	 */
    public void draw(Graphics g, World world) {
        for (DrawableShapes current : this.objects) {
            current.draw(g,world);
        }
    }
}
