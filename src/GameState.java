import java.awt.Graphics;


public abstract class GameState {
	/**
	 * Menadzêr zarz¹dzania tym co jest aktualnie wyœiwetlane
	 */
public StateMenager menager;
/**
 * KOnstruktor klasy GameState
 * @param menager - menager zarz¹dzaj¹cy tym co jest wyœwietlane
 */
	public GameState(StateMenager menager){
		
		this.menager= menager;
		init();
	}
public abstract void init();
/**
 * Funkcja updatuj¹ca logikê gry
 */
public abstract void tick();
/**
 * Funkcja rysuj¹ca elementy 
 * @param g -grphics 
 */
public abstract void draw(Graphics g) ;
/**
 * Funkcja odpowiadaj¹ca za naciœniecie przycisku 
 */
public abstract void keyPressed(int k);
/**
 * Funkcja odpowiadaj¹ca z apuszczenie przycisku
 */
public abstract void keyReleased(int k);

}
