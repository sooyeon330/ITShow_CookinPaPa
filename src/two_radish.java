import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class two_radish extends JPanel{
	ImageIcon bgimage = new ImageIcon(getClass().getClassLoader().getResource("pic/cuttingboard2.png"));
	ImageIcon[] radish = {new ImageIcon(getClass().getClassLoader().getResource("pic/radish1.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/radish2.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/radish3.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/radish4.png"))};
	int i = 0, j = 0;
	KeyListener kl;
	
	two_radish(JFrame frame){
		setLayout(null);

		JLabel radish1 = new JLabel(radish[i]);
		JLabel radish2 = new JLabel(radish[j]);
		
		
		radish1.setBounds(-50, 0, radish[0].getIconWidth() + 100, radish[0].getIconHeight() + 30);
		radish2.setBounds(-50, 400, radish[0].getIconWidth() + 100, radish[0].getIconHeight() + 30);

		
		add(radish1);add(radish2);
		
		
		kl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					i++;
					if(i == 4) {
						i = 0;twomenu.Score1++;
					}
					radish1.setIcon(radish[i]);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					j++;
					if(j == 4) {
						j = 0;twomenu.Score2++;
					}
					radish2.setIcon(radish[j]);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		Timer t= new Timer(16, this, frame, 1, kl);
		t.start();
		
		frame.requestFocusInWindow();
		frame.addKeyListener(kl);
	}
	
	private int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}

}
