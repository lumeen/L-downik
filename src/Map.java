import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Klasa reprezentuj�ca map� gry - jeden poziom
 */
public class Map {
	/**
	 * �cie�ka do pliku z parametrami wybranej mapy
	 */
	private String path;
	/**
	 * Szeroko�� i wysoko�� mapy (liczba blok�w)
	 */
	private int width, hight;
	/**
	 * Tablica platform
	 */
	private Platform[][] blocks;
	/**
	 * Tablica ska�
	 */
	private Rock[][] rocks;
	/**
	 *Konstruktor klasy Map - wywo�anie funkcji wczytywania danych mapy z pliku
	 *@param filePath - �cie�ka do pliku
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
		
		int[] x={0,100,150,230,300,375,475,500,600,650,750,800};
		int[] y= {500,400,460,370,420,500,600,390,450,410,390,500};
		Polygon d= new Polygon(x,y,x.length);
		g.setColor(Color.BLACK);
		
		g.drawPolygon(d);
	g.setColor(Color.BLACK);
		g.fillPolygon(d);
		
	//	if(d.getBounds().intersects(Board.getPlayer().getX(),Board.getPlayer().getY(),30,30)){
			
		//	System.out.println("LOooooooooooooooooooool");
			
		//}
			
	if(Collision.collisionWithMountain(d, Board.getPlayer().getX(),  Board.getPlayer().getY())){
		
		
		System.out.println("looooooooooooooll");
		
	}
		
	
		
	}
	//Popraiwćs
	

	/**
	 * Funkcja wczytuj�ca dane na temat mapy z pliku
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
