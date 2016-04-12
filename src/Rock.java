import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Klasa reprezentuj�ca ska�y, czyli miejsce gdzie rakieta nie mo�e wyl�dowa�
 */
public class Rock extends Rectangle {
	private static final long serialVersionUID = 1L;
	/**
	 * Szeroko�� jednej "jednostki" ska�y
	 */
	public static int rockWidth = 25;
	/**
	 * Wysoko��jednej "jednostki" ska�y
	 */
	public static int rockHight = 25;
	/**
	 * Id
	 */
	private int id;
	/**
	 * Kokstruktor klasy Ska�a ustawiaj�cy parametry ska�y
	 * @param x - po�o�enie x ska�y
	 * @param y - po�o�enie y ska�y
	 * @param id - id ska�y
	 */
	public Rock (int x, int y, int id) {
		setBounds(x, y, rockWidth, rockWidth);
		this.id = id;

		/**
		 * Funkcja rysuj�ca ska��
		 * @param g - graphic
		 */
	}
	public void draw(Graphics g) {
		if (id == 2) {
			g.drawImage(Images.rock[0], x,y,width,height,null);
			
			
				
			}
	
	}
}
