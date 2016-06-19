import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.Expression;
import java.io.IOException;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	/**
	 * Szerokość okna - wczytywana z pliku
	 */
	public static int WIDTH;
	/**
	 * Wysoko okna - wczytywanie z pliku
	 */
	public static int HIGHTH;;
	/**
	 * Główny wątek gry
	 */
	public static Thread thread;

	/**
	 * Funkcja ustawiająca głwny wątek gry
	 */

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	/**
	 * Boolean decydujący czy gra powinna być odświeżana
	 */
	public static boolean status = false;
	/**
	 * Boolean sprawdzający czy gra została wstrzymana
	 */
	public static boolean pause = false;
	/**
	 * Menager zarządzający tym co aktualnie pojawia się na ekranie (Manu,
	 * plansza gry itp)
	 */

	private StateMenager menager;
	/**
	 * Timer decydujący o częstotliwości odświeżania gry
	 */
	private long targetTime = 1000 / 60;

	/**
	 * Konstruktor klasy GamePanel - startująca grą
	 */

	public GamePanel() {

		addKeyListener(this);
		setFocusable(true);

		setPreferredSize(new Dimension(WIDTH, HIGHTH));
		new Images();
		start();

	}

	/**
	 * Funkcja startująca wątek
	 */
	private void start() {
		status = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Funkcja ustawiająca główną pętlę gry.
	 */
	@Override
	public void run() {

		menager = new StateMenager();
		long start, duration, wait;

		while (status) {
			start = System.nanoTime();

			tick();
			repaint();
			duration = System.nanoTime() - start;
			wait = targetTime / 1000000;

			if (wait <= 0) {
				wait = 5;

			}
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Funkcja updatująca logikę gry
	 */
	public void tick() {
		if (!pause)
			menager.tick();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		menager.draw(g);

	}

	/**
	 * Funkcja odpowiadająca za działania w przypadku naciśnięcia danych
	 * klawiszy
	 */
	public void keyPressed(KeyEvent k) {

		menager.keyPressed(k.getKeyCode());
	}

	/**
	 * Funkcja odpowiadająca za działania w przypadku puszczenia danych klawiszy
	 */
	public void keyReleased(KeyEvent k) {

		menager.keyReleased(k.getKeyCode());
	}

	public void keyTyped(KeyEvent k) {

	}
}
