package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.JPanel;

import shapes.ShapesManager;

/**
 * This class which extends JPanel is the world in which all the shapes will be draw
 */
@SuppressWarnings("serial")
public class World extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * Contains all the shapes of this world 
	 */
	 private ShapesManager sm = new ShapesManager(this);
	 
	 /**
	  * coordinates of the previous local point
	  */
	 private int Xold, Yold;                     
	
	 /**
	  * offset of the view in relation to the center of the marker
	  */
	 private int Xoffset, Yoffset;           	 
	
	 /**
	  * grid spacing
	  */
	 public static int SCALE = 20; 			 
	
	 
	 /**
	  * World's constructor
	  */
	 public World() {
		 super();
		 this.Xoffset = 0;
		 this.Yoffset = 0;
		 this.addMouseListener(this);
		 this.addMouseMotionListener(this);
	 }
   
	 /**
	  * Getter of sm
	  * 
	  * @return the ShapesManager of this world
	  */
	 public ShapesManager getShapesManager() {
		 return this.sm;
	 }
	 
	 /**
	  * This methode is called automatically each time a shape as to be redraw
	  */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int height = this.getHeight();
        int width = this.getWidth();
        g.setColor(Color.GRAY); //  background color
        g.fillRect(0, 0, width, height);
        //drawing of the marker's axes
        g.setColor(Color.BLACK); // color of the marker's axes
        g.drawLine(width / 2 + this.Xoffset, 0, width / 2 + this.Xoffset, height);
        g.drawLine(0, height / 2 + this.Yoffset, width, height / 2 + this.Yoffset);
        //initialization of the dotted lines for the grid
        float[] dash = {1, 4};
        BasicStroke pointille = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, 0);
        g.setColor(new Color(20, 60, 40)); // color of the grid's axes
        g2.setStroke(pointille); // set parameters dotted previously created
        //grid drawing
        int nbLineRightY = (width - (width / 2 + this.Xoffset)) / SCALE + 1; // number of vertical axis of the grid to the right of the y axis of the marker
        int nbLineLeftY = (width / 2 + this.Xoffset) / SCALE + 1; // number of vertical axis of the grid to the left of the y axis of the marker
        int nbLineUpX = (height - (height / 2 + this.Yoffset)) / SCALE + 1; // number of horizontal axis of the grid at the top of the x axis of the marker
        int nbLineDownX = (height / 2 + this.Yoffset) / SCALE + 1; // number of horizontal axis of the grid at the bottom of the x axis of the marker
        int coord;
        int i;
        for ( i = 1; i < nbLineRightY; i++) {
            coord = width / 2 + this.Xoffset + i * SCALE;
            g.drawLine(coord, 0, coord, height);
        }
        for (i = 1; i < nbLineLeftY; i++) {
            coord = width / 2 + this.Xoffset - i * SCALE;
            g.drawLine(coord, 0, coord, height);
        }
        
        for (i = 1; i < nbLineDownX; i++) {
            coord = height / 2 + this.Yoffset - i * SCALE;
            g.drawLine(0, coord, width, coord);
        }
        for (i = 1; i < nbLineUpX; i++) {
            coord = height / 2 + this.Yoffset + i * SCALE;
            g.drawLine(0, coord, width, coord);
        }        
        g2.setStroke(new BasicStroke()); // remove the dotted lines 
        this.sm.draw(g, this); // Draw all the shapes 
        
    }
    
    /**
     * behavior of the mouse when it moves with the button pressed
     */
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

    /**
     * behaviour of the mouse when it presses the button
     */
    @Override
    public void mousePressed(MouseEvent e) {
        this.Xold = e.getX();
        this.Yold = e.getY();
    }

    /**
     * Get the local coordinate of a real abscissa
     * 
     * @param x The real abscissa
     * @return The local abscissa
     */
    public int getCoordX(double x) {
        return (int) Math.round(this.getWidth() / 2 + this.Xoffset + x * SCALE);
    }

    /**
     * Get the local coordinate of a real ordinate
     * 
     * @param y The real ordinate
     * @return The local ordinate
     */
    public int getCoordY(double y) {
        return (int) Math.round(this.getHeight() / 2 + this.Yoffset - y * SCALE);
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
