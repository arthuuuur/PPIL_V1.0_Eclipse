package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private World world;
	
	
	public World getWorld() {
		return this.world;
	}
	
    public Window() {
        super("Dessin");
        this.world = new World();
        this.world.setPreferredSize(new Dimension(800, 800));
        this.add(this.world, BorderLayout.CENTER);
        this.pack();
    }
}
