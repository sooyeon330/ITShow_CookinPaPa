import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class TitlePanel extends JPanel{
	JButton button1,button2;
	ImageIcon bgimage = new ImageIcon("pic/title.png");
	ImageIcon start = new ImageIcon("pic/start_btn_unclick.png");
	ImageIcon start_press = new ImageIcon("pic/start_btn_click.png");
	ImageIcon rank = new ImageIcon("pic/ranklist_btn_unclick.png");
	ImageIcon rank_press = new ImageIcon("pic/ranklist_btn_click.png");
	ImageIcon two = new ImageIcon("pic/2p_btn_unclick.png");
	ImageIcon two_press = new ImageIcon("pic/2p_btn_click.png");
	
	JPanel panel;
	
	TitlePanel(JFrame frame) {
		
		setLayout(null);
		 
		panel = this;
		
		JButton secret_btn =new JButton();
		
		button1 = new JButton(start);
		button2 = new JButton(rank);
		
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setIcon(start_press);
				button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button1.setIcon(start); 
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new menu(frame));
		 		frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		button1.setBounds(60,600,270,80);		
		add(button1);
		
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button2.setFocusPainted(false);
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button2.setIcon(rank_press); 
				button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button2.setIcon(rank); 
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new view_Rank(frame));
		 		frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		button2.setBounds(650,600,350,90);		
		add(button2);
		
		JButton button3 = new JButton(two);
	
		button3.setBorderPainted(false);
		button3.setContentAreaFilled(false);
		button3.setFocusPainted(false);
		
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button3.setIcon(two_press);
				button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button3.setIcon(two);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new twomenu(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		button3.setBounds(350,600,300,80);		
		add(button3);
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}



public class title {
	static protected JFrame frame = new JFrame();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image img = toolkit.getImage("pic/egg_icon.png");
				frame.setIconImage(img);
				frame.setTitle("Cooking PaPa 쿠킹파파"); 
				frame.setLocation(0,0);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				TitlePanel title = new TitlePanel(frame);		
				title.setPreferredSize(new Dimension(1024, 720));
				title.setLayout(null);
				
				menu menu = new menu(frame);
				menu.setPreferredSize(new Dimension(1024, 720));
								
				frame.add(title);
			
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}