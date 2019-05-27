import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.TreeWillExpandListener;

public class _1_bugerTestpanel extends JPanel{	
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard3.png");
	ImageIcon keyimg[] = { new ImageIcon("pic/key1.png"), // left
							new ImageIcon("pic/key2.png"), // up
							new ImageIcon("pic/key3.png"), //right
							new ImageIcon("pic/key4.png")}; //down
	
	ImageIcon presskeyimg[] = { new ImageIcon("pic/presskey1.png"), // left
							new ImageIcon("pic/presskey2.png"), // up
							new ImageIcon("pic/presskey3.png"), //right
							new ImageIcon("pic/presskey4.png")}; //down
	
	ImageIcon buger1img = new ImageIcon("pic/hamburger1.png");
	ImageIcon buger2img = new ImageIcon("pic/hamburger2.png");
	ImageIcon buger3img = new ImageIcon("pic/hamburger3.png");
	ImageIcon buger4img = new ImageIcon("pic/hamburger4.png");
	ImageIcon buger5img = new ImageIcon("pic/hamburger5.png");
	ImageIcon buger7img = new ImageIcon("pic/hamburger7.png");
	
	ImageIcon successimg = new ImageIcon("pic/success.png");
	ImageIcon failimg = new ImageIcon("pic/fail.png");
	
	public static final int x1 = 35;
	public static final int x2 = 35;//방향키 기본 x좌표
	public static final int y = 620; //방향키 기본 y좌표
	public static final int w = 70; //방향키 기본  width
	public static final int h = 70; //방향키 기본 height
	
	public static final int left = 0; //방향키 키코드
	public static final int up = 1; //방향키 키코드
	public static final int right = 2; //방향키 키코드
	public static final int down = 3; //방향키 키코드
	
	int k1=0, b=1;//keyarray에 쓸 인덱스 , buger에 쓸 인덱스
	_1_bugerTestpanel(JFrame frame) {
		setLayout(null);
		int rand = (int) (Math.random()*4);
		int keyarray1[][] = new int[4][4];//0 : rand, 1 : keyCode()
		
		JLabel buger[] = {new JLabel(buger1img), new JLabel(buger4img),new JLabel(buger5img),
				new JLabel(buger2img), new JLabel(buger3img), new JLabel(buger7img) };

		buger[0].setBounds(100, 530, buger1img.getIconWidth(), buger1img.getIconHeight());
		buger[1].setBounds(100, 510, buger4img.getIconWidth(), buger4img.getIconHeight());
		buger[2].setBounds(110, 500, buger5img.getIconWidth(), buger5img.getIconHeight());
		buger[3].setBounds(110, 480, buger2img.getIconWidth(), buger2img.getIconHeight());
		buger[4].setBounds(110, 465, buger3img.getIconWidth(), buger3img.getIconHeight());
		buger[5].setBounds(100, 345, buger7img.getIconWidth(), buger7img.getIconHeight());
		
		
		JLabel success = new JLabel(successimg);
		JLabel fail = new JLabel(failimg);
		success.setBounds(100, 100, successimg.getIconWidth(), successimg.getIconHeight());
		fail.setBounds(100, 100, successimg.getIconWidth(), successimg.getIconHeight());
		add(success);add(fail);
		success.setVisible(false);
		fail.setVisible(false);
		
		
		for(int i=0; i<4; i++) {
			keyimg[i] = ImageResize(w, h, keyimg[i]);
			presskeyimg[i] = ImageResize(w, h, presskeyimg[i]);
		}
		
		JLabel keylb_1p[]= {null,null,null,null}; //up
		
		paintKey(keylb_1p, keyarray1, rand,x2);
		add(buger[0]);
		frame.requestFocus();
		
		Thread p1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
					KeyListener klisten = new KeyAdapter() {
						  
						@Override
						public void keyPressed(KeyEvent e) {
							success.setVisible(false);	fail.setVisible(false);
								if(e.getKeyChar()=='w'||e.getKeyChar()=='a'||e.getKeyChar()=='s'||e.getKeyChar()=='d') {
		
				//					System.out.println("keypress1 "+e.getKeyCode()+" "+keyarray1[1][k1]);
									keylb_1p[k1].setIcon(presskeyimg[keyarray1[0][k1]]); //라벨의 맞는 순서의 이미지를 가져옴
									
									if(e.getKeyCode() == keyarray1[1][k1++]) { //누른키와 눌러야하는 키가 같으면
										if(k1 > 3) { //인덱스 넘어가면
											add(buger[b++]);
											if(b > 5) {
												b=1; 
												success.setVisible(true);
												removeBuger(buger);

											}
											k1=0; //초기화
										
											removeKey(keylb_1p); //키 지우고
											paintKey(keylb_1p, keyarray1, rand,x2); //새로출력
										
//											success.setVisible(false);
										}
										
									}else { //틀리는 순간
										fail.setVisible(true);
										removeBuger(buger);
										k1=0;b=1; //초기화
										removeKey(keylb_1p); //키 지우고
										paintKey(keylb_1p, keyarray1, rand,x2); //새로출력
									}
								
								}

						}//press
						@Override
						public void keyReleased(KeyEvent e) {
							keylb_1p[k1].setIcon(keyimg[keyarray1[0][k1]]);
							keylb_1p[k1].setIcon(keyimg[keyarray1[0][k1]]);
							keylb_1p[k1].setIcon(keyimg[keyarray1[0][k1]]);
							keylb_1p[k1].setIcon(keyimg[keyarray1[0][k1]]);
							frame.repaint();
						}//released
					
					};//keylisten
					
					frame.addKeyListener(klisten);
		
			}//run
		});//thread
		

		
		p1.start(); 
		
		

		
		
		
	}
	synchronized protected void paintKey(JLabel[] keylb,int[][] array,int rand,int x) { //새로운 키 배열 출력
	
		int spacing=0; //키 간격조정위한 변수
		for(int i=0; i<4; i++) { //랜덤으로 방향키 출력	
			rand = (int) (Math.random()*4); //방향키값을 랜덤으로 가져와서
			keylb[i]= new JLabel(keyimg[rand]); //라벨 배열에 순서대로 넣어주고
			keylb[i].setBounds(x+w*(i+1)+spacing, y, w, h); //위치지정
			
			add(keylb[i]); //add해줌 
			array[0][i] = rand; //랜덤값을 저장 -> 나중에 이미지 불러오기위해
			array[1][i] = keyCode(rand,"2");
			
			spacing += 10; //키 간격 조정
//			System.out.println("add"+rand);
			
		}
		
	}
	synchronized protected void removeKey(JLabel[] keylb) { //화면의 키들을 다 지움
		
		this.remove( keylb[0] );
		this.remove( keylb[1] );
		this.remove( keylb[2] );
		this.remove( keylb[3] );
//		this.repaint(); 

		
	}
	protected void removeBuger(JLabel[] buger) {
		for(int i=1; i<buger.length; i++) {
			this.remove(buger[i]);
		}
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