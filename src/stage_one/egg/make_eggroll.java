package stage_one.egg;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import stage_one.menu;
import stage_one.result;

public class make_eggroll extends JPanel {
	
	static final int start=1,end=0;
	int i=0;
//	boolean loop=true;
	
	static int flag=1;
	
	ImageIcon bgimage = new ImageIcon(getClass().getClassLoader().getResource("pic/fire_range.png"));
	ImageIcon resultimg = new ImageIcon(getClass().getClassLoader().getResource("pic/result.png"));
	ImageIcon[] panimg = {new ImageIcon(getClass().getClassLoader().getResource("pic/pan1.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/pan2.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/pan3.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/pan4.png")),};
	ImageIcon clickimg = new ImageIcon(getClass().getClassLoader().getResource("pic/btnclick.png"));
	ImageIcon clickimg2 = new ImageIcon(getClass().getClassLoader().getResource("pic/btnclick2.png"));
	ImageIcon btnimg = new ImageIcon(getClass().getClassLoader().getResource("pic/range_gas.png"));
	ImageIcon btnedimg = new ImageIcon(getClass().getClassLoader().getResource("pic/range_gas2.png"));
	
	JFrame frame;
	
	public make_eggroll(JFrame frame) {
		setLayout(null);
		this.frame=frame;
		
		JButton startbtn = new JButton(btnimg);
		startbtn.setBounds(700, 600, btnimg.getIconWidth(), btnimg.getIconHeight());
		btn_setting(startbtn);
		add(startbtn);
		
		JLabel pan = new JLabel(panimg[0]);
		pan.setBounds(0, 0, panimg[0].getIconWidth(), panimg[0].getIconHeight());
		add(pan);
		
		JLabel click_lb = new JLabel(clickimg);
		click_lb.setBounds(720, 520, clickimg.getIconWidth(), clickimg.getIconHeight());
		add(click_lb);
		
		Thread th_click = new Thread(new Runnable() {			
			@Override
			public void run() {
				
				try {
					while(true) {
						Thread.sleep(200);
						click_lb.setIcon(clickimg2);
						Thread.sleep(200);
						click_lb.setIcon(clickimg);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th_click.start();
		
		startbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==start) { 
					click_lb.setVisible(false);	
					startbtn.setIcon(btnedimg); flag = end;
					pan.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
									new ImageIcon(getClass().getClassLoader().getResource("pic/click_cursor.png")).getImage(), new Point(31,31),"custom cursor"));
						}
						@Override
						public void mouseClicked(MouseEvent e) {
							i++;
							if(i<=3) {
								try {
									Thread.sleep(300);
								} catch (InterruptedException e1) {
									
									e1.printStackTrace();
								}
								pan.setIcon(panimg[i]);	
							}
							else click_lb.setVisible(true);	
							
						}
					});
					
					
				}
				else if(flag==end) { 
					flag=1;
					click_lb.setVisible(false);
					startbtn.setIcon(btnimg);
					printcnt++;
					removeAll();
					repaint();
					
				}
			}
		});

	
	}
	
	void btn_setting(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}

	public static int printcnt=0;
	@Override
	protected void paintComponent(Graphics g) {
		if(printcnt ==0) 
		 g.drawImage(bgimage.getImage(),0,0,null); 
		else if(printcnt==1) {
			menu.stage2_score+=20;
			frame.add(new result(frame,menu.stage2_score,2));
			frame.remove(this);
			frame.repaint();
			frame.revalidate(); 
		}
		
	}
}
