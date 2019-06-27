package stage_one;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AdditionalFunction.back;
import stage_one.chicken.exam;
import stage_one.egg.stage_eggroll;
import stage_one.kimbab.*;
import stage_one.ramen.stage_ramen;
import stage_tutorial.tutorial1;

public class menu extends JPanel{
	ImageIcon bgimage = new ImageIcon(getClass().getClassLoader().getResource("pic/menu.png"));
	ImageIcon ramenimg = new ImageIcon(getClass().getClassLoader().getResource("pic/Ramen.png"));
	ImageIcon eggrollimg = new ImageIcon(getClass().getClassLoader().getResource("pic/EggRoll.png"));
	ImageIcon chikenimg = new ImageIcon(getClass().getClassLoader().getResource("pic/Chiken.png"));
	ImageIcon kimbabimg = new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab.png"));
	ImageIcon tutorial = new ImageIcon(getClass().getClassLoader().getResource("pic/tutorial_btn_unclick.png"));
	ImageIcon tutorial_press = new ImageIcon(getClass().getClassLoader().getResource("pic/tutorial_btn_click.png"));
	
	JPanel panel;
	public static int stage1_score = 0;
	public static int stage2_score = 0; 
	public static int stage3_score = 0;
	public static int stage4_score = 0;
	public static final int RAMEN = 1;

	public menu(JFrame frame){
		setLayout(null);
		
		panel = this;
		
		add(new back(frame, this, 1));
		
		JButton btn1 = new JButton(kimbabimg);
		JButton btn2 = new JButton(eggrollimg);
		JButton btn3 = new JButton(chikenimg);
		JButton btn4 = new JButton(ramenimg);
		
		btn1.setBounds(140,270,kimbabimg.getIconWidth(),kimbabimg.getIconHeight());
		btn2.setBounds(420,270,eggrollimg.getIconWidth(),eggrollimg.getIconHeight());
		btn3.setBounds(700,250,chikenimg.getIconWidth(),chikenimg.getIconHeight());
		btn4.setBounds(80,460,ramenimg.getIconWidth(),ramenimg.getIconHeight());
		btn_setting(btn1);btn_setting(btn2);btn_setting(btn3);btn_setting(btn4);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		JButton button3 = new JButton(tutorial);
		button3.setBounds(0,10,250,80);		
		add(button3);
		
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exam_kimbab.btn_count = 1;
				frame.add(new exam_kimbab(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.add(new stage_eggroll(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exam.btn_count = 1;
				frame.add(new exam(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.add(new stage_ramen(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
			
		btn_setting(button3);
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button3.setIcon(tutorial_press);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button3.setIcon(tutorial);
				button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new tutorial1(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		
		});
	}
	
	public static void btn_setting(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}