
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage_kimbab5 extends JPanel{
	ImageIcon bgimage= new ImageIcon("pic/kimbab_table2.png");
	ImageIcon kimbabImg[] = {new ImageIcon("pic/kimbab_before.png"),new ImageIcon("pic/kimbab_before2.png"),
			new ImageIcon("pic/kimbab_after1.png"),new ImageIcon("pic/kimbab_after2.png")};
	JPanel panel;
	int success_count = 0;
	int count = 0;
	
	
	public stage_kimbab5(JFrame frame) {
		setLayout(null);
		
		panel = this;

		Timing t = new Timing(panel, frame);
		t.start();
		
		Time_Limit tm = new Time_Limit(30, panel, frame,3);
		tm.start();

		new pause(panel, t, tm);
		
		JLabel kimbab = new JLabel(kimbabImg[0]);
		kimbab.setBounds(110, 70, kimbabImg[0].getIconWidth() + 60, kimbabImg[0].getIconHeight());
		add(kimbab);
		
		KeyListener kl = new KeyListener() {
				
			@Override
			public void keyTyped(KeyEvent e) {}
				
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
				
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(Timing.x >=460 && Timing.x <=500) {
						success_count++;
						menu.stage4_score += 5;
						kimbab.setIcon(kimbabImg[success_count]);
					}
					count++;
					if(count >= 4 && success_count < 2 || count > 4 && success_count == 2) {
						kimbab.setIcon(kimbabImg[3]);
					}
					if(count >= 5 || success_count == 3) {
						success_count = 0;
						count = 0;
						Timing.stopFlag = true;
						Time_Limit.complete = true;
						frame.removeKeyListener(this);
						frame.add(new result(frame, menu.stage4_score));
						frame.remove(panel);
						frame.repaint();
						frame.revalidate();
					}
				}
			}
		};
		
		frame.requestFocusInWindow();
		frame.addKeyListener(kl);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
