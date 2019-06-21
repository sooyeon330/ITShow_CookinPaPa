package AdditionalFunction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import stage_one.menu;
import stage_one.chicken.exam;
import stage_one.ramen.*;
import stage_two.twomenu;
import stage_one.egg.make_eggroll;
import main.TitlePanel;

public class back extends JLabel{
	ImageIcon unclick = new ImageIcon(getClass().getClassLoader().getResource("pic/back_btn_unclick.png"));
	ImageIcon click = new ImageIcon(getClass().getClassLoader().getResource("pic/back_btn_click.png"));
	
	public back(JFrame frame, JPanel myPanel){
		setLayout(null);
		
		setIcon(unclick);
		
		setBounds(930,10,unclick.getIconWidth(),unclick.getIconHeight());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exam.btn_count = 0;
				stage_one.ramen.stage_ramen.printcnt=0;
				make_eggroll.printcnt=0;
				frame.add(new menu(frame));
				frame.remove(myPanel);
				frame.repaint(); 
				frame.revalidate();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				setIcon(click);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				setIcon(unclick);
			}
		});
	}
	
	public back(JFrame frame, JPanel myPanel, int i){

		setLayout(null);
		
		setIcon(unclick);
		setBounds(925,10,unclick.getIconWidth(),unclick.getIconHeight());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exam.btn_count = 0;
				if(i == 2) frame.add(new twomenu(frame));
				else frame.add(new TitlePanel(frame));
				frame.remove(myPanel);
				frame.repaint();
				frame.revalidate();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				setIcon(click);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				setIcon(unclick);
			}
		});
	}

}
