import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Funkcja odpowiadająca za to, co będzie wyświetlane na ekranie w razie
 * zatrzymania gry
 */

public class Pause extends GameState {
	/**
	 * Ramka pauzy
	 */
	public static JFrame pauseFrame;
	/**
	 * Label z informacja na temat pauzy
	 */
	private JLabel pauseLabel;
	/**
	 * Label z informacją na temat pauzy
	 */
	private JLabel pauseLabel2;
	/**
	 * Przycisk wznowienia gry
	 */
	private JButton pauseButton;

	/**
	 * Konstruktor klasy Pause
	 */

	public Pause(StateMenager menager) {
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

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	/**
	 * Funkcja odpowiadająca za nacięniecie przycisku
	 */
	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		if (k == KeyEvent.VK_O) {
			GamePanel.pause = false;

		}

	}

	/**
	 * Funkcja odpowiadająca za puszczenie przycisku
	 */
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

	/**
	 * Funkcja odpowiadająca za nwyswietlenie ramki z informacją o pauzie
	 */
	public void setPauseFrame() {
		JPanel panel = new JPanel();

		placeComponents(panel);
		pauseFrame = new JFrame();
		pauseFrame.add(panel);
		pauseFrame = new JFrame("Pauza");
		pauseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pauseFrame.setSize(new Dimension(300, 150));
		pauseFrame.setResizable(false);
		pauseFrame.getContentPane().setBackground(Color.BLUE);
		pauseFrame.setLayout(new BorderLayout());
		pauseFrame.add(panel, BorderLayout.CENTER);
		pauseFrame.setLocationRelativeTo(null);
		Container c = pauseFrame.getContentPane();
		c.setBackground(Color.BLUE);
		App.getFrame().setVisible(true);
		pauseFrame.setVisible(true);
		onClick();

	}

	/**
	 * Funkcja odpowiadająca za umiejscowienie komponentów na ramce z informacją
	 * o pauzie
	 */
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		pauseLabel = new JLabel("Gra wstrzymana!");
		pauseLabel.setBounds(10, 10, 200, 50);
		panel.add(pauseLabel);
		pauseLabel2 = new JLabel("Aby kontynuować naciśnij przycisk");
		pauseLabel2.setBounds(10, 30, 300, 50);
		panel.add(pauseLabel2);
		pauseButton = new JButton("Kontynuuj!");
		pauseButton.setBounds(50, 80, 200, 25);
		panel.add(pauseButton);

	}

	/**
	 * Funkcja odpowiadająca za wznowienie gry po wciśnieciu przycku
	 */
	private void onClick() {

		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {

				App.getFrame().setVisible(true);
				pauseFrame.setVisible(false);
				GamePanel.pause = false;

			}
		});

	}

}
