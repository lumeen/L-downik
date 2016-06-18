import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.Expression;
import java.io.IOException;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	/**
	 * Szeroko�� okna -  wczytywana z pliku
	 */
	public static int WIDTH ;
	/**
	 * Wysoko�� platformy
	 */
	public static int HIGHTH ;;
	/**
	 * G��wny w�tek gry
	 */
	public static Thread thread;
	
	/**
	 *Funkcja ustawiaj�ca g�wny w�tek gry
	 */

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	/**
	 * Boolean decyduj�cy czy gra powinna by� od�wie�ana
	 */
	public static boolean status = false;
	/**
	 * Menager zarz�dzaj�cy tym co aktualnie poawia si� na ekranie (Manu, plansza gry itp)
	 */
	private StateMenager menager;
	/**
	 *Timer decyduj�cy o cz�sto��i od�wie�ania gry
	 */
	private long targetTime = 1000 / 60;
	/**
	 * Konstruktor klasy GamePanel - startuj�ca gr�
	 */
	
	public static boolean pause=false;
	public GamePanel() {
	
		
		addKeyListener(this);
		setFocusable(true);

		setPreferredSize(new Dimension(WIDTH, HIGHTH));
		new Images();
		start();

	}
	/**
	 *Funkcja startuj�ca w�tek
	 */
	private void start() {
		status = true;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * Funkcja ustawiaj�ca g��wn� p�tl� gry.
	 */
	@Override
	public void run() {
		menager = new StateMenager();
		long start, duration, wait;
if(!pause){
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

			
		}}
	}
	/**
	 * Funkcja updatuj�ca logik� gry
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
