import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Klasa definiuj�ca zasoby graficzne.
 */
public class Images {
	/** Tablica z obrazami blok�w */
	public static BufferedImage[] blocks;
	/** Tablica z obrazem t�a */
	public static BufferedImage[] background;
	/** Tablica z obrazami gracza (rakiety) */
	public static BufferedImage[] player;
	/** Tablica z obrazami ska� */
	public static BufferedImage[] rock;
	public static BufferedImage[] shapes;
	
	/**
	 * Kontruktor klasy zasob�w graficznych.
	 * Wczytuje obrazki dla kblok�w t�a, ska�, gracza
	 */
public Images(){
	
	blocks= new BufferedImage[1];
	background= new BufferedImage[1];
	player= new BufferedImage[1];
	rock= new BufferedImage[1];
	shapes= new BufferedImage[1];
	
	try {
		blocks[0]= ImageIO.read(getClass().getResourceAsStream("/Images/Block.jpg"));
		background[0]=ImageIO.read(getClass().getResourceAsStream("/Images/Background.jpg"));
		player[0]=ImageIO.read(getClass().getResourceAsStream("/Images/Player.jpg"));
		rock[0]=ImageIO.read(getClass().getResourceAsStream("/Images/Black.png"));
	
	
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
}
