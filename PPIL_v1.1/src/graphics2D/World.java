package graphics2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

import graphics.objects.Point;

@SuppressWarnings("serial")
public class World extends JPanel implements MouseListener, MouseMotionListener {

  
	 private ShapesManager ObjManager = new ShapesManager(this);
	 private int Xold, Yold;                      // coordonnées du point local précédent
	 private int Xoffset, Yoffset;           	  // décalage de la vue par rapport au centre du repere
	 public static int ECHELLE = 20; 			  // pas du quadrillage
	
	 public World() {
		 super();
		 this.Xoffset = 0;
		 this.Yoffset = 0;
		 this.addMouseListener(this);
		 this.addMouseMotionListener(this);
		 Point p = new Point(4,3);
		 ObjManager.addObject(p);
	 }
   
	 public ShapesManager getObjManager() {
		 return this.ObjManager;
	 }
	 
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int height = this.getHeight();
        int width = this.getWidth();
        g.setColor(Color.GRAY); // couleur du fond
        g.fillRect(0, 0, width, height);
        //tracé des axes du repere
        g.setColor(Color.BLACK); // couleur des axes du repere
        g.drawLine(width / 2 + this.Xoffset, 0, width / 2 + this.Xoffset, height);
        g.drawLine(0, height / 2 + this.Yoffset, width, height / 2 + this.Yoffset);
        //initialisation des pointillés pour le quadrillage
        float[] dash = {1, 4};
        BasicStroke pointille = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, 0);
        g.setColor(new Color(20, 60, 40)); // couleur des axes du quadrillage
        g2.setStroke(pointille); // set parametres pointillé precedement créé
        //dessin du quadrillage
        int nbLineRightY = (width - (width / 2 + this.Xoffset)) / ECHELLE + 1; // nombre d'axe verticale du quadrillage a droit de l'axe y du repere
        int nbLineLeftY = (width / 2 + this.Xoffset) / ECHELLE + 1; // nombre d'axe verticale du quadrillage a gauche de l'axe y du repere
        int nbLineUpX = (height - (height / 2 + this.Yoffset)) / ECHELLE + 1; // nombre d'axe horizontale du quadrillage en haut de l'axe x du repere
        int nbLineDownX = (height / 2 + this.Yoffset) / ECHELLE + 1; // nombre d'axe horizontale du quadrillage en bas de l'axe x du repere
        int coord;
        int i;
        for ( i = 1; i < nbLineRightY; i++) {
            coord = width / 2 + this.Xoffset + i * ECHELLE;
            g.drawLine(coord, 0, coord, height);
        }
        for (i = 1; i < nbLineLeftY; i++) {
            coord = width / 2 + this.Xoffset - i * ECHELLE;
            g.drawLine(coord, 0, coord, height);
        }
        
        for (i = 1; i < nbLineDownX; i++) {
            coord = height / 2 + this.Yoffset - i * ECHELLE;
            g.drawLine(0, coord, width, coord);
        }
        for (i = 1; i < nbLineUpX; i++) {
            coord = height / 2 + this.Yoffset + i * ECHELLE;
            g.drawLine(0, coord, width, coord);
        }        
        g2.setStroke(new BasicStroke()); // on enleve les pointillés 
        if (this.ObjManager != null) {
            this.ObjManager.draw(g, this);
        }   
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            this.Xoffset = this.Xoffset + (x - this.Xold);
            this.Yoffset = this.Yoffset + (y - this.Yold);
            this.Xold = x;
            this.Yold = y;
            this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.Xold = e.getX();
        this.Yold = e.getY();
    }

    public int getCoordX(double x) {
        return (int) Math.round(this.getWidth() / 2 + this.Xoffset + x * ECHELLE);
    }

    public int getCoordY(double y) {
        return (int) Math.round(this.getHeight() / 2 + this.Yoffset - y * ECHELLE);
    }

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
