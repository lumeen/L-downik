import java.awt.Graphics;


public abstract class GameState {
	/**
	 * Menadz�r zarz�dzania tym co jest aktualnie wy�iwetlane
	 */
public static StateMenager menager;
/**
 * KOnstruktor klasy GameState
 * @param menager - menager zarz�dzaj�cy tym co jest wy�wietlane
 */
	public GameState(StateMenager menager){
		
		this.menager= menager;
		init();
	}
public abstract void init();
/**
 * Funkcja updatuj�ca logik� gry
 */
public abstract void tick();
/**
 * Funkcja rysuj�ca elementy 
 * @param g -grphics 
 */
public abstract void draw(Graphics g) ;
/**
 * Funkcja odpowiadaj�ca za naci�niecie przycisku 
 */
public abstract void keyPressed(int k);
/**
 * Funkcja odpowiadaj�ca z apuszczenie przycisku
 */
public abstract void keyReleased(int k);

}
