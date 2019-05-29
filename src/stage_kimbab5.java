import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage_kimbab5 extends JPanel{
	ImageIcon bgimage= new ImageIcon("pic/kimbab_table2.png");
	ImageIcon kimbabImg[] = {new ImageIcon("pic/kimbab_before.png"),new ImageIcon("pic/kimbab_after1.png"),
			new ImageIcon("pic/kimbab_after2.png")};
	JPanel panel;
	int count = 0;
	
	
	public stage_kimbab5(JFrame frame) {
		setLayout(null);
		
		panel = this;
		
		Timing t = new Timing(panel, frame);
		t.start();
		
		JLabel kimbab = new JLabel(kimbabImg[1]);
		setBounds(0,0,kimbabImg[1].getIconWidth(),kimbabImg[1].getIconHeight());
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
						kimbab.setIcon(kimbabImg[1]);
						count++;
					}
					else {
						kimbab.setIcon(kimbabImg[2]);
					}
					if(count == 5) {
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
