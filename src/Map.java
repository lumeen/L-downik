import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;

/**
 * Klasa reprezentująca mapę gry - jeden poziom
 */
public class Map {
	/**
	 * Ścieżka do pliku z parametrami wybranej mapy
	 */
	private String path;
	/**
	 * Szerokość i wysokość mapy (liczba bloków)
	 */
	private int width, hight;
	/**
	 * Tablica platform
	 */
	private Platform[][] blocks;
	/**
	 * Tablica skał
	 */
	// private Rock[][] rocks;
	/**
	 * Tablica punktów x wielokąta
	 */
	public int[] xPointsTabNum;
	/**
	 * Tablica punktów y wielokąta
	 */
	public int[] yPointsTabNum;
	 
	public static int maxSpeed;
	
	public static double lvlFuel;
	public static double gravitation;

	/**
	 * Konstruktor klasy Map - wywołanie funkcji wczytywania danych mapy z pliku
	 * 
	 * @param filePath
	 *            - ścieżka do pliku
	 */
	public Map(String filePath) {

		path = filePath;

		loadMap();
	}

	/**
	 * Funkcja rysowania mapy
	 * 
	 * @pram g - grphics
	 */
	public void draw(Graphics g) {

		for (int i = 0; i < blocks.length; i++) {

			for (int j = 0; j < blocks[0].length; j++) {

				blocks[i][j].draw(g);

			}

		}

		Polygon d = new Polygon(xPointsTabNum, yPointsTabNum, xPointsTabNum.length);
		g.setColor(Color.GRAY);
		g.drawPolygon(d);

		if (Collision.collisionWithMountain(d, Board.getPlayer().getX(), Board.getPlayer().getY())) {

			GameState.menager.states.push(new Defeat(GameState.menager));

		}

	}

	/**
	 * Funkcja wczytująca dane na temat mapy z plików
	 */
	public void loadMap() {
		String fileName = Board.lvl + ".txt";

		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String xPoints = null;
		String yPoints = null;

		try {
			width = Integer.parseInt(br.readLine());
			hight = Integer.parseInt(br.readLine());
			blocks = new Platform[hight][width];

			for (int y = 0; y < hight; y++) {
				String line = br.readLine();
				String[] tokens = line.split("\\s+");
				for (int x = 0; x < width; x++) {
					int id = Integer.parseInt(tokens[x]);
					blocks[y][x] = new Platform(x * Platform.platformHight, y * Platform.platformWidth, id);

				}

			}
			FileReader fileReader = new FileReader(fileName);
			br = new BufferedReader(fileReader);
			xPoints = br.readLine();
			yPoints = br.readLine();
			String[] xPointsTab = xPoints.split(", ");
			String[] yPointsTab = yPoints.split(", ");
			xPointsTabNum = new int[xPointsTab.length];
			for (int i = 0; i < xPointsTab.length; i++) {
				xPointsTabNum[i] = Integer.parseInt(xPointsTab[i]);
			}
			yPointsTabNum = new int[yPointsTab.length];
			for (int i = 0; i < yPointsTab.length; i++) {
				yPointsTabNum[i] = Integer.parseInt(yPointsTab[i]);
			}
			maxSpeed=Integer.valueOf(br.readLine());
			lvlFuel=Double.valueOf(br.readLine());
			gravitation=Double.valueOf(br.readLine());

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
