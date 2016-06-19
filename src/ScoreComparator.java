import java.util.Comparator;
/**
 * Klasa reprezentująca komparator wyników użytkowników, implementujący interfejs Comparator
 */

public class ScoreComparator implements Comparator<Score> {
	
	/**
	 * Funkcja porywnująca dwa wyniki
	 * @param score1 - pierwszy wynik do porównania
	 * @param score2 - drugi wynik do porównania
	 * @retur - jeśli wynik1>wynik2 zwraca -1, jeśli odwrotnie zwraca 1, jeśli są równe zwraca 0
	 */

	
	public int compare(Score score1, Score score2)  {

        int sc1 = score1.getScore();
        int sc2 = score2.getScore();

        if (sc1 > sc2){
            return -1;
        }else if (sc1 < sc2){
            return 1;
        }else{
            return 0;
        }
    }

}
