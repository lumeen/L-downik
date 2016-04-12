import java.awt.Color;
import java.awt.Graphics;

public class Board extends GameState {
	/**
	 * Obiekt gracza
	 */
	private Player player; 
	/**
	 * Tablica obiekt�w platform
	 */
	public Platform[] platforms;
	/**
	 * Tablica obiekt�w ska�
	 */
	public Rock [] rocks;
	/**
	 * Obiekt mapy
	 */
 	private Map map;

 	/**
 	 * Konstruktor klasy Board - przys�oni�cie konstruktora StateMenager
 	 */
	public Board(StateMenager menager) {
		super(menager);

	}

	@Override
	public void init() {

		player = new Player(300, 30);
		map = new Map("/maps/map1.map");
		

	}
	/**
	 * Funkcja aktualizuj�ca logik� gry
	 */
	@Override
	public void tick() {
		StateMenager s=new StateMenager();
		player.tick(map.getBlocks());
	}
	/**
	 * Funkcja odpowiadaj�ca za rysowanie element�w
	 */
	@Override
	public void draw(Graphics g) {

		player.draw(g);
		map.draw(g);
		
		
	}
	/**
	 * Funkcja odpowiadaj�ca za naci�niecie przycisku 
	 */
	@Override
	public void keyPressed(int k) {

		player.keyPressed(k);
	}
	/**
	 * Funkcja odpowiadaj�ca za puszczenie przycisku 
	 */
	@Override
	public void keyReleased(int k) {
		player.keyRealassed(k);

	}

}
