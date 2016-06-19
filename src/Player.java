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
 * Klasa określajca kolizje gracza, kolizje, oraz zachowania gracza
 */

public class Player {

	/**
	 * Pozycja gracza (piksele)
	 */
	private double x, y;
	/**
	 * Maksymalna szybkość opadania gracza
	 */
	public static double maxfollowSpeed = 3;
	/**
	 * Obecna szybkość opadania gracza
	 */
	private double currentFollowSpeed = 0.2;
	/**
	 * Obecna szybkość pozioma gracza w prawą strone
	 */
	private double currentHorizontalSpeedRight = 0;
	/**
	 * Obecna szybkość pozioma gracza w lewą strone
	 */
	private double currentHorizontalSpeedLeft = 0;
	/**
	 * Obecna szybkość pozioma gracza (ogólnie)
	 */
	private double currentHorizontalSpeedgeneral;
	/**
	 * Szerokość obiektu gracza
	 */
	private int width = 30;
	/**
	 * Wysokość oiektu gracza
	 */
	private int height = 30;
	/**
	 * Nick gracza pobierany z okienka dialogowego
	 */
	public static String nick;
	/**
	 * Sprawdzanie czy obiekt gracza jest w kolizji z platfomą (czy się dotkają)
	 */

	private boolean bottomCollision = false;
	/**
	 * Kierunki poruszania obiektu
	 */
	private boolean right = false, left = false, follow = false, up = false;
	/**
	 * Punkty gracza
	 */

	public static int points = 0;
	/**
	 * Paliwo rakiety
	 */

	private double fuel;

	/**
	 * Konstruktor klasy gracza
	 * 
	 * @param x
	 *            - położenie gracza x
	 * @param y
	 *            - położenie gracza y
	 * @param points
	 *            - punkty gracza
	 */
	public Player(double x, double y, String nick, double fueal) {

		this.x = x;
		this.y = y;
		this.nick = nick;

		this.fuel = fuel;

	}

	/**
	 * Funkcja sprawdzająca czy występuje kolizja z platformami oraz wykonująca
	 * akcje poruszania się obiektu
	 * 
	 * @param platforms
	 *            - tablica platform
	 */

	public void tick(Platform[][] platforms) {

		for (int i = 0; i < platforms.length; i++) {
			for (int j = 0; j < platforms[0].length; j++) {

				if (platforms[i][j].getId() == 1) {
					if (Collision.contain(new Point((int) x + width, (int) y + height), platforms[i][j])
							|| Collision.contain(new Point((int) x, (int) y + height), platforms[i][j]))

					{

						follow = false;
						bottomCollision = true;
						points = (int) (100 + points + Map.lvlFuel);
						Board.lvl = Board.lvl + 1;

						System.out.println("x " + Board.getPlayer().x + "y " + Board.getPlayer().y);

						GameState.menager.states.push(new Board(GameState.menager));
						break;

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

		if (Board.getPlayer().getY() > 440 && currentFollowSpeed * 100 > Map.maxSpeed) {
			GameState.menager.states.push(new Defeat(GameState.menager));
			Defeat.reason = "Prędkość w czesie lądowanie była za duża!";

		}

		bottomCollision = false;

		if (x <= 0) {
			left = false;

		}
		if (x >= 800) {
			right = false;
		}

		if (right) {

			x = x + 0.5;

		}

		if (left) {

			x = x - 0.5;

		}

		if (follow) {
			y += currentFollowSpeed;
			if (currentFollowSpeed < getMaxfollowSpeed()) {
				currentFollowSpeed += Map.gravitation;

			}

		}

		if (!follow) {

			currentFollowSpeed = 0;

		}
		if (up) {
			currentFollowSpeed = currentFollowSpeed - 0.01;
			if (currentFollowSpeed < 0)
				currentFollowSpeed = 0;
			follow = true;
			y = y - 0.5;
		}

	}

	/**
	 * Funkcja rysująca gracza
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
	 * Funkcja decydująca co się dzieje w przypadku wciśnięcja klawisza
	 * sterowania graczem
	 * 
	 * @param k
	 *            - int reprezentujący wciśnięty klawisz
	 */
	public void keyPressed(int k) {

		if (k == KeyEvent.VK_RIGHT) {

			if (Map.lvlFuel > 0) {
				right = true;
				Map.lvlFuel = Map.lvlFuel - 5;
			} else
				right = false;

		}
		if (k == KeyEvent.VK_LEFT) {

			if (Map.lvlFuel > 0) {
				left = true;
				Map.lvlFuel = Map.lvlFuel - 5;
				//fuel = fuel - 5;
			} else
				left = false;
		}

		if (k == KeyEvent.VK_UP) {

			if (Map.lvlFuel> 0) {

				up = true;
				//fuel = fuel - 5;
				Map.lvlFuel = Map.lvlFuel - 5;
			} else
				up = false;
		}

		if (k == KeyEvent.VK_P) {
			GamePanel.pause = true;
			Pause p = new Pause(GameState.menager);
			p.setPauseFrame();
			System.out.println("lol");

		}
		if (k == KeyEvent.VK_O) {

		}

	}

	/**
	 * Funkcja decydująca co się dzieje w przypadkupuszczenia klawisza
	 * sterowania graczem
	 * 
	 * @param k
	 *            - int reprezentujący puszczony klawisz
	 */
	public void keyRealassed(int k) {
		if (k == KeyEvent.VK_RIGHT) {
			right = false;
			currentHorizontalSpeedRight = 0;

		}
		if (k == KeyEvent.VK_LEFT) {
			left = false;
			currentHorizontalSpeedLeft = 0;
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

	public static int getPoints() {
		return points;
	}

	public static void setPoints(int points) {
		Player.points = points;
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

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public double getCurrentFollowSpeed() {
		return currentFollowSpeed;
	}

	public void setCurrentFollowSpeed(double currentFollowSpeed) {
		this.currentFollowSpeed = currentFollowSpeed;
	}

	public double getCurrentHorizontalSpeedRight() {
		return currentHorizontalSpeedRight;
	}

	public void setCurrentHorizontalSpeedRight(double currentHorizontalSpeedRight) {
		this.currentHorizontalSpeedRight = currentHorizontalSpeedRight;
	}

	public double getCurrentHorizontalSpeedLeft() {
		return currentHorizontalSpeedLeft;
	}

	public void setCurrentHorizontalSpeedLeft(double currentHorizontalSpeedLeft) {
		this.currentHorizontalSpeedLeft = currentHorizontalSpeedLeft;
	}

	public double getCurrentHorizontalSpeedgeneral() {
		return currentHorizontalSpeedgeneral;
	}

	public void setCurrentHorizontalSpeedgeneral(double currentHorizontalSpeedgeneral) {
		this.currentHorizontalSpeedgeneral = currentHorizontalSpeedgeneral;
	}

}
