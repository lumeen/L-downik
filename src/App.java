import java.awt.BorderLayout;


import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;


;
public class App {
	private static JFrame frame;

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		/**
		 * Nowa ramka
		 */
		frame= new JFrame("Lądownik"); 
		
		Config.readConfig();
		/**
		 * Informacje na temat zamykania okienka
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		/**
		 *  Ramka nie mo�e mo�e zmienia� rozmiaru
		 */
		frame.setResizable(false); 
		/**
		 * Ustawienie Layoutu
		 */
		frame.setLayout(new BorderLayout()); 
		/**
		 *  Dodanie do ramki panelu gry
		 */
		frame.add(new GamePanel(), BorderLayout.CENTER); 
		frame.pack();
		/**
		 *  Ustawienie widoczno��i
		 */
		frame.setVisible(true);
	
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		App.frame = frame;
	}

}
