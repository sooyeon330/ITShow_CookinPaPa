
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Time_Limit extends Thread{
	private int i;
	JPanel myPanel = new JPanel();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	KeyListener kl;
	
	boolean stopFlag = false;
	static boolean complete = false;
	int num = 0;

	Time_Limit(int i, JPanel myPanel, JFrame frame){
		this.i = i;
		this.myPanel = myPanel;
		this.frame = frame;
		label.setOpaque(true);
		label.setFont(new Font("돋움",Font.BOLD,15).deriveFont(40.0f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 150, 100);
		label.setBackground(Color.white);
		
	}
	
	Time_Limit(int i, JPanel myPanel, JFrame frame, int num){
		this(i,myPanel,frame);
		this.num = num;
		if(num == 1) label.setBounds(450, 300, 150, 100);
		else label.setBounds(0, 0, 150, 100);
		
	}	
	
	Time_Limit(int i, JPanel myPanel, JFrame frame, int num, KeyListener k){
		this(i,myPanel,frame,num);
		this.kl = k;
	}
	
	@Override
	public void run() {
		myPanel.add(label);
		while(!stopFlag) {
			if(i <= 5) label.setForeground(Color.RED);
			label.setText(Integer.toString(i) + "초");
		//	System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
			if(complete) {
				stopFlag= true;
				complete = false;
			}
			if(i == -1)	{
				stopFlag = true;
				if(num == 1) frame.add(new twoResult(frame));
				else if(num == 2) frame.add(new result(frame, menu.stage3_score));
				else if(num == 3) frame.add(new exam_kimbab(frame));
				else frame.add(new exam(frame));

				num = 0;
				frame.removeKeyListener(kl);
				frame.remove(myPanel);
				frame.repaint();
				frame.revalidate(); 
			}
		}
	}
}
