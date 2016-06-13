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
 * Klasa wy�wietlaj�ca menu gry
 */
public class Menu extends GameState {
	/**
	 * Miejsce na wpisanie nicku gracza
	 */
	private JLabel userLabel;
	/**
	 * Przycisk do potrwierdzenia nicku
	 */
	private JButton loginButton;
	/**
	 * Tekst nicku gracza
	 */
	public static JTextField userText;
	/**
	 * Ramka okna dialogowego nicku
	 */
	JFrame nickFrame;
	public static String name;

	/**
	 * KOnstruktor klasy Menu
	 */
	public Menu(StateMenager menager) {
		super(menager);
	}

	/**
	 * Tablica z funkcjami menu
	 */
	private String[] options = { "Nowa gra", "Najlepsze wynik", "Gra sieciowa", "Wyj�ice" };
	/**
	 * Obecny wyb�r opcji z menu
	 */
	static int currentChoice = 0;

	public void init() {

	}

	public void tick() {

	}

	/**
	 * Funkcja rysuj�ca menu na ekranie
	 * 
	 * @param g
	 *            - graphic
	 */
	public void draw(Graphics g) {
		g.setColor(new Color(23, 20, 71));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.WIDTH);

		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {

				g.setColor(new Color(10, 71, 0));

			} else {

				g.setColor(Color.white);
			}
			g.setFont(new Font("Arial", Font.PLAIN, 60));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 170, 100 + i * 100);

		}
	}

	/**
	 * Funkcja poruszania si� po menu za pomoc� przycisk�w
	 * 
	 * @param k
	 *            - int reprezentuj�cy wybrany przycisk
	 */
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_DOWN) {
			currentChoice = currentChoice + 1;
			if (currentChoice > 3) {
				currentChoice = 0;
			}
		} else if (k == KeyEvent.VK_UP) {

			currentChoice--;
			if (currentChoice < 0) {
				currentChoice = 3;
			}
		}
		if (k == KeyEvent.VK_ENTER) {

			if (currentChoice == 0) {
				setNickPanel();

			} else if (currentChoice == 1) {
			} else if (currentChoice == 2) {
			} else if (currentChoice == 3) {
				System.exit(0);
			}

		}

	}

	public void keyReleased(int k) {

	}

	/**
	 * Funkcja wy�wietlaj�ca panel do wpisania nicku
	 */
	private void setNickPanel() {

		JPanel panel = new JPanel();

		placeComponents(panel);
		nickFrame = new JFrame();
		nickFrame.add(panel);
		nickFrame = new JFrame("Nick");
		nickFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nickFrame.setSize(new Dimension(300, 150));
		nickFrame.setResizable(false);
		nickFrame.getContentPane().setBackground(Color.BLUE);
		nickFrame.setLayout(new BorderLayout());
		nickFrame.add(panel, BorderLayout.CENTER);
		nickFrame.setLocationRelativeTo(null);
		Container c = nickFrame.getContentPane();
		c.setBackground(Color.BLUE);
		nickFrame.setVisible(true);
		App.getFrame().setVisible(false);
		okClick();

	}

	/**
	 * Funkcja umiejscowuj�ca komponenty na ekrenie
	 */
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		userLabel = new JLabel("Twój nick:");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		loginButton = new JButton("OK!");
		loginButton.setBounds(110, 80, 80, 25);
		panel.add(loginButton);

	}

	/**
	 * Funkcja wy�wietlaj�ca map� gry po zaakceptowaniu nicku
	 */
	private void okClick() {

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {

				App.getFrame().setVisible(true);
				nickFrame.setVisible(false);
				name=userText.getText();
				
				
				
				menager.states.push(new Board(menager));

			}
		});

	}

}
