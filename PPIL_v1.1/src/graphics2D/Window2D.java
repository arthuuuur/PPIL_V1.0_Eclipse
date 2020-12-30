package graphics2D;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import cor.DetecteurCercle;
import cor.DetecteurForme;
import cor.DetecteurPolygone;
import cor.DetecteurSegment;


@SuppressWarnings("serial")
public class Window2D extends JFrame {

	private World2D pfguipanel;
	private DetecteurForme cor;

	public void ajouterDetecteur(DetecteurForme d) {
		d.setSuivant(cor);
		cor = d;
	}
	
	public DetecteurForme getCor() {
		return this.cor;
	}
	
	public World2D getWorld2D() {
		return this.pfguipanel;
	}
	
	public void initCor() {
		ajouterDetecteur(new DetecteurSegment());
		ajouterDetecteur(new DetecteurCercle());
		ajouterDetecteur(new DetecteurPolygone());
	}
	
    public Window2D() {
        super("Dessin");
        initCor();
        this.pfguipanel = new World2D();
        this.pfguipanel.setPreferredSize(new Dimension(800, 600));
        this.add(this.pfguipanel, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
