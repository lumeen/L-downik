import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Board extends GameState {
	/**
	 * Obiekt gracza
	 */
	private static Player player;
	/**
	 * Tablica obiektów platform
	 */
	public Platform[] platforms;
	/**
	 * Obiekt mapy
	 */
	private Map map;
	/**
	 * Number obecnego levela
	 */
	public static int lvl = 1;
	/**
	 * Generator liczb losowych, do losowania początkowej pozycji rakiety
	 */
	Random generator = new Random();

	/**
	 * Konstruktor klasy Board
	 */
	public Board(StateMenager menager) {
		super(menager);

	}

	@Override
	public void init() {

		player = new Player((double) (randInt(50, 750)), 0, Menu.name, Map.lvlFuel);
		setPlayer(player);
		map = new Map("/maps/map" + lvl + ".map");

	}

	/**
	 * Funkcja aktualizujuca logikę gry
	 */
	@Override
	public void tick() {
		System.out.println();

		getPlayer().tick(map.getBlocks());
	}

	/**
	 * Funkcja odpowiadająca za rysowanie elementów
	 */
	@Override
	public void draw(Graphics g) {

		getPlayer().draw(g);
		map.draw(g);
		g.setColor(new Color(235, 23, 23));
		g.drawString("Paliwo: " + Map.lvlFuel, 600, 20);
		g.drawString("Prędkość spadnia: " + Integer.valueOf((int) (player.getCurrentFollowSpeed() * 100)), 600, 40);
		
		g.setColor(new Color(10, 71, 0));
		g.drawString("Dopuszcz. pręd. spadania: " + Map.maxSpeed, 600, 60);
		g.drawString("Twój wynik to " + Player.getPoints() + " pkt", 600, 80);
		g.drawString("Grawitacja: " +Map.gravitation*1000, 600, 100);

	}

	/**
	 * Funkcja odpowiadająca za nacicnięcie przycisku
	 */
	@Override
	public void keyPressed(int k) {

		getPlayer().keyPressed(k);
	}

	/**
	 * Funkcja odpowiadająca za puszczenie przycisku
	 */
	@Override
	public void keyReleased(int k) {
		getPlayer().keyRealassed(k);

	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		Board.player = player;
	}

	/**
	 * Funkcja odpowiadająca za obliczenie początkowej pozycji gracza
	 * 
	 * @param min
	 *            - wartość początkowa przedziału, z którego loswane będą liczby
	 * @param max
	 *            - wartość końcowa przedziału, z którego loswane będą liczby
	 * @return randomNum - liczba losowa z przedziału (min;max) - integer
	 */
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
