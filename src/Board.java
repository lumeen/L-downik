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
 	
 	public static int lvl=1;
 	
 	Random generator=new Random();
 
	public Board(StateMenager menager) {
		super(menager);

	}

	@Override
	public void init() {
		

		player=new Player(30,0,Menu.name,100);	
		setPlayer(player);
		map = new Map("/maps/map" + lvl+ ".map");
	//	System.out.println(lvl);
		

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
		g.setColor(new Color(235, 23, 23));
		g.drawString("Paliwo: "+String.valueOf(player.getFuel()), 600, 20);
		g.drawString("Prędkość spadnia: "+ Integer.valueOf((int) (player.getCurrentFollowSpeed()*100)), 600, 40);
	//	g.drawString("Prędkośc pozioma "+ Integer.valueOf((int)(player.getCurrentHorizontalSpeedgeneral()*100)), 600, 60);
		g.setColor(new Color(10, 71, 0));
		g.drawString("Twój wynik to " + Player.getPoints() + " pkt",600, 60);
		
	}
	/**
	 * Funkcja odpowiadająca za nacicnięcie przycisku 
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
	
	public static int randInt(int min, int max) {

	   
	    Random rand=new Random();

	   
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}


}
