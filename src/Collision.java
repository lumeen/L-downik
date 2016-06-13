

/**
 * Klasa okre�laj�ca kolizje gracza z obiektami na mapie.
 */


public class Collision {
	
	/**
	 * Metoda okre�laj�ca czy zachodzi kolizja mi�dzy graczem a klockiem.
	 * @param p - po�o�enie gracza (Point)
	 * @param pl - obiekt platformy
	 * @return kolizja zachodzi (true) lub nie (false)
	 */
	
	
	
	
	public static boolean contain (java.awt.Point p, Platform pl){
		
		return pl.contains(p);
		
	}

}
