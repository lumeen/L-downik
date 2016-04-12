import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Klasa reprezentuj¹ca platformê londowiska
 */
public class Platform extends Rectangle {
	/**
	 * Szerokoœc platformy
	 */
	public static int platformWidth = 25;
	/**
	 * Wysokoœæ platformy
	 */
	public static int platformHight = 25;
	/**
	 * ID platformy u¿ywanie do konfiguracji mapy(po³o¿enia londowiska)
	 */
	private int id;
	/**
	 * Kokstruktor klasy Platforma ustawiaj¹cy parametry platformy
	 * @param x - po³o¿enie x platformy
	 * @param y - po³o¿enie y platformy
	 * @param id - id platformy
	 */
	public Platform(int x, int y, int id) {
		setBounds(x, y, platformWidth, platformHight);
		this.id = id;

	}
	/**
	 * Funkcja rysuj¹ca platformy
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
