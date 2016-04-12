import java.awt.Color;
import java.awt.Graphics;

public class Board extends GameState {
	/**
	 * Obiekt gracza
	 */
	private Player player; 
	/**
	 * Tablica obiektów platform
	 */
	public Platform[] platforms;
	/**
	 * Tablica obiektów ska³
	 */
	public Rock [] rocks;
	/**
	 * Obiekt mapy
	 */
 	private Map map;

 	/**
 	 * Konstruktor klasy Board - przys³oniêcie konstruktora StateMenager
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
	 * Funkcja aktualizuj¹ca logikê gry
	 */
	@Override
	public void tick() {
		StateMenager s=new StateMenager();
		player.tick(map.getBlocks());
	}
	/**
	 * Funkcja odpowiadaj¹ca za rysowanie elementów
	 */
	@Override
	public void draw(Graphics g) {

		player.draw(g);
		map.draw(g);
		
		
	}
	/**
	 * Funkcja odpowiadaj¹ca za naciœniecie przycisku 
	 */
	@Override
	public void keyPressed(int k) {

		player.keyPressed(k);
	}
	/**
	 * Funkcja odpowiadaj¹ca za puszczenie przycisku 
	 */
	@Override
	public void keyReleased(int k) {
		player.keyRealassed(k);

	}

}
