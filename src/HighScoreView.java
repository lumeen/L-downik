import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

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
		g.setFont(new Font("Arial",Font.PLAIN,30));
		g.drawString("1. " + hm.getScores().get(1).getNaam()+" "+ hm.getScores().get(1).getScore(), GamePanel.WIDTH/2-50, 100);
		g.drawString("2. " + hm.getScores().get(2).getNaam()+" "+ hm.getScores().get(2).getScore(), GamePanel.WIDTH/2-50, 130);
		g.drawString("3. " + hm.getScores().get(3).getNaam()+" "+ hm.getScores().get(3).getScore(), GamePanel.WIDTH/2-50, 160);
		g.drawString("4. " + hm.getScores().get(4).getNaam()+" "+ hm.getScores().get(4).getScore(), GamePanel.WIDTH/2-50, 190);
		g.drawString("5. " + hm.getScores().get(5).getNaam()+" "+ hm.getScores().get(5).getScore(), GamePanel.WIDTH/2-50, 220);
		g.drawString("6. " + hm.getScores().get(6).getNaam()+" "+ hm.getScores().get(6).getScore(), GamePanel.WIDTH/2-50, 250);
		g.drawString("7. " + hm.getScores().get(7).getNaam()+" "+ hm.getScores().get(7).getScore(), GamePanel.WIDTH/2-50, 280);
		g.drawString("8. " + hm.getScores().get(8).getNaam()+" "+ hm.getScores().get(8).getScore(), GamePanel.WIDTH/2-50, 310);
		g.drawString("9. " + hm.getScores().get(9).getNaam()+" "+ hm.getScores().get(9).getScore(), GamePanel.WIDTH/2-50, 340);
		g.drawString("10. " + hm.getScores().get(10).getNaam()+" "+ hm.getScores().get(10).getScore(), GamePanel.WIDTH/2-50, 370);
		g.setFont(new Font("Arial",Font.PLAIN,20));
		g.drawString("Aby powrócić do menu glównego wciśnij przycisk M",200 , 450);
		
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		if(k==KeyEvent.VK_M){
			
			GameState.menager.states.push(new Menu(GameState.menager));
		}
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	

}
