package AdditionalFunction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timing extends Thread{

	ImageIcon one = new ImageIcon(getClass().getClassLoader().getResource("pic/long.png"));
	ImageIcon two = new ImageIcon(getClass().getClassLoader().getResource("pic/choose.png"));
	
	JPanel panel;
	JFrame frame;
	

	JLabel long_choose = new JLabel(one);
	JLabel choose = new JLabel(two);
	
	int i;
	public static int x = 0;
	int xx, yy;
	int count = 0;
	boolean s = false;
	public static boolean stopFlag = false;
	
	public Timing(JPanel panel, JFrame frame){
		stopFlag = false;
		this.panel = panel;
		this.frame = frame;

		choose.setBounds(x, 640, 70, 63);
		panel.add(choose);
		choose.setVisible(false);
		
		long_choose.setBounds(80, 580, 859, 76);
		panel.add(long_choose);
		long_choose.setVisible(false);
		
	}
	
	public void run() {

		long_choose.setVisible(true);
		choose.setVisible(true);
		
		while(!stopFlag) {
			switch (x) {
			case 120: s = false; break;
			case 860: s = true; break;
			}
			
			if(s == false) x+=20; 
			else x-=20;
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			choose.setBounds(x, 640, 70, 63);
			
		}
	}
}
