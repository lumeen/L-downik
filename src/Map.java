import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Klasa reprezentuj¹ca mapê gry - jeden poziom
 */
public class Map {
	/**
	 * Œcie¿ka do pliku z parametrami wybranej mapy
	 */
	private String path;
	/**
	 * Szerokoœæ i wysokoœæ mapy (liczba bloków)
	 */
	private int width, hight;
	/**
	 * Tablica platform
	 */
	private Platform[][] blocks;
	/**
	 * Tablica ska³
	 */
	private Rock[][] rocks;
	/**
	 *Konstruktor klasy Map - wywo³anie funkcji wczytywania danych mapy z pliku
	 *@param filePath - œcie¿ka do pliku
	 */
	public Map(String filePath) {

		path = filePath;

		loadMap();
	}
	/**
	 * Funkcja rysowania mapy
	 * @pram g - grphic
	 */
	public void draw(Graphics g) {

		for (int i = 0; i < blocks.length; i++) {

			for (int j = 0; j < blocks[0].length; j++) {

				blocks[i][j].draw(g);
				rocks[i][j].draw(g);

			}

		}

	}
	/**
	 * Funkcja wczytuj¹ca dane na temat mapy z pliku
	 */
	public void loadMap() {

		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		try {
			width = Integer.parseInt(br.readLine());
			hight = Integer.parseInt(br.readLine());
			blocks = new Platform[hight][width];
			rocks= new Rock[hight][width];

			for (int y = 0; y < hight; y++) {
				String line = br.readLine();
				String[] tokens = line.split("\\s+");
				for (int x = 0; x < width; x++) {
					int id = Integer.parseInt(tokens[x]);
						blocks[y][x] = new Platform(x * Platform.platformHight,
								y * Platform.platformWidth, id);
						rocks[y][x] = new Rock(x * Rock.rockHight, y
								* Rock.rockWidth, id);

		

				}

			}

		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void setBlocks(Platform[][] blocks) {
		this.blocks = blocks;
	}

	public Platform[][] getBlocks() {
		return blocks;
	}
}
