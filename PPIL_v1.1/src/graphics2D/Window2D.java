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

	private World2D panel;
	private DetecteurForme cor;

	public void ajouterDetecteur(DetecteurForme d) {
		d.setSuivant(cor);
		cor = d;
	}
	
	public DetecteurForme getCor() {
		return this.cor;
	}
	
	public World2D getWorld2D() {
		return this.panel;
	}
	
	public void initCor() {
		ajouterDetecteur(new DetecteurSegment());
		ajouterDetecteur(new DetecteurCercle());
		ajouterDetecteur(new DetecteurPolygone());
	}
	
    public Window2D() {
        super("Dessin");
        initCor();
        this.panel = new World2D();
        this.panel.setPreferredSize(new Dimension(800, 600));
        this.add(this.panel, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
