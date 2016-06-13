import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;
/** 
 * Klasa, kt�rej zadaniem jest "wrzucanie" odpiwedniej "planszy" gry na ekran
 */
public class StateMenager {
	/** 
	 * Stos z "planszami" gry
	 */
	public Stack<GameState> states;
	
	/** 
	 * Konstruktor klasy "wrzucaj�cy" na pierwsze miejsce w stosie aktualny element do wy�wietlania na ekranie
	 */
	public StateMenager() {
		states = new Stack<GameState>();
		states.push(new Menu(this));
	

	}
	/**
	 * Funkcja od�wie�aj�calogik� gry (pierwszego elementu stosu)
	 */
	public void tick() {
		states.peek().tick();
	}
	/**
	 * Funkcja rysuj�ca elementy (pierwszy element stosu)
	 */
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	/**
	 * Funkcja odpowiadaj�ca za naci�niecie klawiszy (pierwszego elementu stosu)
	 */
	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}
	/**
	 * Funkcja odpowiadaj�ca za puszczenie klawiszy (pierwszego elementu stosu)
	 */
	public void keyReleased(int k) {
		states.peek().keyReleased(k);
	}



}