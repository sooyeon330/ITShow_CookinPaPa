import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class stage_kimbab2 extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/fire_range.png");
	
	ImageIcon panimg = new ImageIcon("pic/ori_fan.png");
	
	ImageIcon[] ingreimg = {new ImageIcon("pic/kimbab_ham_before.png"),new ImageIcon("pic/kimbab_ham_after.png"),
			new ImageIcon("pic/kimbab_radish_before.png"),new ImageIcon("pic/kimbab_radish_after.png"),
			new ImageIcon("pic/kimbab_spinach_before.png"),new ImageIcon("pic/kimbab_spinach_after.png")};
	
	ImageIcon keyimg[] = { new ImageIcon("pic/key1.png"), // left
			new ImageIcon("pic/key2.png"), // up
			new ImageIcon("pic/key3.png"), //right
			new ImageIcon("pic/key4.png")}; //down

	ImageIcon presskeyimg[] = { new ImageIcon("pic/presskey1.png"), // left
			new ImageIcon("pic/presskey2.png"), // up
			new ImageIcon("pic/presskey3.png"), //right
			new ImageIcon("pic/presskey4.png")}; //down
	
	JPanel panel;	
	
	public static final int x1 = 300;
	public static final int x2 = 550;//방향키 기본 x좌표
	public static final int y = 620; //방향키 기본 y좌표
	public static final int w = 70; //방향키 기본  width
	public static final int h = 70; //방향키 기본 height
	
	public static final int left = 0; //방향키 키코드
	public static final int up = 1; //방향키 키코드
	public static final int right = 2; //방향키 키코드
	public static final int down = 3; //방향키 키코드

	int k1=0,k2=0;//keyarray에 쓸 인덱스
	
	int correct_count = 0;
	
	public stage_kimbab2(JFrame frame) {
		setLayout(null);
		
		panel = this;	

		JLabel ingre = new JLabel(ingreimg[0]);
		ingre.setBounds(300, 0, ingreimg[0].getIconWidth(), ingreimg[0].getIconWidth());
		add(ingre);
		
		JLabel pan = new JLabel(panimg);
		pan.setBounds(70, 75, panimg.getIconWidth(), panimg.getIconHeight());
		add(pan);

		int rand = (int) (Math.random()*4);
		int keyarray[][] = new int[4][4];//0 : rand, 1 : keyCode()
		
		for(int i=0; i<4; i++) {
			keyimg[i] = ImageResize(w, h, keyimg[i]);
			presskeyimg[i] = ImageResize(w, h, presskeyimg[i]);
		}
		
		JLabel keylb[]= {null,null,null,null}; //up

		paintKey(keylb, keyarray, rand,x1);
		
		KeyListener kl = new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keypress1");
				keylb[k1].setIcon(presskeyimg[keyarray[0][k1]]); //라벨의 맞는 순서의 이미지를 가져옴
				
				if(e.getKeyCode() == keyarray[1][k1++]) { //누른키와 눌러야하는 키가 같으면
					System.out.println("맞음");
					if(k1 > 3) { //인덱스 넘어가면
						correct_count += k1; //초기화
						k1=0; //초기화
						if(correct_count >= 12) {
							ingre.setIcon(ingreimg[5]);
							frame.add(new stage_kimbab3(frame));
							frame.remove(panel);
							frame.repaint();
							frame.revalidate();
						}
						
						removeKey(keylb, keyarray); //키 지우고
						paintKey(keylb, keyarray, rand,x1); //새로출력
					}
					
				}else { //틀리는 순간
					System.out.println("틀림");
					k1=0; //초기화
					removeKey(keylb, keyarray); //키 지우고
					paintKey(keylb, keyarray, rand,x1); //새로출력
				}
				
			
			}
			@Override
			public void keyReleased(KeyEvent e) {
				keylb[k1].setIcon(keyimg[keyarray[0][k1]]);
				keylb[k1].setIcon(keyimg[keyarray[0][k1]]);
				keylb[k1].setIcon(keyimg[keyarray[0][k1]]);
				keylb[k1].setIcon(keyimg[keyarray[0][k1]]);
				frame.repaint();
			}

		};
		

		frame.requestFocusInWindow();
		frame.addKeyListener(kl);
		
	}	
	
	synchronized protected void paintKey(JLabel[] keylb,int[][] array,int rand,int x) { //새로운 키 배열 출력
		int spacing=0; //키 간격조정위한 변수
		for(int i=0; i<4; i++) { //랜덤으로 방향키 출력	
			rand = (int) (Math.random()*4); //방향키값을 랜덤으로 가져와서
			keylb[i]= new JLabel(keyimg[rand]); //라벨 배열에 순서대로 넣어주고
			keylb[i].setBounds(x+w*(i+1)+spacing, y, w, h); //위치지정
			
			add(keylb[i]); this.repaint(); //add해줌 
			array[0][i] = rand; //랜덤값을 저장 -> 나중에 이미지 불러오기위해
			if(x==x1)
				array[1][i] = keyCode(rand,"1"); // 랜덤값에 대한 키값저장 -> 나중에 비교위해
			else if(x==x2)
				array[1][i] = keyCode(rand,"2");
			spacing += 10; //키 간격 조정
			System.out.println("add"+rand);
			
		}
	}
	synchronized protected void removeKey(JLabel[] keylb,int[][] array) { //화면의 키들을 다 지움
		
		this.remove( keylb[0] );
		this.remove( keylb[1] );
		this.remove( keylb[2] );
		this.remove( keylb[3] );
//		this.repaint(); 
		
	}
	synchronized protected int keyCode (int index,String p) { //rand값에 따라 키 코드 리턴
		if(p.equals("1")) {
			switch(index) {
			case left: return 37; 
			case up: return 38; 
			case right: return 39; 
			case down: return 40; 
			}
		}else if(p.equals("2")) {
			switch(index) {
			case left: return 65; 
			case up: return 87; 
			case right: return 68; 
			case down: return 83; 
			}
		}
		return 0;
	}
	protected ImageIcon ImageResize( int width, int height,ImageIcon img) { //이미지 크기 조정
		Image before = img.getImage();
		Image after = before.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return img = new ImageIcon(after);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
