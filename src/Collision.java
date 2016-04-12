import com.sun.javafx.scene.paint.GradientUtils.Point;


/**
 * Klasa okreœlaj¹ca kolizje gracza z obiektami na mapie.
 */


public class Collision {
	
	/**
	 * Metoda okreœlaj¹ca czy zachodzi kolizja miêdzy graczem a klockiem.
	 * @param p - po³o¿enie gracza (Point)
	 * @param pl - obiekt platformy
	 * @return kolizja zachodzi (true) lub nie (false)
	 */
	
	
	
	
	public static boolean contain (java.awt.Point p, Platform pl){
		
		return pl.contains(p);
		
	}

}
