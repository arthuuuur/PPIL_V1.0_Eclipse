package graphics2D;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import graphics.objects.DrawableShapes;

public class ShapesManager{

	private List<DrawableShapes> objects; 
	private World W;
	
    public ShapesManager(World W) {
    	this.W = W;
        this.objects = new ArrayList<>();
    }

    public void init() {
        this.objects.clear();
    }

    public void addObject(DrawableShapes obj) {
    	this.objects.add(obj);
        W.repaint();
    }

    public void removeObject(int rank) {
        this.objects.remove(rank);
        W.repaint();
    }
    
    public void draw(Graphics g, World panel) {
        for (DrawableShapes current : this.objects) {
            current.draw(g,panel);
        }
    }
}
