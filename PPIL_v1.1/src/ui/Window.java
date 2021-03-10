package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This class which extends JFrame is the window which contains the world (JPanel) in which we will draw all the shapes 
 */
@SuppressWarnings("serial")
public class Window extends JFrame {

	/**
	 * The world which will contains all the shapes
	 */
	private World world;
	
	/**
	 * Window's constructor
	 */
    public Window() {
        super("Dessin");
        this.world = new World();
        this.world.setPreferredSize(new Dimension(800, 800));
        this.add(this.world, BorderLayout.CENTER);
        this.pack();   
    }
	
	/**
	 * Getter of world
	 * 
	 * @return The world of the window
	 */
	public World getWorld() {
		return this.world;
	}
}
