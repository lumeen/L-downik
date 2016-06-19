import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Klasa odpowiadająca za wyświetlanie listy najlepszych wyników
 */
public class HighScoreView extends GameState {
	/**
	 * Konstruktor klasy HighScoreView
	 */
	public HighScoreView(StateMenager menager) {
		super(menager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	/**
	 * Klasa odpowiadająca za rysowanie listy najlpeszych wyników
	 */
	@Override
	public void draw(Graphics g) {
		HighscoreManager hm = new HighscoreManager();

		g.setColor(new Color(23, 20, 71));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HIGHTH);
		g.setColor(new Color(10, 71, 0));
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		for (int i = 0; i < 10; i++) {
			g.drawString(i + 1 + ". " + hm.getScores().get(i).getNaam() + " " + hm.getScores().get(i).getScore(),
					GamePanel.WIDTH / 2 - 50, 100 + 30 * i);
		}

		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Aby powrócić do menu glównego wciśnij przycisk M", 200, 450);

	}

	/**
	 * Funkcja odpowiadająca za nacięniecie przycisku
	 */
	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		if (k == KeyEvent.VK_M) {

			GameState.menager.states.push(new Menu(GameState.menager));
		}

	}

	/**
	 * Funkcja odpowiadająca za puszcanie przycisku
	 */
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
