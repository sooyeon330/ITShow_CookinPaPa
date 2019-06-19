import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.TreeWillExpandListener;

public class bugerTestpanel2 extends JPanel{	
	ImageIcon bgimage = new ImageIcon(getClass().getClassLoader().getResource("pic/cuttingboard4.png"));

	int k2=0,b=0;//keyarray에 쓸 인덱스 , buger에 쓸 인덱스
	JPanel panel;
	ArrayList<JLabel> delbuger2 = new ArrayList<>();
	static int delidx=0;
	static KeyListener klisten2 = null;
	
	bugerTestpanel2(JFrame frame) {
		setLayout(null);
		panel = this;
		
		int rand = (int) (Math.random()*4);
		int keyarray2[][] = new int[4][4];//0 : rand, 1 : keyCode()
		
		//버거패티
		JLabel basebuger = new JLabel(bugerFrame.basebugimg);
		String bugername[] = {"buger2img","buger3img","buger4img","buger5img","buger7img","buger7img"};
		basebuger.setBounds(100, 530, bugerFrame.basebugimg.getIconWidth(), bugerFrame.basebugimg.getIconHeight());

		//성공 실패
		JLabel success = new JLabel(bugerFrame.successimg);
		JLabel fail = new JLabel(bugerFrame.failimg);
		success.setBounds(100, 100, bugerFrame.successimg.getIconWidth(), bugerFrame.successimg.getIconHeight());
		fail.setBounds(100, 100, bugerFrame.successimg.getIconWidth(), bugerFrame.successimg.getIconHeight());
		add(success);add(fail);
		success.setVisible(false);
		fail.setVisible(false);
		
		//key이미지 셋팅
		for(int i=0; i<4; i++) {
			bugerFrame.keyimg[i] = bugerFrame.ImageResize(bugerFrame.w, bugerFrame.h,bugerFrame.keyimg[i]);
			bugerFrame.presskeyimg[i] = bugerFrame.ImageResize(bugerFrame.w, bugerFrame.h,bugerFrame.presskeyimg[i]);
		}
		
		JLabel keylb_2p[]= {null,null,null,null}; //up
		
		 paintKey( keylb_2p, keyarray2);
		add(basebuger);
		frame.requestFocus();
		
		Thread p2 = new Thread(new Runnable() {
			bugerThread bth;
			@Override
			public void run() {
				
				klisten2 = new KeyAdapter() {
						  
						@Override
						public void keyPressed(KeyEvent e) {
							success.setVisible(false);	fail.setVisible(false);
							if(e.getKeyCode() == 37||e.getKeyCode() == 38||e.getKeyCode() == 39||e.getKeyCode() == 40) {
		
									keylb_2p[k2].setIcon(bugerFrame.presskeyimg[keyarray2[0][k2]]); //라벨의 맞는 순서의 이미지를 가져옴
									
									if(e.getKeyCode() == keyarray2[1][k2++]) { //누른키와 눌러야하는 키가 같으면
										
										if(k2 > 3) { //인덱스 넘어가면
											twomenu.Score2 ++;
											bth = new bugerThread(bugername[b++],panel,delbuger2);
											if(b > 5) {	
												success.setVisible(true);
												bth = new bugerThread(bugername[4],panel,delbuger2);
												k2=0;b=0;
												 removeBuger(delbuger2);	
											}
											k2=0; //초기화
											
											 removeKey(keylb_2p); //키 지우고
											 paintKey(keylb_2p, keyarray2); //새로출력		
										}
										
									}else { //틀리는 순간
										fail.setVisible(true);
										 removeBuger(delbuger2);
										k2=0;b=0;
										 removeKey(keylb_2p); //키 지우고
										 paintKey( keylb_2p, keyarray2); //새로출력
									}
								
								}

						}//press
						@Override
						public void keyReleased(KeyEvent e) {
							keylb_2p[k2].setIcon( bugerFrame.keyimg[keyarray2[0][k2]]);
							keylb_2p[k2].setIcon( bugerFrame.keyimg[keyarray2[0][k2]]);
							keylb_2p[k2].setIcon( bugerFrame.keyimg[keyarray2[0][k2]]);
							keylb_2p[k2].setIcon( bugerFrame.keyimg[keyarray2[0][k2]]);
							frame.repaint();
						}//released
					
					};//keylisten
					
					frame.addKeyListener(klisten2);
		
			}//run
		});//thread

		p2.start(); 
		
		
		
	}
	synchronized protected void paintKey(JLabel[] keylb,int[][] array) { //새로운 키 배열 출력
		int rand;
		int spacing=0; //키 간격조정위한 변수
		for(int i=0; i<4; i++) { //랜덤으로 방향키 출력	
			rand = (int) (Math.random()*4); //방향키값을 랜덤으로 가져와서
			keylb[i]= new JLabel(bugerFrame.keyimg[rand]); //라벨 배열에 순서대로 넣어주고
			keylb[i].setBounds(bugerFrame.x+bugerFrame.w*(i+1)+spacing, bugerFrame.y, bugerFrame.w, bugerFrame.h); //위치지정
			
			add(keylb[i]); //add해줌 
			array[0][i] = rand; //랜덤값을 저장 -> 나중에 이미지 불러오기위해
			array[1][i] = bugerFrame.keyCode(rand,"2");
			
			spacing += 10; //키 간격 조정
//			System.out.println("add"+rand);
			
		}
		
	}
	synchronized protected void removeKey(JLabel[] keylb) { //화면의 키들을 다 지움
		
		this.remove( keylb[0] );
		this.remove( keylb[1] );
		this.remove( keylb[2] );
		this.remove( keylb[3] );

		
	}
	protected void removeBuger(ArrayList<JLabel> delbuger) {
//		System.out.println("remove");
		for(int i=0; i<delbuger.size(); i++) {
			this.remove(delbuger.get(i));
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}