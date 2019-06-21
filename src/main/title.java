package main;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import stage_one.menu;

public class title {
	static protected JFrame frame = new JFrame();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image img = toolkit.getImage(getClass().getClassLoader().getResource("pic/egg_icon.png"));
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