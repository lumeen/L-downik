import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;

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
	
	
	
	/**
	 * Metoda określająca czy zachodzi kolizja pmiedzy graczem a górą
	 * @param a - wielokąt z ktrórego zbudowane są góry
	 * @param x - lewa wspołrzędna x gracza
	 * @param y - górna współrzędna y gracza
	 * @return czy zachodzi kolizja
	 */
	public static boolean collisionWithMountain(Polygon a, double x, double y){
		
		Area areaA = new Area(a);
		   areaA.intersect(new Area(new Rectangle((int) x, (int) y, 30, 30)));
		   return !areaA.isEmpty();
			   
			
		
		
		
		
		
	}

}
