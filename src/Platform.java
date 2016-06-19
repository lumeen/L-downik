import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Klasa reprezentująca platformę londowiska
 */
public class Platform extends Rectangle {
	/**
	 * Szerokośc platformy
	 */
	public static int platformWidth = 25;
	/**
	 * Wysokość platformy
	 */
	public static int platformHight = 25;
	/**
	 * ID platformy używanie do konfiguracji mapy(położenia lądowiska)
	 */
	private int id;

	/**
	 * Kokstruktor klasy Platforma ustawiaj�cy parametry platformy
	 * 
	 * @param x
	 *            - położenie x platformy
	 * @param y
	 *            - położenie y platformy
	 * @param id
	 *            - id platformy
	 */
	public Platform(int x, int y, int id) {
		setBounds(x, y, platformWidth, platformHight);
		this.id = id;

	}

	/**
	 * Funkcja rysująca platformy
	 * 
	 * @param g
	 *            - graphic
	 */
	public void draw(Graphics g) {
		if (id == 1) {
			g.drawImage(Images.blocks[id - 1], x, y, width, height, null);

		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
