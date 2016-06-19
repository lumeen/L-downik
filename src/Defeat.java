import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Klasa wyświetlająca ekran gdy gracz przegra
 */
public class Defeat extends GameState {
	/**
	 * Powód porażki
	 */
	public static String reason = "";

	/**
	 * Konstruktor klasy Defeat
	 */

	public Defeat(StateMenager menager) {
		super(menager);

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

		HighscoreManager hm = new HighscoreManager();
		hm.addScore(Board.getPlayer().getNick(), Player.getPoints());

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	/**
	 * Funkcja rysująca na ekranie informacje oporażce
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(23, 20, 71));

		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HIGHTH);

		g.setFont(new Font("Arial", Font.PLAIN, 80));
		g.setColor(new Color(202, 10, 10));
		g.drawString("Porażka", 250, 100);
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.setColor(new Color(10, 71, 0));
		g.drawString(reason, 10, 250);
		g.drawString("Twój wynik to " + Player.getPoints() + " pkt", 10, 300);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Aby powrócić do menu glównego wciśnij przycisk M", 180, 450);

	}

	/**
	 * Funkcja odpowiadająca za działania w przypadku naciśnięcia danych
	 * klawiszy
	 */
	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_M)
			GameState.menager.states.push(new Menu(GameState.menager));

	}

	/**
	 * Funkcja odpowiadająca za działania w przypadku puszczenia danych klawiszy
	 */
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
