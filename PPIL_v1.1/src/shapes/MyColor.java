package shapes;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is usefull to convert a color from string format to awt.Color
 */
public class MyColor {
    
	private static Map<String, Color> availableColor = new HashMap<String, Color>();
	static {
		availableColor.put("black", Color.BLACK);
		availableColor.put("red", Color.RED);
		availableColor.put("green", Color.GREEN);
		availableColor.put("cyan", Color.CYAN);
		availableColor.put("blue", Color.BLUE);
		availableColor.put("yellow", Color.YELLOW);
	}

	/**
	 * Allow to convert a color from string format to awt.Color thanks to the Map
	 * 
	 * @param col The color in string format to be converted in awt.Color
	 * @return the converted color
	 */
	public Color getColor(String col) {
	    col.toLowerCase();
	    return availableColor.get(col);
	}
}