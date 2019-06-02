import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _1_bugerFrame extends JPanel{
	static ImageIcon keyimg[] = { new ImageIcon("pic/key1.png"), // left
			new ImageIcon("pic/key2.png"), // up
			new ImageIcon("pic/key3.png"), //right
			new ImageIcon("pic/key4.png")}; //down

	static ImageIcon presskeyimg[] = { new ImageIcon("pic/presskey1.png"), // left
				new ImageIcon("pic/presskey2.png"), // up
				new ImageIcon("pic/presskey3.png"), //right
				new ImageIcon("pic/presskey4.png")}; //down
	//
	static ImageIcon basebugimg = new ImageIcon("pic/hamburger1.png");
	
	static ImageIcon successimg = new ImageIcon("pic/success.png");
	static ImageIcon failimg = new ImageIcon("pic/fail.png");

	public static final int x = 35;
	public static final int y = 620; //방향키 기본 y좌표
	public static final int w = 70; //방향키 기본  width
	public static final int h = 70; //방향키 기본 height
	
	public static final int left = 0; //방향키 키코드
	public static final int up = 1; //방향키 키코드
	public static final int right = 2; //방향키 키코드
	public static final int down = 3; //방향키 키코드
	
	public _1_bugerFrame(JFrame frame) {
		this.setLayout(new GridLayout(1,2));
		JPanel panel1 = new _1_bugerTestpanel(frame);
		JPanel panel2 = new _1_bugerTestpanel2(frame);
		
		
		panel1.setSize(new Dimension(this.WIDTH/2, 720));
		panel2.setSize(new Dimension(this.WIDTH/2, 720));
		
//		Timer timer = new Timer(10, this, frame,1);

		Timer_buger timer = new Timer_buger(10,this, panel1, panel2, frame,1);
		timer.start();
		
		add(panel1);
		add(panel2);
	}
	
	synchronized protected static void paintKey(JPanel panel, JLabel[] keylb,int[][] array,String keycode) { //새로운 키 배열 출력
		int rand;
		int spacing=0; //키 간격조정위한 변수
		for(int i=0; i<4; i++) { //랜덤으로 방향키 출력	
			rand = (int)(Math.random()*4); //방향키값을 랜덤으로 가져와서
			keylb[i]= new JLabel(keyimg[rand]); //라벨 배열에 순서대로 넣어주고
			keylb[i].setBounds(x+w*(i+1)+spacing, y, w, h); //위치지정
			
			panel.add(keylb[i]); //add해줌 
			array[0][i] = rand; //랜덤값을 저장 -> 나중에 이미지 불러오기위해
			array[1][i] = keyCode(rand,keycode);
			
			spacing += 10; //키 간격 조정
//			System.out.println("add"+rand);
			
		}
		
	}
	synchronized protected static void removeKey(JPanel panel, JLabel[] keylb) { //화면의 키들을 다 지움
		
		panel.remove( keylb[0] );
		panel.remove( keylb[1] );
		panel.remove( keylb[2] );
		panel.remove( keylb[3] );

		
	}
	synchronized protected static void removeBuger(JPanel panel,ArrayList<JLabel> delbuger) {
//		System.out.println("remove");
		for(int i=0; i<delbuger.size(); i++) {
			panel.remove(delbuger.get(i));
		}
	}
	synchronized static protected int keyCode (int index,String p) { //rand값에 따라 키 코드 리턴
		if(p.equals("2")) {
//			System.out.println("1p : "+p);
			switch(index) {
			case left: return 37; 
			case up: return 38; 
			case right: return 39; 
			case down: return 40; 
			default : System.out.println("keyCode wrong!! : "+p);
			}
			
		}else if(p.equals("1")) {
//			System.out.println("2p : "+p);
			switch(index) {
			case left: return 65; 
			case up: return 87; 
			case right: return 68; 
			case down: return 83; 
			default : System.out.println("keyCode wrong!! : "+p);
			}
		}
		else {
			System.out.println("keyCode wrong!! : "+p);
		}
		return 0;
	}
	synchronized static ImageIcon ImageResize( int width, int height,ImageIcon img) { //이미지 크기 조정
		Image before = img.getImage();
		Image after = before.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return img = new ImageIcon(after);

	}
	
}
