import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pause extends JLabel{
	ImageIcon pBtn = new ImageIcon("pic/pause_btn_unclick.png");
	ImageIcon pBtn2 = new ImageIcon("pic/pause_btn_click.png");
	ImageIcon pScreen = new ImageIcon("pic/pause_screen.png");
	
	static boolean work = true;
	
	pause(JPanel panel, Thread t){
		setLayout(null);
		setIcon(pBtn);
		setBounds(925,8,pBtn.getIconWidth(),pBtn.getIconHeight());
		panel.add(this);
		JLabel screen = new JLabel(pScreen);
		screen.setBounds(0, 0, pScreen.getIconWidth(),pScreen.getIconHeight());
		panel.add(screen);
		screen.setVisible(false);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(work) {
					t.suspend();
					screen.setVisible(true);
					work = false;
				}
				else {
					t.resume();
					screen.setVisible(false);
					work = true;
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				setIcon(pBtn2);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				setIcon(pBtn);
			}
		});
	}
	
	pause(JPanel panel, Thread t, Thread t2){
		setLayout(null);
		JLabel screen = new JLabel(pScreen);
		screen.setBounds(0, 0, pScreen.getIconWidth(),pScreen.getIconHeight());
		panel.add(screen);
		screen.setVisible(false);
		
		setIcon(pBtn);
		setBounds(925,8,pBtn.getIconWidth(),pBtn.getIconHeight());
		panel.add(this);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(work) {
					t.suspend();
					t2.suspend();
					screen.setVisible(true);
					work = false;
				}
				else {
					t.resume();
					t2.resume();
					screen.setVisible(false);
					work = true;
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				setIcon(pBtn2);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				setIcon(pBtn);
			}
		});
	}
}
