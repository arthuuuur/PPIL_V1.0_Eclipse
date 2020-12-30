package graphics.objects;

import java.awt.Graphics;

import graphics2D.World2D;

public interface DrawableObject {
	
	public int getID();
    public void draw(Graphics g, World2D panel);
}
