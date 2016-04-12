import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Klasa reprezentuj¹ca ska³y, czyli miejsce gdzie rakieta nie mo¿e wyl¹dowaæ
 */
public class Rock extends Rectangle {
	private static final long serialVersionUID = 1L;
	/**
	 * Szerokoœæ jednej "jednostki" ska³y
	 */
	public static int rockWidth = 25;
	/**
	 * Wysokoœæjednej "jednostki" ska³y
	 */
	public static int rockHight = 25;
	/**
	 * Id
	 */
	private int id;
	/**
	 * Kokstruktor klasy Ska³a ustawiaj¹cy parametry ska³y
	 * @param x - po³o¿enie x ska³y
	 * @param y - po³o¿enie y ska³y
	 * @param id - id ska³y
	 */
	public Rock (int x, int y, int id) {
		setBounds(x, y, rockWidth, rockWidth);
		this.id = id;

		/**
		 * Funkcja rysuj¹ca ska³ê
		 * @param g - graphic
		 */
	}
	public void draw(Graphics g) {
		if (id == 2) {
			g.drawImage(Images.rock[0], x,y,width,height,null);
			
			
				
			}
	
	}
}
