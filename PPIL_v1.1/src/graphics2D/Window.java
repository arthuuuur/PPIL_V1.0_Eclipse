package graphics2D;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private World panel;
	
	
	public World getWorld() {
		return this.panel;
	}
	
    public Window() {
        super("Dessin");
        this.panel = new World();
        this.panel.setPreferredSize(new Dimension(800, 800));
        this.add(this.panel, BorderLayout.CENTER);
        this.pack();
    }
}
