import com.sun.javafx.scene.paint.GradientUtils.Point;


/**
 * Klasa określająca kolizje gracza z obiektami na mapie.
 */


public class Collision {
	
	/**
	 * Metoda określająca czy zachodzi kolizja między graczem a klockiem.
	 * @param p - położenie gracza (Point)
	 * @param pl - obiekt platformy
	 * @return kolizja zachodzi (true) lub nie (false)
	 */
	
	
	
	
	public static boolean contain (java.awt.Point p, Platform pl){
		
		return pl.contains(p);
		
	}

}
