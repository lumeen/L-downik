import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;

/**
 * Klasa okre�laj�ca kolizje gracza z obiektami na mapie.
 */

public class Player {

	/**
	 * Pozycja gracza (piksele)
	 */
	private double x, y;
	/**
	 * Maksymalna szybko�� opadania gracza
	 */
	public static double maxfollowSpeed = 3;
	/**
	 * Obecna szybko�� opadania gracza
	 */
	private double currentFollowSpeed = 0.1;
	/**
	 * Szeroko�� obiektu gracza
	 */
	private int width = 30;
	/**
	 * Wysoko�� oiektu gracza
	 */
	private int height = 30;
	/**
	 * Nick gracza pobierany z okienka dialogowego
	 */
	public static String nick ;
	/**
	 * Sprawdzanie czy obiekt gracza jest w kolizji z platfom� (czy si� dotkaj�)
	 */

	private boolean bottomCollision = false;
	/**
	 * Kierunki poruszania obiektu
	 */
	private boolean right = false, left = false, follow = false, up = false;

	private int points = 0;

	/**
	 * Konstruktor klasy gracza
	 * 
	 * @param x
	 *            - po�o�enie gracza x
	 * @param y
	 *            - po�o�enie gracza y
	 * @param points
	 *            - punkty gracza
	 */
	public Player(double x, double y, String nick, int points) {

		this.x = x;
		this.y = y;
		this.nick=nick;
		this.points=points;
		
	}

	/**
	 * Funkcja sprawdzaj�ca czy wyst�puj� kolizj� z platformami oraz wykonuj�ca
	 * akcje poruszania si� obiektu
	 * 
	 * @param platforms
	 *            - tablica platform
	 */

	public void tick(Platform[][] platforms) {

		System.out.println(100 * currentFollowSpeed);
		for (int i = 0; i < platforms.length; i++) {
			for (int j = 0; j < platforms[0].length; j++) {

				if (platforms[i][j].getId() == 1) {
					if (Collision.contain(new Point((int) x + width, (int) y + height), platforms[i][j])
							|| Collision.contain(new Point((int) x, (int) y + height), platforms[i][j]))

					{

						follow = false;
						bottomCollision = true;
						if(currentFollowSpeed<100){
						Board.getPlayer().points=+100;
						System.out.println(Board.getPlayer().points);}
					} else if (!bottomCollision) {
						follow = true;
					}

					if (Collision.contain(new Point((int) x + width, (int) y), platforms[i][j])
							|| Collision.contain(new Point((int) x, (int) y), platforms[i][j]))

					{

						follow = false;
					}

				}

			}
		}

		bottomCollision = false;

		if (x <= 0) {
			left = false;

		}
		if (x >= 800) {
			right = false;
		}

		if (right)
			x++;

		if (left)

			x--;

		if (follow) {
			y += currentFollowSpeed;
			if (currentFollowSpeed < getMaxfollowSpeed()) {
				currentFollowSpeed += 0.005;

			}

		}

		if (!follow) {

			currentFollowSpeed = 0;

		}
		if (up) {
			currentFollowSpeed = currentFollowSpeed - 0.01;
			follow = false;
			y = y - 0.5;
		}

	}

	/**
	 * Funkcja rysuj�ca gracza
	 * 
	 * @param g
	 *            - graphics
	 */

	public void draw(Graphics g) {
		g.drawImage(Images.background[0], 0, 0, 800, 600, null);
		g.setColor(Color.BLACK);
		g.drawImage(Images.player[0], (int) x, (int) y, width, height, null);

	}

	/**
	 * Funkcja decyduj�ca co si� dzieje w przypadku wci�ni�cja klawisza
	 * sterowania graczem
	 * 
	 * @param k
	 *            - int reprezentuj�cy wci�ni�ty klawisz
	 */
	public void keyPressed(int k) {

		if (k == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (k == KeyEvent.VK_LEFT) {
			left = true;
		}

		if (k == KeyEvent.VK_UP) {

			up = true;
		}

	}

	/**
	 * Funkcja decyduj�ca co si� dzieje w przypadkupuszczenia klawisza
	 * sterowania graczem
	 * 
	 * @param k
	 *            - int reprezentuj�cy puszczony klawisz
	 */
	public void keyRealassed(int k) {
		if (k == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (k == KeyEvent.VK_LEFT) {
			left = false;
		}

		if (k == KeyEvent.VK_UP) {

			up = false;
		}

	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	

	public static String getNick() {
		return nick;
	}

	public static void setNick(String nick) {
		Player.nick = nick;
	}

	public static double getMaxfollowSpeed() {
		return maxfollowSpeed;
	}

	public static void setMaxfollowSpeed(double maxfollowSpeed) {
		Player.maxfollowSpeed = maxfollowSpeed;
	}
	

}
