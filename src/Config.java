
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klsa wczytująca z pliku dane konfiguracyjne
 */
public class Config {

	/**
	 * Plik z danymi konfiguracyjnymi
	 */
	static String fileName = "Config.txt";

	/**
	 * Funkcja wczytująca dane z pliku
	 */
	public static void readConfig() throws NumberFormatException, IOException {

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			GamePanel.WIDTH = Integer.parseInt(bufferReader.readLine());
			GamePanel.HIGHTH = Integer.parseInt(bufferReader.readLine());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}