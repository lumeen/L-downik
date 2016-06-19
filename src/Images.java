import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Klasa definiująca zasoby graficzne.
 */
public class Images {
	/** Tablica z obrazami bloków */
	public static BufferedImage[] blocks;
	/** Tablica z obrazem tła */
	public static BufferedImage[] background;
	/** Tablica z obrazami gracza (rakiety) */
	public static BufferedImage[] player;

	/**
	 * Kontruktor klasy zasobów graficznych. Wczytuje obrazki dla kbloków tła,
	 * gracza
	 */
	public Images() {

		blocks = new BufferedImage[1];
		background = new BufferedImage[1];
		player = new BufferedImage[1];

		try {
			blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Images/platform.png"));
			background[0] = ImageIO.read(getClass().getResourceAsStream("/Images/bakground.png"));
			player[0] = ImageIO.read(getClass().getResourceAsStream("/Images/rakieta.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
