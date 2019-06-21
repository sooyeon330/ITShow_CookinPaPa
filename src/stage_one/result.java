package stage_one;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AdditionalFunction.back;
import stage_one.chicken.exam;
import stage_one.kimbab.exam_kimbab;
import rank.insert_name;

public class result extends JPanel{
	ImageIcon bgimage = new ImageIcon(getClass().getClassLoader().getResource("pic/result.png"));
	ImageIcon btn_unclickimg = new ImageIcon(getClass().getClassLoader().getResource("pic/ranking_btn_unclick.png"));
	ImageIcon btn_clickimg = new ImageIcon(getClass().getClassLoader().getResource("pic/ranking_btn_click.png"));
	
	public result(JFrame frame, int score,int stage_num){
		setLayout(null);
		int num = stage_num;
		JLabel view = new JLabel();
		view.setText(Integer.toString(score));
		view.setFont(new Font("Bingrea",Font.BOLD,15).deriveFont(120.0f));
		view.setBounds(480, 300, 300, 200);
		add(view);
		
		
		JButton rankbtn = new JButton(btn_unclickimg);
		menu.btn_setting(rankbtn);
		rankbtn.setBounds(350, 500, btn_unclickimg.getIconWidth(), btn_unclickimg.getIconHeight());
		add(rankbtn);
		
		rankbtn.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				add(new insert_name(num,score));
			}
		});
		
		add(new back(frame,this));
		menu.stage1_score = 0; 
		menu.stage2_score = 0;
		menu.stage3_score = 0;
		menu.stage4_score = 0;
		exam.btn_count = 0;
		exam_kimbab.btn_count = 0;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
