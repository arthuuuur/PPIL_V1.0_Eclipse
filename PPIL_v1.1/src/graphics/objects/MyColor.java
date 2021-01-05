package graphics.objects;

import java.awt.Color;

public class MyColor {
    
	private Color color;

    public MyColor(){
    	color = Color.CYAN;
    }

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
	    default:
	    	System.out.println("La couleur "+ col + " n'est pas disponible, le cyan a été choisi par défaut");
	    }
		return color;
	}
}