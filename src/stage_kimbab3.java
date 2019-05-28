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

public class stage_kimbab3 extends JPanel{
	ImageIcon bgimage= new ImageIcon("pic/table.png");
	ImageIcon bowlImag[] = {new ImageIcon("pic/kimbab_bowl1.png"),new ImageIcon("pic/kimbab_bowl2.png"),
			new ImageIcon("pic/kimbab_bowl3.png"),new ImageIcon("pic/kimbab_bowl4.png")};
	ImageIcon salt = new ImageIcon("pic/salt.png");
	ImageIcon sesameOil = new ImageIcon("pic/sesameOil.png");
	ImageIcon sesame = new ImageIcon("pic/sesame.png");
	JPanel panel;
	int count = 0;
	
	public stage_kimbab3(JFrame frame) {
		setLayout(null);
		
		panel = this;
		
		JLabel bowl = new JLabel(bowlImag[0]);
		bowl.setSize(610, 500);
		bowl.setBounds(210, 210, bowl.getWidth(), bowl.getHeight());		
		
		JLabel ingre_salt = new JLabel(salt);
		ingre_salt.setBounds(80, 100, salt.getIconWidth(), salt.getIconHeight());
		
		JLabel ingre_sesame = new JLabel(sesame);
		ingre_sesame.setBounds(815, 100, sesame.getIconWidth(), sesame.getIconHeight());
		
		JLabel ingre_sesameOil = new JLabel(sesameOil);
		ingre_sesameOil.setBounds(410, 60, sesameOil.getIconWidth(), sesameOil.getIconHeight());
		
		add(bowl);
		add(ingre_salt);
		add(ingre_sesame);
		add(ingre_sesameOil);
		
		ingre_sesameOil.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/sesameOil.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -215 && e.getX() <= 385 && e.getY() >= 184 && e.getY() <= 645 && pause.work) {
					count++;
					bowl.setIcon(bowlImag[1]);
					ingre_sesameOil.setVisible(false);
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_salt.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/salt.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 156 && e.getX() <= 757 && e.getY() >= 141 && e.getY() <= 608 && count==1 && pause.work) {
					bowl.setIcon(bowlImag[2]);	
					ingre_salt.setVisible(false);
					count++;
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_sesame.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/sesame.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -583 && e.getX() <= 14 && e.getY() >= 139 && e.getY() <= 605 && count == 2 && pause.work) {
					count++;
					bowl.setIcon(bowlImag[3]);
					ingre_sesame.setVisible(false);
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
