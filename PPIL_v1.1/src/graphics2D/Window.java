package graphics2D;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import cor.DetecteurCercle;
import cor.DetecteurForme;
import cor.DetecteurPolygone;
import cor.DetecteurSegment;


@SuppressWarnings("serial")
public class Window extends JFrame {

	private World panel;
	private DetecteurForme cor;

	public void ajouterDetecteur(DetecteurForme d) {
		d.setSuivant(cor);
		cor = d;
	}
	
	public DetecteurForme getCor() {
		return this.cor;
	}
	
	public World getWorld2D() {
		return this.panel;
	}
	
	public void initCor() {
		ajouterDetecteur(new DetecteurSegment());
		ajouterDetecteur(new DetecteurCercle());
		ajouterDetecteur(new DetecteurPolygone());
	}
	
    public Window() {
        super("Dessin");
        initCor();
        this.panel = new World();
        this.panel.setPreferredSize(new Dimension(800, 800));
        this.add(this.panel, BorderLayout.CENTER);
        this.pack();
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
