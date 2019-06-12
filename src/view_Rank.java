import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Ramen_Rank extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/rank_ramen.png");
	public Ramen_Rank(List<Rank> ranks) {
//		setLayout(null);
		setLayout(new GridLayout(7, 1));
		setSize(new Dimension(1024, 720));
		add(new JLabel());
		add(new JLabel("\t\t NAME \t\t SCORE\t\t"));
		int count=1;
		for(Rank s : ranks) {
			String texts = String.format("%d \t\t\t %s \t %d",count, s.name, s.score);
			add(new JLabel(texts));
			count++;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimg.getImage(), 0, 0,null);
	}
}
class Egg_Rank extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/rank_eggroll.png");
	public Egg_Rank(List<Rank> ranks) {
//		setLayout(null);
		setLayout(new GridLayout(7, 1));
		setSize(new Dimension(1024, 720));
		add(new JLabel());
		add(new JLabel("\t\t NAME \t\t SCORE\t\t"));
		int count=1;
		for(Rank s : ranks) {
			String texts = String.format("%d \t %s \t %d",count, s.name, s.score);
			add(new JLabel(texts));
			count++;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimg.getImage(), 0, 0, null);
	}
}
class Chicken_Rank extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/rank_chicken.png");
	public Chicken_Rank(List<Rank> ranks) {
//		setLayout(null);
		setLayout(new GridLayout(7, 1));
		setSize(new Dimension(1024, 720));
		add(new JLabel());
		add(new JLabel("\t\t NAME \t\t SCORE\t\t"));
		int count=1;
		for(Rank s : ranks) {
			String texts = String.format("%d \t %s \t %d",count, s.name, s.score);
			add(new JLabel(texts));
			count++;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimg.getImage(), 0, 0, null);
	}
}
class Kimbab_Rank extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/rank_kimbab.png");
	public Kimbab_Rank(List<Rank> ranks) {
//		setLayout(null);
		setLayout(new GridLayout(7, 1));
		setSize(new Dimension(1024, 720));
		add(new JLabel());
		add(new JLabel("\t\t NAME \t\t SCORE\t\t"));
		int count=1;
		for(Rank s : ranks) {
			String texts = String.format("%d \t\t\t %s \t %d",count, s.name, s.score);
			add(new JLabel(texts));
			count++;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimg.getImage(), 0, 0, null);
	}
}
 class view_Rank extends JPanel{
	public Ramen_Rank rm_rank = null;
    public Egg_Rank egg_rank = null;
    public Chicken_Rank ck_rank = null;
    public Kimbab_Rank kb_rank = null;
    
    static ImageIcon btn_ramen_img = new ImageIcon("pic/rank_ramen_btn.png");
    ImageIcon btn_egg_img = new ImageIcon("pic/rank_egg_btn.png");
    ImageIcon btn_chicken_img = new ImageIcon("pic/rank_chicken_btn.png");
    ImageIcon btn_kimbab_img = new ImageIcon("pic/rank_kimbab_btn.png");    
    ImageIcon btn_reset_img = bugerFrame.ImageResize(100, 50, new ImageIcon("pic/rank_reset_btn.png"));
    JButton btn1,btn2,btn3,btn4;
    
    public static final int btnimg_width = btn_ramen_img.getIconWidth();
    public static final int btnimg_height = btn_ramen_img.getIconHeight();
    
	public view_Rank(JFrame frame) {
		setLayout(null);
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:CookingPapa.db");
		
			RankDAO.init(conn);
	       
	       List<Rank> rm_ranks = RankDAO.getLists("Ramen_Rank");
	       List<Rank> egg_ranks = RankDAO.getLists("Egg_Rank");
	       List<Rank> chicken_ranks = RankDAO.getLists("Chicken_Rank");
	       List<Rank> kimbab_ranks = RankDAO.getLists("Kimbab_Rank");
	       
	       rm_rank = new Ramen_Rank(rm_ranks);
	       egg_rank = new Egg_Rank(egg_ranks);
	       ck_rank = new Chicken_Rank(chicken_ranks);
	       kb_rank = new Kimbab_Rank(kimbab_ranks);
	       
	       btn1 = new JButton(btn_ramen_img);
	       btn2 = new JButton(btn_egg_img);
	       btn3 = new JButton(btn_chicken_img);
	       btn4 = new JButton(btn_kimbab_img);
	       
	       menu.btn_setting(btn1); menu.btn_setting(btn2); menu.btn_setting(btn3); menu.btn_setting(btn4);

	       btn1.setBounds(0, 0,btnimg_width, btnimg_height);
	       btn2.setBounds(btnimg_width, 0, btnimg_width, btnimg_height);
	       btn3.setBounds(btnimg_width*2, 0, btnimg_width, btnimg_height);
	       btn4.setBounds(btnimg_width*3, 0, btnimg_width, btnimg_height);
	       
	       
	      
	       JButton resetbtn = new JButton(btn_reset_img);
	       menu.btn_setting(resetbtn);
	       resetbtn.setBounds(0, 90, btn_reset_img.getIconWidth(), btn_reset_img.getIconHeight());
	       add(resetbtn);	
	       
	       add(new back(frame, this,0));
	       add(btn1);add(btn2); add(btn3); add(btn4);
	       add(rm_rank);add(egg_rank); add(ck_rank); add(kb_rank);	
	      
	       rm_rank.setVisible(true);
	       egg_rank.setVisible(false);
	       ck_rank.setVisible(false);
	       kb_rank.setVisible(false);
	       
		       resetbtn.addMouseListener(new MouseAdapter() {
		    	   @Override
					public void mouseEntered(MouseEvent e) {
		    		   resetbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
		    	   @Override
			    	public void mouseClicked(MouseEvent e) {
		    		   try {
		    			   
							if (rm_rank.isVisible()) {
								RankDAO.delete("Ramen_Rank");
								repaint();
							}
							if (egg_rank.isVisible()) {
								RankDAO.delete("Egg_Rank");
								repaint();
							}
							if (ck_rank.isVisible()) {
								RankDAO.delete("Chicken_Rank");
								repaint();
							}
							if (kb_rank.isVisible()) {
								RankDAO.delete("Kimbab_Rank");
								repaint();
							}

			    	   } catch (SQLException e1) {
							e1.printStackTrace();
			    	   }
			    	}
		       });
	       
	       btn1.addMouseListener(new MouseAdapter() {
	    	   @Override
				public void mouseEntered(MouseEvent e) {
					btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
	    	   @Override
	    	public void mouseClicked(MouseEvent e) {
	    		   rm_rank.setVisible(true);
					egg_rank.setVisible(false);
					ck_rank.setVisible(false);
					kb_rank.setVisible(false);
	    	}
	       });
	       btn2.addMouseListener(new MouseAdapter() {
	    	   @Override
				public void mouseEntered(MouseEvent e) {
					btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					rm_rank.setVisible(false);
					egg_rank.setVisible(true);
					ck_rank.setVisible(false);
					kb_rank.setVisible(false);
			}});
	       btn3.addMouseListener(new MouseAdapter() {
	    	   @Override
				public void mouseEntered(MouseEvent e) {
	    		   btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					rm_rank.setVisible(false);
					egg_rank.setVisible(false);
					ck_rank.setVisible(true);
					kb_rank.setVisible(false);
			}});
	       btn4.addMouseListener(new MouseAdapter() {
	    	   @Override
				public void mouseEntered(MouseEvent e) {
	    		   btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					rm_rank.setVisible(false);
					egg_rank.setVisible(false);
					ck_rank.setVisible(false);
					kb_rank.setVisible(true);
			}});
       } catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
 

