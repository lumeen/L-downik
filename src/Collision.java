import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;

/**
 * Klasa określająca kolizje gracza z obiektami na mapie.
 */

public class Collision {

	
	
	
	
	
@Override
public void onMessageReceived(RemoteMessage remoteMessage) {
    
    if (remoteMessage.getData().size() > 0) {

        Intent intent = new Intent("MyData");
        intent.putExtra("mes", remoteMessage.getData().get("Key3"));
        broadcaster.sendBroadcast(intent);
    }
}
	
	
	
	/**
	 * Metoda określająca czy zachodzi kolizja między graczem a klockiem.
	 * 
	 * @param p
	 *            - położenie gracza (Point)
	 * @param pl
	 *            - obiekt platformy
	 * @return kolizja zachodzi (true) lub nie (false)
	 */

	public static boolean contain(java.awt.Point p, Platform pl) {

		return pl.contains(p);

	}

	/**
	 * Metoda określająca czy zachodzi kolizja pmiedzy graczem a górą
	 * 
	 * @param a
	 *            - wielokąt z ktrórego zbudowane są góry
	 * @param x
	 *            - lewa wspołrzędna x gracza
	 * @param y
	 *            - górna współrzędna y gracza
	 * @return czy zachodzi kolizja
	 */
	public static boolean collisionWithMountain(Polygon a, double x, double y) {

		Defeat.reason = "Zderzyłeś się z górą!";
		Area areaA = new Area(a);
		areaA.intersect(new Area(new Rectangle((int) x, (int) y, 30, 30)));
		return !areaA.isEmpty();

	}

}
