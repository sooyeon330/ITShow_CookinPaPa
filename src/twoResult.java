import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class twoResult extends JPanel{
	ImageIcon bgimage = new ImageIcon(getClass().getClassLoader().getResource("pic/twoResult.png"));
	
	twoResult(JFrame frame, int score1, int score2){
		setLayout(null);
		
		JLabel result = new JLabel();
		result.setFont(new Font("돋움",Font.BOLD,15).deriveFont(80.0f));
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBounds(430, 400, 150, 100);
		add(result);
		add(new back(frame, this, 1)); //뒤로가는거 twomenu로가게 해주세염,,		
		
		if(score1 > score2) {
			result.setText("P1");
		}
		else if(score1 == score2){
			result.setText("무승부");
		}
		else {
			result.setText("P2");
		}
		
		twomenu.Score1 = 0;
		twomenu.Score2 = 0;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
