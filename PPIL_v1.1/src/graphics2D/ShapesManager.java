package graphics2D;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import cor.DetecteurCercle;
import cor.DetecteurForme;
import cor.DetecteurPolygone;
import cor.DetecteurSegment;
import graphics.objects.DrawableShapes;

public class ShapesManager{

	private List<DrawableShapes> objects; 
	private World W;
	private DetecteurForme cor;

	
    public ShapesManager(World W) {
    	this.W = W;
        this.objects = new ArrayList<>();
        initCor();
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
    
	public void ajouterDetecteur(DetecteurForme d) {
		d.setSuivant(cor);
		cor = d;
	}
	
	public DetecteurForme getCor() {
		return this.cor;
	}
	
	public void initCor() {
		ajouterDetecteur(new DetecteurSegment());
		ajouterDetecteur(new DetecteurCercle());
		ajouterDetecteur(new DetecteurPolygone());
	}
	
    public void draw(Graphics g, World panel) {
        for (DrawableShapes current : this.objects) {
            current.draw(g,panel);
        }
    }
}
