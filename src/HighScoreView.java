import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HighScoreView extends GameState {

	public HighScoreView(StateMenager menager) {
		super(menager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
        HighscoreManager hm = new HighscoreManager();

		g.setColor(new Color(23, 20, 71));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HIGHTH);
		g.setColor(new Color(10, 71, 0));
		g.setFont(new Font("Arial",Font.PLAIN,20));
		g.drawString(hm.getHighscoreString(), GamePanel.WIDTH/2-170, 200);
		
		
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	

}
