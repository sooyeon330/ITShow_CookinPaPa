import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage_kimbab1 extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard.png");
	ImageIcon[] ingre_img = {new ImageIcon("pic/kimbab_egg1.png"),new ImageIcon("pic/kimbab_egg2.png"),new ImageIcon("pic/kimbab_egg3.png"),new ImageIcon("pic/kimbab_egg4.png"),
			new ImageIcon("pic/kimbab_radish1.png"),new ImageIcon("pic/kimbab_radish2.png"),new ImageIcon("pic/kimbab_radish3.png"),new ImageIcon("pic/kimbab_radish4.png"),
			new ImageIcon("pic/kimbab_ham1.png"),new ImageIcon("pic/kimbab_ham2.png"),new ImageIcon("pic/kimbab_ham3.png"),new ImageIcon("pic/kimbab_ham4.png"),
			new ImageIcon("pic/kimbab_carrot1.png"),new ImageIcon("pic/kimbab_carrot2.png"),new ImageIcon("pic/kimbab_carrot3.png"),new ImageIcon("pic/kimbab_carrot4.png"),
			new ImageIcon("pic/kimbab_spinach1.png"),new ImageIcon("pic/kimbab_spinach2.png"),new ImageIcon("pic/kimbab_spinach3.png"),new ImageIcon("pic/kimbab_spinach4.png")};
	JPanel panel;
	int click_count;
	
	public stage_kimbab1(JFrame frame) {
		setLayout(null);
		
		panel = this;
		
		Time_Limit tm = new Time_Limit(15, panel, frame,3);
		tm.start();
		
		new pause(panel,tm);
		
		JLabel ingre = new JLabel(ingre_img[0]);
		ingre.setSize(800, 700);
		ingre.setBounds(120, -60, ingre.getWidth(), ingre.getHeight());
		ingre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				click_count++;
				ingre.setIcon(ingre_img[click_count/4]);
				if(click_count%10 == 0) {
					menu.stage4_score += 3;
					System.out.println(menu.stage4_score);
				}
				if(click_count/4 >= 19) {
					click_count = 0;
					Time_Limit.complete = true;
					frame.add(new exam_kimbab(frame));
					frame.remove(panel);
					frame.repaint();
					frame.revalidate();
				}
			}
		});
		add(ingre);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}