package shapes;

import java.awt.Color;

/**
 * This class is usefull to convert a color from string format to awt.Color
 */
public class MyColor {
    
	/**
	 * The converted color
	 */
	private Color color = null;

	/**
	 * Allow to convert a color from string format to awt.Color
	 * 
	 * @param col The color in string format to be converted in awt.Color
	 * @return the converted color
	 */
	public Color getColor(String col) {
	    switch (col.toLowerCase()) {
	    case "black":
	        color = Color.BLACK;
	        break;
	    case "blue":
	        color = Color.BLUE;
	        break;
	    case "green":
	        color = Color.GREEN;
	        break;
	    case "yellow":
	        color = Color.YELLOW;
	        break;
	    case "red":
	        color = Color.RED;
	        break;
	    case "cyan":
	        color = Color.CYAN;
	        break;
	    }
		return color;
	}
}