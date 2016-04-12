import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Klasa reprezentuj�ca platform� londowiska
 */
public class Platform extends Rectangle {
	/**
	 * Szeroko�c platformy
	 */
	public static int platformWidth = 25;
	/**
	 * Wysoko�� platformy
	 */
	public static int platformHight = 25;
	/**
	 * ID platformy u�ywanie do konfiguracji mapy(po�o�enia londowiska)
	 */
	private int id;
	/**
	 * Kokstruktor klasy Platforma ustawiaj�cy parametry platformy
	 * @param x - po�o�enie x platformy
	 * @param y - po�o�enie y platformy
	 * @param id - id platformy
	 */
	public Platform(int x, int y, int id) {
		setBounds(x, y, platformWidth, platformHight);
		this.id = id;

	}
	/**
	 * Funkcja rysuj�ca platformy
	 * @param g - graphic
	 */
	public void draw(Graphics g) {
		if (id == 1) {
			g.drawImage(Images.blocks[id-1], x,y,width,height,null);
			
			
				
			}
	
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
