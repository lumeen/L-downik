import java.io.Serializable;

/**
 * Klasa reprezentująca wynik gracza
 */

public class Score implements Serializable {
	/**
	 * Wynik punktowy gracza
	 */
	private int score;
	/**
	 * Nick gracza
	 */
	private String naam;

	/**
	 * Konstruktor klasy Score
	 */
	public Score(String naam, int score) {
		this.score = score;
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	public String getNaam() {
		return naam;
	}

}
