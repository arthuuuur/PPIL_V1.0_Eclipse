package graphics2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class World2D extends JPanel implements MouseListener, MouseMotionListener {

  
	 private ObjectManager pom = new ObjectManager(this);     // gestionnaire d'objets graphiques
	 private int xold, yold;                    			  // coordonnées du point local précédent
	 private double offsetX, offsetY;           			  // décalage de la vue
	 public static double ECHELLE = 200;                      // échelle de la vue
	 public static double ECHELLE_BASE = 10.;  			      // échelle de base
	 private static double stepX = 1, stepY = 1; 			  // pas des quadrillages sens X et sens Y
	
	 public World2D() {
		 super();
		 this.offsetX = 0;
		 this.offsetY = 0;
		 this.addMouseListener(this);
		 this.addMouseMotionListener(this);
	 }
   
	 public ObjectManager getPom() {
		 return this.pom;
	 }
	 
    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        int h = this.getHeight();
        int w = this.getWidth();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, w, h);
        //tracé des axes et du quadrillage
        int roundOffsetX = (int) Math.round(this.offsetX);
        int roundOffsetY = (int) Math.round(this.offsetY);
        int localStepX = (int) Math.round(ECHELLE / ECHELLE_BASE * stepX);
        int localStepY = (int) Math.round(ECHELLE / ECHELLE_BASE * stepY);
        g.setColor(Color.BLACK);
        g.drawLine(w / 2 + roundOffsetX, 0, w / 2 + roundOffsetX, h);
        g.drawLine(0, h / 2 + roundOffsetY, w, h / 2 + roundOffsetY);
        int offsetStrokeX = 7 - roundOffsetX % 7;
        int offsetStrokeY = 7 - roundOffsetY % 7;
        float[] dash = {2, 5};
        BasicStroke bsX = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, offsetStrokeX);
        BasicStroke bsY = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, offsetStrokeY);
        g.setColor(new Color(60, 85, 60));
        g2.setStroke(bsY);
        int nbxp = (w - (w / 2 + roundOffsetX)) / localStepX + 1;
        int nbxm = (w / 2 + roundOffsetX) / localStepX + 1;
        for (int i = 1; i < nbxp; i++) {
            int xline = w / 2 + roundOffsetX + (int) Math.round(i * stepX * ECHELLE / ECHELLE_BASE);
            g.drawLine(xline, 0, xline, h);
        }
        for (int i = 1; i < nbxm; i++) {
            int xline = w / 2 + roundOffsetX - (int) Math.round(i * stepX * ECHELLE / ECHELLE_BASE);
            g.drawLine(xline, 0, xline, h);
        }
        g2.setStroke(bsX);
        int nbym = (h - (h / 2 + roundOffsetY)) / localStepY + 1;
        int nbyp = (h / 2 + roundOffsetY) / localStepY + 1;
        for (int i = 1; i < nbyp; i++) {
            int yline = h / 2 + roundOffsetY - (int) Math.round(i * stepY * ECHELLE / ECHELLE_BASE);
            g.drawLine(0, yline, w, yline);
        }
        for (int i = 1; i < nbym; i++) {
            int yline = h / 2 + roundOffsetY + (int) Math.round(i * stepY * ECHELLE / ECHELLE_BASE);
            g.drawLine(0, yline, w, yline);
        }        
        g2.setStroke(new BasicStroke());
        if (this.pom != null) {
            this.pom.draw(g, this);
        }   
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
            int x = e.getX();
            int y = e.getY();

            this.offsetX = this.offsetX + (x - this.xold);
            this.offsetY = this.offsetY + (y - this.yold);

            this.xold = x;
            this.yold = y;

            this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.xold = e.getX();
        this.yold = e.getY();
    }

    public int getLocalCoordX(double x) {
        return (int) Math.round(this.getWidth() / 2 + this.offsetX + x * ECHELLE / ECHELLE_BASE);
    }

    public int getLocalCoordY(double y) {
        return (int) Math.round(this.getHeight() / 2 + this.offsetY - y * ECHELLE / ECHELLE_BASE);
    }

    public double getRealCoordX(double x) {
        return (x - (this.getWidth() / 2 + this.offsetX)) * ECHELLE_BASE / ECHELLE;
    }

    public double getRealCoordY(double y) {
        return (y - (this.getHeight() / 2 + this.offsetY)) * -ECHELLE_BASE / ECHELLE;
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
