package rank;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

class insert_Dialog extends JDialog{
	String nikname;
	public static Connection conn = null;
	private static final String Ramen_TABLE_NAME = "Ramen_Rank";
	private static final String Egg_TABLE_NAME = "Egg_Rank";
	private static final String Chicken_TABLE_NAME = "Chicken_Rank";
	private static final String Kimbab_TABLE_NAME = "Kimbab_Rank";
	public insert_Dialog(int stage, int score) {
		setLayout(null);
		setPreferredSize(new Dimension(300, 200));
		setLocation(500, 500);
		try {
			String path = System.getProperty("user.dir") +"\\db\\CookingPapa.db";
			path = path.replace("\\","/");
			conn = DriverManager.getConnection("jdbc:sqlite:"+path);
			RankDAO.init(conn);
	
			nikname = JOptionPane.showInputDialog("닉네임을 입력해주세요");
			
			if(nikname == null || nikname.length() == 0 || nikname.equals("")) {
				this.setVisible(false);
				this.dispose();
			}
			else {
				Rank rank= new Rank(nikname, score);
				
				switch(stage) {
					case 1: RankDAO.add(rank,Ramen_TABLE_NAME); break;
					case 2: RankDAO.add(rank,Egg_TABLE_NAME); break;
					case 3: RankDAO.add(rank,Chicken_TABLE_NAME); break;
					case 4: RankDAO.add(rank,Kimbab_TABLE_NAME); break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

