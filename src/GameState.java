import java.awt.Graphics;


public abstract class GameState {
	/**
	 * Menadżer zarządzania tym co jest aktualnie wyśiwetlane
	 */
public static StateMenager menager;
/**
 * Konstruktor klasy GameState
 * @param menager - menager zarządzający tym co jest wyświetlane
 */
	public GameState(StateMenager menager){
		
		this.menager= menager;
		init();
	}
public abstract void init();
/**
 * Funkcja updatująca logikę gry
 */
public abstract void tick();
/**
 * Funkcja rysująca elementy 
 * @param g -grphics 
 */
public abstract void draw(Graphics g) ;
/**
 * Funkcja odpowiadająca za nacięniecie przycisku 
 */
public abstract void keyPressed(int k);
/**
 * Funkcja odpowiadająca z apuszczenie przycisku
 */
public abstract void keyReleased(int k);

}
