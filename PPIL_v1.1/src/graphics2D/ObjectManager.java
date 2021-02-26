package graphics2D;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import graphics.objects.DrawableObject;

public class ObjectManager{

	private List<DrawableObject> objects; 
	private World2D W;
	
    public ObjectManager(World2D W) {
    	this.W = W;
        this.objects = new ArrayList<>();
    }

    public void init() {
        this.objects.clear();
    }

    public void addObject(DrawableObject obj) {
    	this.objects.add(obj);
        W.repaint();
    }

    public void removeObject(int rank) {
        this.objects.remove(rank);
        W.repaint();
    }
    
    public void draw(Graphics g, World2D panel) {
        for (DrawableObject current : this.objects) {
            current.draw(g,panel);
        }
    }
}
