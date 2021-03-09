package shapes;

import java.awt.Graphics;

import ui.World;

/**
 * Interface for all the shape which can be drawable 
 */
public interface Shapes {
	
	/**
	 * Allow to draw a drawableShape in the
	 * 
	 * @param g The graphical context, which includes the drawing area for the shapes
	 * @param world The world in which the shape will be draw
	 */
    public void draw(Graphics g, World world);
}
