import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class two_carrot extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard2.png");
	ImageIcon[] carrot = {new ImageIcon("pic/carret1.png"),new ImageIcon("pic/carret2.png"),
			new ImageIcon("pic/carret3.png"),new ImageIcon("pic/carret4.png")};
	int i = 0, j = 0;
	KeyListener kl;
	
	two_carrot(JFrame frame){
		setLayout(null);

		JLabel carrot1 = new JLabel(carrot[i]);
		JLabel carrot2 = new JLabel(carrot[j]);
		
		
		carrot1.setBounds(-50, -100, carrot[0].getIconWidth() + 100, carrot[0].getIconHeight() + 30);
		carrot2.setBounds(-50, 280, carrot[0].getIconWidth() + 100, carrot[0].getIconHeight() + 30);

		
		add(carrot1);add(carrot2);
		
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
						i = 0;
					}
					carrot1.setIcon(carrot[i]);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					j++;
					if(j == 4) {
						j = 0;
					}
					carrot2.setIcon(carrot[j]);
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
