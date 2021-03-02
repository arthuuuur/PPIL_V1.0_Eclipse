package cor;

import graphics.objects.DrawableShapes;
import graphics2D.Window;

public abstract class DetecteurForme {

	private DetecteurForme suivant = null;
	
	public DetecteurForme() {}
	
	public void setSuivant(DetecteurForme d) {
		suivant = d;
	}
	
	public DetecteurForme(DetecteurForme suivant) {
		this.suivant = suivant;
	}
	
	public int indexOf(String[] data, String val ) {
		for (int i = 0; i < data.length; i ++) {
			if(data[i].matches(val)) {
				return i;
			}
		}
		return -1;
	}
	
	public abstract boolean estDetectee(String requete);
	public abstract DrawableShapes deserialize(String requete);
	
	public void detecter(String requete, Window W){
		if(estDetectee(requete)) {
			W.getWorld().getObjManager().addObject(deserialize(requete));
		}
		else if(suivant != null)
			suivant.detecter(requete, W);
		else
			System.out.println("La requete ne correspond à aucune forme connue");
	}
}
