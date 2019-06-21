package AdditionalFunction;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import stage_two.twoResult;
import stage_two.twomenu;
import stage_two.ham.bugerTestpanel;
import stage_two.ham.bugerTestpanel2;

public class Timer_buger extends Thread{
	private int i;
	
	ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("pic/timer.png"));
	
	JPanel Panel1,Panel2;
	JPanel myPanel;
	JFrame frame;
	JLabel label = new JLabel();
	JLabel backlabel = new JLabel(img);
	KeyListener k1=null,k2=null;
	
	boolean stopFlag = false;
	static boolean complete = false;
	int num = 0;

	Timer_buger(int i, JFrame frame){
		this.i = i;
		this.frame = frame;
		
		label.setFont(new Font("Binggrae",Font.BOLD,15).deriveFont(30.0f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 180, 120);
		label.setText(Integer.toString(i) + "초");
		
		backlabel.setBounds(0, 10, 180, 100);
	}
	
	public Timer_buger(int i, JPanel myPanel, JPanel panel1, JPanel panel2, JFrame frame, int num){
		this(i,frame);
		this.myPanel = myPanel;
		this.Panel1 = panel1;
		this.Panel2 = panel2;
		this.num = num;
		this.k1 = bugerTestpanel.klisten1;
		this.k2 = bugerTestpanel2.klisten2;
		
		Panel1.add(label);
		Panel1.add(backlabel);
	}

	@Override
	public void run() {
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