import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.Expression;
import java.io.IOException;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	/**
	 * Szerokoœæ okna -  wczytywana z pliku
	 */
	public static int WIDTH ;
	/**
	 * Wysokoœæ platformy
	 */
	public static int HIGHTH ;;
	/**
	 * G³ówny w¹tek gry
	 */
	private Thread thread;
	
	/**
	 *Funkcja ustawiaj¹ca gówny w¹tek gry
	 */

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	/**
	 * Boolean decyduj¹cy czy gra powinna byæ odœwie¿ana
	 */
	public static boolean status = false;
	/**
	 * Menager zarz¹dzaj¹cy tym co aktualnie poawia siê na ekranie (Manu, plansza gry itp)
	 */
	private StateMenager menager;
	/**
	 *Timer decyduj¹cy o czêstoœæi odœwie¿ania gry
	 */
	private long targetTime = 1000 / 60;
	/**
	 * Konstruktor klasy GamePanel - startuj¹ca grê
	 */
	public GamePanel() {
	
		
		addKeyListener(this);
		setFocusable(true);

		setPreferredSize(new Dimension(WIDTH, HIGHTH));
		new Images();
		start();

	}
	/**
	 *Funkcja startuj¹ca w¹tek
	 */
	private void start() {
		status = true;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * Funkcja ustawiaj¹ca g³ówn¹ pêtlê gry.
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
	 * Funkcja updatuj¹ca logikê gry
	 */
	public void tick() {
		menager.tick();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		menager.draw(g);

	}

	public void keyPressed(KeyEvent k) {

		menager.keyPressed(k.getKeyCode());
	}

	public void keyReleased(KeyEvent k) {

		menager.keyReleased(k.getKeyCode());
	}

	public void keyTyped(KeyEvent k) {

	}
}
