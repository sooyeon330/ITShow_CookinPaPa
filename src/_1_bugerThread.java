import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _1_bugerThread extends Thread{
	
	ImageIcon buger1img = new ImageIcon("pic/hamburger1.png");
	ImageIcon buger2img = new ImageIcon("pic/hamburger2.png");
	ImageIcon buger3img = new ImageIcon("pic/hamburger3.png");
	ImageIcon buger4img = new ImageIcon("pic/hamburger4.png");
	ImageIcon buger5img = new ImageIcon("pic/hamburger5.png");
	ImageIcon buger7img = new ImageIcon("pic/hamburger7.png");
	
	int idx=0;
	String imgname="";
	JLabel bugerlb;
	
	int MaxY;
	int x,y=0;
	JPanel panel;
	
	_1_bugerThread(String imgname, JPanel panel) {
		this.imgname = imgname;
		this.panel = panel;

		switch(imgname) {
		case "buger2img" : 
				bugerlb = new JLabel(buger4img);
				bugerlb.setBounds(100, 0, buger4img.getIconWidth(), buger4img.getIconHeight());
				x=100;
				MaxY = 510;	
			break;
		case "buger3img" : 
				bugerlb = new JLabel(buger5img);
				bugerlb.setBounds(110, 0, buger5img.getIconWidth(), buger5img.getIconHeight());
				x=110;
				MaxY = 500;	
			break;
		case "buger4img" : 
				bugerlb = new JLabel(buger2img);
				bugerlb.setBounds(110, 0, buger2img.getIconWidth(), buger2img.getIconHeight());
				x=110;
				MaxY = 480;	
			break;
		case "buger5img" : 
				bugerlb = new JLabel(buger3img);
				bugerlb.setBounds(110, 0, buger3img.getIconWidth(), buger3img.getIconHeight());
				x=110;
				MaxY = 465;	
			break;
		case "buger7img" : 
				bugerlb = new JLabel(buger7img);
				bugerlb.setBounds(100, 0, buger7img.getIconWidth(), buger7img.getIconHeight());
				x=100;
				MaxY = 345;	
			break;
		}
		_1_bugerTestpanel.delbuguer.add(bugerlb);
		panel.add(bugerlb);
		this.start();
	}

	@Override
	public void run() {

		try {
			
			while(y <= MaxY) {
				bugerlb.setLocation(x, y);
				Thread.sleep(1);
				y+=10;
			}
			if(imgname.equals("buger7img")) {
				Thread.sleep(1000);
			}
//			System.out.println("donewhile");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	protected void removerBuger(JLabel[] delbuger ) {
		for(int i=1; i<delbuger.length; i++) {
			panel.remove(delbuger[i]);
		}
	}
}
