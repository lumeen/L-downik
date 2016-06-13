import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Board extends GameState {
	/**
	 * Obiekt gracza
	 */
	private static Player player; 
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

		player=new Player(30,0,Menu.name,0);	
		setPlayer(player);
		map = new Map("/maps/map1.map");
		System.out.println(player.nick);
		

	}
	/**
	 * Funkcja aktualizuj�ca logik� gry
	 */
	@Override
	public void tick() {
		
		getPlayer().tick(map.getBlocks());
	}
	/**
	 * Funkcja odpowiadaj�ca za rysowanie element�w
	 */
	@Override
	public void draw(Graphics g) {

		getPlayer().draw(g);
		map.draw(g);
		
		
	}
	/**
	 * Funkcja odpowiadaj�ca za naci�niecie przycisku 
	 */
	@Override
	public void keyPressed(int k) {

		getPlayer().keyPressed(k);
	}
	/**
	 * Funkcja odpowiadaj�ca za puszczenie przycisku 
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


}
