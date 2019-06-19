import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class stage_ramen extends JPanel{
	static final int pot_x = 190;
	static final int pot_y = 95;
	static final int w = 1,s=2,n=3,g=4,e=5;
	static final int start=1,end=0;
	static int i,j;
	static int flag=1;
	int[] order= {w,s,n,g,e}; 
	int[] useorder= new int[5];
	
	ImageIcon bgimage = new ImageIcon(getClass().getClassLoader().getResource("pic/fire_range.png"));
	ImageIcon resultimg = new ImageIcon(getClass().getClassLoader().getResource("pic/result.png"));
	ImageIcon go_btnimg = new ImageIcon(getClass().getClassLoader().getResource("pic/go_btn.png"));
	ImageIcon explaneimg = new ImageIcon(getClass().getClassLoader().getResource("pic/ramen_explane.png"));
	
	static ImageIcon potimg = new ImageIcon(stage_ramen.class.getClassLoader().getResource("pic/pot.png"));
	ImageIcon waterimg = new ImageIcon(getClass().getClassLoader().getResource("pic/watercup.png"));
	ImageIcon soupbaseimg = new ImageIcon(getClass().getClassLoader().getResource("pic/soup.png"));
	ImageIcon noodleimg = new ImageIcon(getClass().getClassLoader().getResource("pic/noodle.png"));
	ImageIcon greenOnionimg = new ImageIcon(getClass().getClassLoader().getResource("pic/green_onion.png"));
	ImageIcon eggimg = new ImageIcon(getClass().getClassLoader().getResource("pic/Egg.png"));
	ImageIcon btnimg = new ImageIcon(getClass().getClassLoader().getResource("pic/range_gas.png"));
	ImageIcon btnedimg = new ImageIcon(getClass().getClassLoader().getResource("pic/range_gas2.png"));
	ImageIcon burnpot = new ImageIcon(getClass().getClassLoader().getResource("pic/burn_pot.png"));
	
	JFrame frame;JPanel panel; 
	static protected JButton pot= new JButton(potimg); 
	
	public stage_ramen(JFrame frame) {
//		System.out.println("ramen");
		setLayout(null);		
		this.frame=frame;
		this.panel=this;
		
		JButton water = new JButton(waterimg);
		JButton soupbase = new JButton(soupbaseimg);
		JButton noodle = new JButton(noodleimg);
		JButton greenOnion = new JButton(greenOnionimg);
		JButton egg = new JButton(eggimg);
		JButton startbtn = new JButton(btnimg);
		pot = new JButton(potimg);	
		
		JLabel lb_explane = new JLabel(explaneimg);
		setbounds_img(lb_explane); 
		
		JLabel scoretxt = new JLabel();
		
		JButton gobtn = new JButton(go_btnimg);
		Explane_Event btnevent = new Explane_Event();
		
		btnevent.gobtn_event(lb_explane, gobtn);
		btnevent.image_crop(gobtn);
		add(gobtn);add(lb_explane);
		
		Timer timer = new Timer(15, panel, frame,6);
//		Rm_Time_Limit timer = new Rm_Time_Limit(11, this, frame);
//		new pause(panel,timer);
		
		pot.setBounds(pot_x,pot_y,potimg.getIconWidth(),potimg.getIconHeight());
		water.setBounds(50,120,waterimg.getIconWidth(),waterimg.getIconHeight());
		soupbase.setBounds(50,350,soupbaseimg.getIconWidth(),soupbaseimg.getIconHeight());
		noodle.setBounds(200,400,noodleimg.getIconWidth(),noodleimg.getIconHeight());
		greenOnion.setBounds(850,200,greenOnionimg.getIconWidth(),greenOnionimg.getIconHeight());
		egg.setBounds(850,350,eggimg.getIconWidth(),eggimg.getIconHeight());	
		startbtn.setBounds(700, 600, btnimg.getIconWidth(), btnimg.getIconHeight());	
				
		btn_setting(pot);btn_setting(water);btn_setting(soupbase);btn_setting(noodle);btn_setting(greenOnion);btn_setting(egg);btn_setting(startbtn);
		
		add(pot); add(water); add(soupbase); add(noodle); add(greenOnion); add(egg); add(startbtn); 
		
		flag=1;  i=0;j=0;
		startbtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==start) { 
					startbtn.setIcon(btnedimg); flag = end;
					timer.start();
					
					water.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
						@Override
						public void mousePressed(MouseEvent e) {
							setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
									new ImageIcon(getClass().getClassLoader().getResource("pic/watercup.png")).getImage(), new Point(31,31),"custom cursor"));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							if(e.getX()>=pot_x && e.getX()<=pot_x+potimg.getIconWidth() && e.getY()<= pot_y ) {
								useorder[j++]=w;
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
								water.setVisible(false);
							}else
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
						}
					});
					
					soupbase.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
						@Override
						public void mousePressed(MouseEvent e) {
							setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
									new ImageIcon(getClass().getClassLoader().getResource("pic/soup.png")).getImage(), new Point(31,31),"custom cursor"));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							if(e.getX() >= pot_x && e.getX() <= pot_x + potimg.getIconWidth()) {
								useorder[j++]=s;
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
								soupbase.setVisible(false);
							}else
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
						}
					});
					noodle.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
						@Override
						public void mousePressed(MouseEvent e) {
							setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
									new ImageIcon(getClass().getClassLoader().getResource("pic/noodle.png")).getImage(), new Point(31,31),"custom cursor"));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							if(e.getX() >= pot_x && e.getX() <= pot_x + potimg.getIconWidth()) {
								useorder[j++]=n;
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
								noodle.setVisible(false);
							}else
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
						}
					});
					greenOnion.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
						@Override
						public void mousePressed(MouseEvent e) {
							setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
									new ImageIcon(getClass().getClassLoader().getResource("pic/green_onion.png")).getImage(), new Point(31,31),"custom cursor"));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							if(e.getX() >= -548 && e.getX() <= -62) {
								useorder[j++]=g;
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
								greenOnion.setVisible(false);
							}else
								System.out.println(e.getX());
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
						}
					});
					egg.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
						@Override
						public void mousePressed(MouseEvent e) {
							setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
									new ImageIcon(getClass().getClassLoader().getResource("pic/Egg.png")).getImage(), new Point(31,31),"custom cursor"));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							if(e.getX() >= -548 && e.getX() <= -62) {
								useorder[j++]=stage_ramen.e;
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
								egg.setVisible(false);
							}else
								setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
						}
					});
					
				}
				else if(flag==end) { 
					startbtn.setIcon(btnimg);
					check();
					printcnt=1;
					removeAll();
					repaint();
					
				}
			}
		});

	}
	
	void setbounds_img(Component c) {
		 int img_width = explaneimg.getIconWidth();
		 int img_height = explaneimg.getIconHeight();
		c.setBounds(0, 0, img_width, img_height);		
	}
	void check() {
		i=0; int count=0;
		for(int i=0; i<order.length; i++) {
			if(order[i] == useorder[i]) count++;
	}
		
		switch (count) {
			case 1:  menu.stage1_score = 20; break;
			case 2: menu.stage1_score = 40; break;
			case 3:  menu.stage1_score = 60; break;
			case 4: menu.stage1_score = 80; break;
			case 5: menu.stage1_score = 100; break;
		}
		
	}
	
	void btn_setting(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}
	
	static int printcnt=0;
	public static final int RAMEN = 1;
	@Override
	protected void paintComponent(Graphics g) {
		if(printcnt ==0) 
		 g.drawImage(bgimage.getImage(),0,0,null); 
		else if(printcnt==1) {
			Timer.complete = true;
			frame.add(new result(frame,menu.stage1_score,1));
			frame.remove(panel);
			frame.repaint();
			frame.revalidate(); 
		}
		
	}
}
