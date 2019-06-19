import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage_kimbab4 extends JPanel{
	ImageIcon bgimage= new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_table1.png"));
	ImageIcon kimbabImg[] = {new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_combine1.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_combine2.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_combine3.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_combine4.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_combine5.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_combine6.png")),
			new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_combine7.png"))};
	ImageIcon hamImg = new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_ham.png"));
	ImageIcon carrotImg = new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_carrot.png"));
	ImageIcon radishImg = new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_radish.png"));
	ImageIcon spinachImg = new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_spinach.png"));
	ImageIcon eggImg = new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_egg.png"));
	ImageIcon riceImg = new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_rice.png"));
	JPanel panel;
	
	int count = 0;
	
	public stage_kimbab4(JFrame frame) {
		setLayout(null);
		
		panel = this;

		Timer tm = new Timer(25, panel, frame,5);
		tm.start();

		new pause(panel, tm);
		
		JLabel kimbab = new JLabel(kimbabImg[0]);
		JLabel ham = new JLabel(hamImg);
		JLabel carrot = new JLabel(carrotImg);
		JLabel radish = new JLabel(radishImg);
		JLabel spinach = new JLabel(spinachImg);
		JLabel egg = new JLabel(eggImg);
		JLabel rice = new JLabel(riceImg);
		
		kimbab.setBounds(470,40,riceImg.getIconWidth()+150,riceImg.getIconHeight()+150);
		ham.setBounds(20,500,hamImg.getIconWidth(),hamImg.getIconHeight());
		carrot.setBounds(20,570,carrotImg.getIconWidth(),carrotImg.getIconHeight());
		radish.setBounds(20,640,radishImg.getIconWidth(),radishImg.getIconHeight());
		spinach.setBounds(550,490,spinachImg.getIconWidth(),spinachImg.getIconHeight());
		egg.setBounds(550,560,eggImg.getIconWidth(),eggImg.getIconHeight());
		rice.setBounds(40,100,riceImg.getIconWidth(),riceImg.getIconHeight());
		
		//햄, 단무지, 당근, ㅅㅣ금치, 달걀
		ham.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_ham.png")).getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 465 && e.getX() <= 940 && e.getY() >= -437 && e.getY() <= -39 &&count==1 && pause.work) {
					kimbab.setIcon(kimbabImg[2]);		
					ham.setVisible(false);
					menu.stage4_score += 3;
					count++;
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		carrot.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_carrot.png")).getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 472 && e.getX() <= 961 && e.getY() >= -511 && e.getY() <= -120 && count==3 && pause.work) {
					kimbab.setIcon(kimbabImg[4]);	
					carrot.setVisible(false);
					menu.stage4_score += 3;
					count++;
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		radish.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_radish.png")).getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 472 && e.getX() <= 915 && e.getY() >= -568 && e.getY() <= -183 && count==2 && pause.work) {
					kimbab.setIcon(kimbabImg[3]);	
					radish.setVisible(false);
					menu.stage4_score += 3;
					count++;
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		spinach.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_spinach.png")).getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -65 && e.getX() <= 416 && e.getY() >= -426 && e.getY() <= -34 && count==4 && pause.work) {
					kimbab.setIcon(kimbabImg[5]);
					spinach.setVisible(false);
					menu.stage4_score += 3;
					count++;
				}
				
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		egg.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_egg.png")).getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -62 && e.getX() <= 427 && e.getY() >= -512 && e.getY() <= -115 && count==5 && pause.work) {
					kimbab.setIcon(kimbabImg[6]);
					egg.setVisible(false);
					menu.stage4_score += 3;
					count++;
				}
					
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		rice.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon(getClass().getClassLoader().getResource("pic/kimbab_ingre_rice.png")).getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 450 && e.getX() <= 918 && e.getY() >= -40 && e.getY() <= 360 && pause.work) {
					kimbab.setIcon(kimbabImg[1]);	
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					rice.setVisible(false);
					menu.stage4_score += 2;
					count++;
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});		
		
		kimbab.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if(count >= 6) {
					Timer.complete = true;
					frame.add(new exam_kimbab(frame));
					frame.remove(panel);
					frame.repaint();
					frame.revalidate();
				}
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(kimbab);
		add(ham);
		add(carrot);
		add(radish);
		add(spinach);
		add(egg);
		add(rice);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
