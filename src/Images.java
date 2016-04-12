import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Klasa definiuj¹ca zasoby graficzne.
 */
public class Images {
	/** Tablica z obrazami bloków */
	public static BufferedImage[] blocks;
	/** Tablica z obrazem t³a */
	public static BufferedImage[] background;
	/** Tablica z obrazami gracza (rakiety) */
	public static BufferedImage[] player;
	/** Tablica z obrazami ska³ */
	public static BufferedImage[] rock;
	
	/**
	 * Kontruktor klasy zasobów graficznych.
	 * Wczytuje obrazki dla kbloków t³a, ska³, gracza
	 */
public Images(){
	
	blocks= new BufferedImage[1];
	background= new BufferedImage[1];
	player= new BufferedImage[1];
	rock= new BufferedImage[1];
	
	try {
		blocks[0]= ImageIO.read(getClass().getResourceAsStream("/Images/Block.jpg"));
		background[0]=ImageIO.read(getClass().getResourceAsStream("/Images/Background.jpg"));
		player[0]=ImageIO.read(getClass().getResourceAsStream("/Images/Rocket2.jpg"));
		rock[0]=ImageIO.read(getClass().getResourceAsStream("/Images/Black.png"));
	
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
}
