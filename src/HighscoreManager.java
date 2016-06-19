import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Klasa odpowiadająca za zarządzanie listą najlepszych wyników
 */

public class HighscoreManager {
	/**
	 * Lista najlepszych wyników
	 */
	private ArrayList<Score> scores;
	/**
	 * Plik, gdzie zapisywane są najlepsze wyniki
	 */
	private static final String HIGHSCORE_FILE = "scores.dat";
	/**
	 * Outpustream
	 */
	ObjectOutputStream outputStream = null;
	/**
	 * Inputstream
	 */
	ObjectInputStream inputStream = null;

	/**
	 * Konstruktor klasy HighscoreManager
	 */
	public HighscoreManager() {
		// initialising the scores-arraylist
		scores = new ArrayList<Score>();
	}

	/**
	 * Funkcja get listy najlepszych wynikąw
	 * 
	 * @return - lista najlepszych wyników
	 */
	public ArrayList<Score> getScores() {
		loadScoreFile();
		sort();
		return scores;
	}

	/**
	 * Funkcja sortująca listę najlepszych wyników od najlepszego do najgorszego
	 */
	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
	}

	/**
	 * Funkcja dodająca wynik do listy
	 */
	public void addScore(String name, int score) {
		loadScoreFile();
		scores.add(new Score(name, score));
		updateScoreFile();
	}

	/**
	 * Funkcja wczytująca wyniki z pliku
	 */
	public void loadScoreFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
			scores = (ArrayList<Score>) inputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("[Laad] FNF Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Laad] IO Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("[Laad] CNF Error: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("[Laad] IO Error: " + e.getMessage());
			}
		}
	}

	/**
	 * Funkcja odświeżająca plik z wynikami
	 */
	public void updateScoreFile() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
			outputStream.writeObject(scores);
		} catch (FileNotFoundException e) {
			System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
		} catch (IOException e) {
			System.out.println("[Update] IO Error: :( " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("[Update] Error: " + e.getMessage());
			}
		}
	}

}
