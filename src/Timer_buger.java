import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Timer_buger extends Thread{
	private int i;
	JPanel Panel1,Panel2;
	JPanel myPanel;
	JFrame frame;
	JLabel label = new JLabel();
	KeyListener k1=null,k2=null;
	
	boolean stopFlag = false;
	static boolean complete = false;
	int num = 0;

	Timer_buger(int i, JFrame frame){
		this.i = i;
		this.frame = frame;
		label.setOpaque(true);
		label.setFont(new Font("돋움",Font.BOLD,15).deriveFont(40.0f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 150, 100);
		label.setBackground(Color.white);
		
	}
	
	Timer_buger(int i, JPanel myPanel, JPanel panel1, JPanel panel2, JFrame frame, int num){
		this(i,frame);
		this.myPanel = myPanel;
		this.Panel1 = panel1;
		this.Panel2 = panel2;
		this.num = num;
		label.setBounds(0, 0, 150, 100);
		this.k1 = bugerTestpanel.klisten1;
		this.k2 = bugerTestpanel2.klisten2;
		
	}

	@Override
	public void run() {
		Panel1.add(label);
		while(!stopFlag) {
			try {
				
				if(i <= 5) label.setForeground(Color.RED);
				label.setText(Integer.toString(i) + "초");
				Thread.sleep(1000);
				i--;
				if(complete) {
					stopFlag= true;
					complete = false;
				}
				if(i < 0)	{
					stopFlag = true;
					
					frame.add(new twoResult(frame, twomenu.Score1, twomenu.Score2));
					
	
					num = 0;
					frame.removeKeyListener(k1);
					frame.removeKeyListener(k2);
					frame.remove(myPanel);
//					myPanel.remove(Panel1);
//					myPanel.remove(Panel2);
					frame.repaint();
					frame.revalidate(); 
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}