package test;
import java.awt.*;
import AIPo.*;
import jssh.Tower;
import jssh.use;

import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import data.*;
import javax.swing.*;
import util.*;
import map.*;

public class ctext extends JFrame implements Runnable{

	int nnn=101;
	private FrameRate frameRate;
	private SynthesisTower syTower=new SynthesisTower();
	private ArrayList<Integer> nowBuild=new ArrayList<>();
	private Enemy enemy=new Enemy();
	private FindEnemy findEnemy=new FindEnemy();
	private BufferStrategy bs;
	private volatile boolean running;
	private Thread gameThread;
	private BufferedImage img=null;
	private fb fb=new fb();
	public int zbx=0,zby=0,bl=5;
	private int num=0;
	private ztfk ztfk=new ztfk();
	private int movex=0;
	private walk Aiwalk=new walk();
	private int HP=20;
	private messageFrame msgF=new messageFrame();
	private Tower tower=new Tower();
	private boolean msgt=true;
	public boolean tf=true,mousem=false;
	public boolean ranget=false;
	public int range=0;
	public int xzx,xzy=0;
	private double[] nowHP;
	private int loop=1;
	public int tc=0;
	public int count=0;
	private boolean startstop=false;
	private boolean ThreadT=false;
	private boolean ammo=false;
	private int liveAmmo=0;
	Graphics g;
	private int buildcount=5;
	private ArrayList<Integer> nowB=new ArrayList<>();
	private int countd=0;
	checkMaze cc=new checkMaze();
	MapSearcher AI=new MapSearcher();
	private getTowerData gtd=new getTowerData();
	private ArrayList<Integer> builded=new ArrayList<>();
	private int Ammocount=0;//子弹数量
	public ArrayList<Integer> ammoOrder=new ArrayList<Integer>();
	public ArrayList<Integer> ammoX=new ArrayList<Integer>();
	public ArrayList<Integer> ammoY=new ArrayList<Integer>();
	private ArrayList<Integer> nowBI=new ArrayList<>();
	
	private boolean kaishi=false;
	public TowerRangeAttack[] tra;
	public Enemylist[] el;
	public TThread[] tthread;
	public EThread[] et;
	public YThread yt;
	
	
	public void setRange(int range,int x,int y){
		this.range=range;
		
		xzx=x*5;
		xzy=y*5;
		ranget=true;
	}
	
	public void init(){
		gtd.getData();
		fb.test();
		ztfk.zh();	
	}
	public ctext(){
		init();
		frameRate=new FrameRate();
	}
	
	public void renderEnmey(Graphics g){
		for(int i=count-1;i>=0;i--){
		g.drawImage(fb.getHealth(numHPP(el[i].getHP(),el[i].getHealth())),el[i].getX()*5,el[i].getY()*5-7,22,5,null);//怪物血条
		g.drawImage(fb.test, el[i].getX()*5,el[i].getY()*5,25,25,null);//怪物本体
		}
	}
	
	public void renderAmmo(Graphics g){
		for(int i=liveAmmo;i<Ammocount;i++){
			g.drawImage(fb.ammo, ammoX.get(i)-13, ammoY.get(i)-13, null);
		}
	}
	
	private int numHPP(double nowhp,int HP) {
		
		if(nowhp>0) {
		double a=nowhp/HP;
		int b=(int) (a*20);
		return b-1;
		}
			return 0;
	}
	
	
	
	public void Ammorender(Graphics g){
		g.drawImage(fb.ammo, 500, 500, null);
		
	}
	
	
	
	public void render(Graphics g){
		frameRate.calculate();
		for(int i=0;i<fb.jz.length;i++){
			for(int j=0;j<fb.jz[0].length;j++){
				
				switch(fb.jz[i][j]){
				case 101:
					img=fb.d1;
					g.drawImage(img, j*5, i*5, null);
					
					break;
				case 102:
					img=fb.b1;
					g.drawImage(img, j*5, i*5, null);
					break;
				case 103:
					img=fb.y1;
					g.drawImage(img, j*5, i*5, null);
					break;
				case 104:
					img=fb.q1;
					g.drawImage(img, j*5, i*5, null);
					break;
				case 105:
					img=fb.g1;
					g.drawImage(img, j*5, i*5, null);
					break;
				case 106:
					img=fb.e1;
					g.drawImage(img, j*5, i*5, null);
					break;
				case 107:
					img=fb.r1;
					g.drawImage(img, j*5, i*5, null);
					break;
				case 108:
					img=fb.p1;
					g.drawImage(img, j*5, i*5, null);
					break;
				case 99:
					img=fb.stone;
					g.drawImage(img, j*5, i*5, null);
					break;
				////////////////////////////////////////////////////
					//塔and石头///
				////////////////////////////////////////////////////
					//地图and检查点///
				
				
				case 3:
					img=fb.img3;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 1:
					img=fb.img1;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 0:
					img=fb.img2;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				
				case 9:
					img=fb.img6;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 12:
					img=fb.imgx;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 51:
					img=fb.w1;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 52:
					img=fb.w2;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 53:
					img=fb.w3;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 54:
					img=fb.w4;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 55:
					img=fb.w5;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;
				case 100:	
					break;
				case 77:
					img=fb.enemy;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;	
				case 76:
					img=fb.img2;
					g.drawImage(img, j*5,i*5,5,5,null);
					break;	
				}	
			}
			
		}
		

		tf=false;
		if(mousem==true){
			g.setColor(Color.BLACK);
			
			g.drawString("("+zbx+","+zby+")", 80, 30);
		}
		g.setColor(Color.BLACK);
		g.drawString(frameRate.getFrameRate(), 30, 30);
		g.drawString("Press ESC to exit...", 30, 60);
		g.drawString("Press F10 to resetMap", 30, 90);
		
		//攻击范围显示
		if(ranget){
		g.setColor(Color.red);
		g.drawOval(xzy-(range/2)+13, xzx-(range/2)+13, range, range);
		}
		//攻击范围显示
		
	}
	
	
	
	
	public void createAndShowGUI(){
		Canvas canvas=new Canvas();
		canvas.setSize(925,925);
		canvas.setBackground(Color.BLACK);
		canvas.setIgnoreRepaint(true);
		getContentPane().add(canvas);
		setTitle("地图");
		setIgnoreRepaint(true);
		this.setResizable(false);
		pack();
		setVisible(true);
		canvas.createBufferStrategy(2);
		bs=canvas.getBufferStrategy();
		gameThread=new Thread(this);
		gameThread.start();
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON3){
					if(!startstop){
					build(e.getX(),e.getY());
					}else{
						JOptionPane.showMessageDialog(null, "开始阶段不能操作");
					}
				}
				if(e.getButton()==MouseEvent.BUTTON1){
					ranget=false;
					if(msgt){
					int n=ztfk.selectIndex(e.getY(), e.getX());
					boolean t=msgF.check(n);
					msgF.setEnemy(loop);
					if(t){
						int[] a=ztfk.getzhsz(n);
						int b=fb.getjz(a[0], a[1]);
						setRange(tower.getRange(b-101), a[0],a[1]);
					}
					
					}
				}
				if(e.getButton()==MouseEvent.BUTTON2){
					zbx=e.getX();
					zby=e.getY();
					int n=ztfk.selectIndex(e.getY(), e.getX());//输入当前坐标调用ztfk寻找当前坐标的‘整体方块’
//					ztfk.setFK(n);
					if(ztfk.check(n)){//检查是否关键
					ztfk.changeStone(n);
					}
				}
			}
		});
		
		
		
		canvas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
					shutdown();
				}
				if(e.getKeyCode()==KeyEvent.VK_F10){
					fb.test();
				}
				if(e.getKeyCode()==KeyEvent.VK_F4){
					
				}
				if(e.getKeyCode()==KeyEvent.VK_F5){
					if(mousem){
					mousem=false;
					}else{
					mousem=true;
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_F3){
					cc.find37();
					System.out.println(cc.fk[16][4]);
					System.out.println(cc.checkCan(16, 4));
					
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					Aiwalk.step(1);
					el[0].move(Aiwalk.getX(),Aiwalk.getY());
//					attack(Aiwalk.getX(),Aiwalk.getY());
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					Aiwalk.step(2);
					el[0].move(Aiwalk.getX(),Aiwalk.getY());
//					attack(Aiwalk.getX(),Aiwalk.getY());
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					Aiwalk.step(3);
					el[0].move(Aiwalk.getX(),Aiwalk.getY());
//					attack(Aiwalk.getX(),Aiwalk.getY());
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					Aiwalk.step(4);
					el[0].move(Aiwalk.getX(),Aiwalk.getY());
//					attack(Aiwalk.getX(),Aiwalk.getY());
				}
				if(e.getKeyCode()==KeyEvent.VK_F8){//测试按钮
					if(kaishi){
					startt();
					startstop=true;
					ThreadS();
					ThreadE();
					AI.display();
					kaishi=false;
					}else if(buildcount==0){
						JOptionPane.showMessageDialog(null, "选择一座塔保留其余变成石头");
					}
					else{
						JOptionPane.showMessageDialog(null, "还可以建"+buildcount+"座塔呢");
					}
					
				}
				if(e.getKeyCode()==KeyEvent.VK_F6){//测试按钮
					AThread AT=new AThread(500, 500, 165,300);
					AT.start();
//					System.out.println(liveAmmo);
//					System.out.println(Ammocount);
//					System.out.println(elai[0].getX()*5+","+el[0].getY()*5);
					
				}
				if(e.getKeyCode()==KeyEvent.VK_F9){//测试按钮
					
					System.out.println("怪物数量------"+count);
					System.out.println("怪物存活------"+countd);
					System.out.println("子弹存活数量------"+loop);
					System.out.println("回合？------"+startstop);
				}
				
				
				
				
				
				if(e.getKeyCode()==KeyEvent.VK_F12){
					cc.find37();
					for(int i=0;i<cc.fk.length;i++){
						for(int j=0;j<cc.fk[0].length;j++){
							System.out.print(cc.fk[i][j]);
						}
						System.out.println("");
					}
				}
				
			}
		});
		
	}
	
	public void ThreadE(){
		cc.find37();
		AI.setMaps(cc.getfk37());
		for(int i=0;i<AI.maps.length;i++){
			for(int j=0;j<AI.maps[0].length;j++){
				System.out.print(AI.maps[i][j]);
			}
			System.out.println("");
		}
		AI.findpath();
		int[][] path=AI.getpath();//寻找最短路径
		yt=new YThread(path,count);
		yt.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		running=true;
		frameRate.initialize();
		while(running){
			gameLoop();
		}
	}
	
	public void ThreadS(){//塔的线程启动
		tthread=new TThread[tc];
		for(int i=0;i<tc;i++){
			tthread[i]=new TThread(i);
			tthread[i].start();
		}
	}
	
	
	
	//The bs object is a BufferStrategy object, and
	//will be explained later in the chapter
	public void gameLoop(){
		do{
			do{
				g=null;
				try{
					
					g=bs.getDrawGraphics();
					g.clearRect(0, 0, getWidth(), getHeight());
					if(msgt){
						msgF.tz();
						}
					render(g);
					if(startstop){//回合开始
						renderEnmey(g);
					}
					renderAmmo(g);
					
				}
				finally{
					if(g!=null){
						g.dispose();
					}
				}
			}while(bs.contentsRestored());
			bs.show();
		}while(bs.contentsLost());
	}
	
	
	
	public void startt(){//载入全图塔的数据以及这波怪物的数据
		findEnemy.createRangeCount();
		findEnemy.createRange();
		int data[][]=findEnemy.getdata();
		int q=findEnemy.getCount();
		tra=new TowerRangeAttack[q];
		System.out.println("塔的线程已建立");
		for(int i=0;i<findEnemy.getCount();i++) {
			tra[i]=new TowerRangeAttack(tower.getMSG(data[i][0]), data[i][2], data[i][1]);	
		}
		tc=q;
		int c=enemy.getCount();
		el=new Enemylist[c];
		for(int j=0;j<c;j++){
			el[j]=new Enemylist(enemy.getMSG(loop),j+1);
		}
		count=c;
		countd=c;
		nnn=101;
	}
	public void shutdown(){
		try{
			running=false;
			gameThread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public class AThread extends Thread{//子弹的线程
		ArrayList<Integer> x=new ArrayList<Integer>();
		ArrayList<Integer> y=new ArrayList<Integer>();
		private int Order=0;
		private AmmoPath ammowalk=new AmmoPath();//子弹路径
		private boolean destory=false;
		public AThread(int TowerX,int TowerY,int TagerX,int TagerY){
			super();
//			AmmoMSG(TowerX,TowerY,TagerX,TagerY);
			ammowalk.walk(ammowalk.js1(TowerX, TowerY, TagerX, TagerY));
			x=ammowalk.getx();
			y=ammowalk.gety();
			ammoX.add(x.get(0));
			ammoY.add(y.get(0));
			Order=ammoX.lastIndexOf(x.get(0));
			
			this.setName("子弹线程"+Order);
		}
		public void run(){
				try {
					int s=0,l=0,counts=0;
					boolean t=true;
					if(ammowalk.getbs()){//如果返回true就正常排序，false就倒序
						System.out.println("正常方法");
						s=0;
						counts=s;
						t=true;
						l=x.size()-1;
					}else{
						System.out.println("不正常方法");
						s=x.size()-1;
						counts=s;
						t=false;
						l=0;
					}
					Ammocount++;
					while(!destory){
						if(t){
							ammoX.set(Order, x.get(counts));
							ammoY.set(Order, y.get(counts));
							counts++;
							Thread.sleep(10);
							if(counts>=l){
								destory=true;
								liveAmmo++;
								
								this.join();
							}
							
						}else{
							ammoX.set(Order, x.get(counts));
							ammoY.set(Order, y.get(counts));
							counts--;
							Thread.sleep(10);
							if(counts<=l){
								destory=true;
								liveAmmo++;
								this.join();
							}
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					System.out.println("删除线程？");
				}
			
		}
		
	}
	public class YThread extends Thread{//延迟怪物生成线程
		int[][] path;
		int c;
		public YThread(int[][] path,int count){
			this.path=path;
			this.c=count;
		}
		public void run(){
			try{
			et=new EThread[c];
			for(int i=0;i<c;i++){
				et[i]=new EThread(path,i);
				et[i].start();
				Thread.sleep(500);
				
			}
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				System.out.println("删除线程？");
			}
		}
		
	}
	
	public void build(int x,int y){
		boolean tttt=true;
		boolean ttttt=true;
		boolean tttttt=true;
		Object[] option={"建造","取消","拆除石头"};
		Object[] ready={"选择","取消"};
		ArrayList<Integer> ail=new ArrayList<>();
		ArrayList<Integer> numm=new ArrayList<>();
		numm.clear();
		ail.clear();
		int n=ztfk.selectIndex(y, x);//输入当前坐标调用ztfk寻找当前坐标的‘整体方块’
//		ztfk.setFK(n);
		if(ztfk.check(n)){//检查是否关键点
			for(int i=0;i<gtd.getRows();i++){
				if(ztfk.getInt(n)==tower.getOrder(i)){
					tttt=false;
					if(nowBuild.contains(n)){
					if(buildcount==0){
					ttttt=false;
					
					ArrayList<Integer> al=new ArrayList<>();
					al.clear();
					al=syTower.nowRount(syTower.check(ztfk.getInt(n)),nowBI);
					if(!(al.size()==0)){
						ArrayList<Object> or=new ArrayList<>();
						or.clear();
						or.add("选择");
						or.add("取消");
						for(Integer ali:al){
							System.out.println("bbbbbbbbbbbb");
							ail.add(ali);
							numm.add(syTower.compose.get(ali));
							or.add(syTower.name.get(ali));
						}
						ready=or.toArray();
					}
					
					int r=JOptionPane.showOptionDialog(null,"方块","选择",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ready,ready[0]);
					switch (r) {
					case -1:
						
						break;
					case 0:
						builded.remove(builded.indexOf(n));
						for(Integer j:builded){
							ztfk.changeStone(j);
						}
						builded.clear();
						nowBuild.clear();
						kaishi=true;
						break;
					case 1:
						break;
					case 2:
						ztfk.upgrade(n, numm.get(r-2));
						builded.remove(builded.indexOf(n));
						for(Integer j:builded){
							ztfk.changeStone(j);
						}
						builded.clear();
						nowBuild.clear();
						kaishi=true;
						break;
					case 3:
						ztfk.upgrade(n, numm.get(r-2));
						builded.remove(builded.indexOf(n));
						for(Integer j:builded){
							ztfk.changeStone(j);
						}
						builded.clear();
						nowBuild.clear();
						kaishi=true;
						break;
					case 4:
						ztfk.upgrade(n, numm.get(r-2));
						builded.remove(builded.indexOf(n));
						for(Integer j:builded){
							ztfk.changeStone(j);
						}
						builded.clear();
						nowBuild.clear();
						kaishi=true;
						break;
					case 5:
						ztfk.upgrade(n, numm.get(r-2));
						builded.remove(builded.indexOf(n));
						for(Integer j:builded){
							ztfk.changeStone(j);
						}
						builded.clear();
						nowBuild.clear();
						kaishi=true;
						break;
					case 6:
						ztfk.upgrade(n, numm.get(r-2));
						builded.remove(builded.indexOf(n));
						for(Integer j:builded){
							ztfk.changeStone(j);
						}
						builded.clear();
						nowBuild.clear();
						kaishi=true;
						break;
					}
					}
					}else if(buildcount==0){
						ttttt=false;
						tttt=false;
						cc.find37();
						ArrayList<Integer> al=new ArrayList<>();
						al.clear();
						al=syTower.nowRount(syTower.check(ztfk.getInt(n)),cc.towerOrder);
						if(!(al.size()==0)){
							ArrayList<Object> or=new ArrayList<>();
							or.clear();
							or.add("取消");
							for(Integer ali:al){
								ail.add(ali);
								numm.add(syTower.compose.get(ali));
								or.add(syTower.name.get(ali));
							}
							ready=or.toArray();
						}
						
						int r=JOptionPane.showOptionDialog(null,"方块","选择",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ready,ready[0]);
						switch (r) {
						case -1:
							break;
						case 0:
							break;
						case 1:
							ztfk.upgrade(n, numm.get(r-1));
							for(Integer aaa:syTower.CraftGuide.get(ail.get(r-1))){
								if(aaa!=ztfk.getInt(n)){
									for(int ii=0;ii<fb.jz.length;ii++){
										for(int jj=0;jj<fb.jz[0].length;jj++){
											if(fb.jz[ii][jj]==aaa){
												ztfk.changeStone(ztfk.selectIndex(ii*5, jj*5));
											}
										}
									}
								}
							}
							break;
						case 2:
							break;
						case 3:
							ztfk.upgrade(n, numm.get(r-2));
							builded.remove(builded.indexOf(n));
							for(Integer j:builded){
								ztfk.changeStone(j);
							}
							builded.clear();
							nowBuild.clear();
							kaishi=true;
							break;
						case 4:
							ztfk.upgrade(n, numm.get(r-2));
							builded.remove(builded.indexOf(n));
							for(Integer j:builded){
								ztfk.changeStone(j);
							}
							builded.clear();
							nowBuild.clear();
							kaishi=true;
							break;
						case 5:
							ztfk.upgrade(n, numm.get(r-2));
							builded.remove(builded.indexOf(n));
							for(Integer j:builded){
								ztfk.changeStone(j);
							}
							builded.clear();
							nowBuild.clear();
							kaishi=true;
							break;
						case 6:
							ztfk.upgrade(n, numm.get(r-2));
							builded.remove(builded.indexOf(n));
							for(Integer j:builded){
								ztfk.changeStone(j);
							}
							builded.clear();
							nowBuild.clear();
							kaishi=true;
							break;
						
						}
					}
				}
			}
			if(buildcount==0 && ttttt && tttt){
				JOptionPane.showMessageDialog(null, "没有建造次数了");
				tttt=false;
			}
			if(tttt){
				ztfk.selectFK(n);//选中效果
				int b=JOptionPane.showOptionDialog(null,"方块","选择",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
				
				switch(b){
				case -1:
					ztfk.selectKF(n);//还原选中效果
					break;
				case 0:
//					ztfk.setFK(n);//在选中位置设置方块
					ztfk.upgrade(n, nnn);
					nnn++;
					if(cc.check()){
						builded.add(n);
						nowBuild.add(n);
						nowBI.add(ztfk.getInt(n));
						buildcount--;
						break;
					}
					ztfk.resetFk(n);
					JOptionPane.showMessageDialog(null, "不能将迷宫完全闭合");
					
					break;
				case 1:
					ztfk.selectKF(n);//还原选中效果
					break;
				case 2:
					ztfk.resetFk(n);//拆除石头
					break;
				
					}
				}
				
			
		}
		else{
				JOptionPane.showMessageDialog(null, "此方块不可操作");
			}
	}
	
	
	
	
	
	
	public void death(){
		countd--;
		if(countd==0){
			System.out.println("回合结束触发");
			Ammocount=0;
			liveAmmo=0;
			count=0;
			loop++;
			buildcount=5;
			msgF.setEnemy(loop);
			startstop=false;
			System.out.println("重置完成");
			try {
				yt.join();
				for(int i=0;i<et.length;i++){
					et[i].join();
				}
				System.out.println("怪物线程join");
				for(int i=0;i<tthread.length;i++){
					tthread[i].join();
				}
				System.out.println("塔线程join");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("出错了？");
				e.printStackTrace();
			}
			
			
			
		}
	}
	
	public class EThread extends Thread{
		int[][] path;
		int index;
		public EThread(int[][] path,int index){
			this.path=Apath(path);
			this.index=index;
		}
		public void run(){
			try{
				for(int i=0;i<path.length;i++){
					if(el[index].death()){
						death();
						break;
					}
					if(i==path.length-1){
						el[index].move(0, 0);
						death();
						break;
					}
					el[index].move(path[i][1], path[i][0]);
					Thread.sleep(50);
				}
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				System.out.println("怪物挂了");
			}
		}
		
		public int[][] Apath(int[][] path){//精准路径（细化像素路径）
			int size=path.length;
			int[][] apath=new int[size*5][2];
			int num=0;
			for(int i=0;i<path.length-1;i++){
				int nn=num;
				for(int n=nn;n<nn+6;n++){
					apath[n][0]=path[i][0]*5;
					apath[n][1]=path[i][1]*5;
					
				}
				num=nn;
				if(path[i][0]>=path[i+1][0]){
					int s=0;
					for(int j=path[i][0]*5;j>path[i+1][0]*5;j--){
						apath[num][0]=path[i][0]*5-s;
						num++;
						s++;
					}
					num=nn;
				}else{
					int s=0;
					for(int j=path[i][0]*5;j<path[i+1][0]*5;j++){
						apath[num][0]=path[i][0]*5+s;
						num++;
						s++;
					}
					num=nn;
				}
				if(path[i][1]>=path[i+1][1]){
					int s=0;
					for(int j=path[i][1]*5;j>path[i+1][1]*5;j--){
						apath[num][1]=path[i][1]*5-s;
						num++;
						s++;
					}
					num=nn;
				}else{
					int s=0;
					for(int j=path[i][1]*5;j<path[i+1][1]*5;j++){
						apath[num][1]=path[i][1]*5+s;
						num++;
						s++;
					}
					num=nn;
				}
				num=num+5;
			}
			return apath;
		}
		
	}
	
	
	
	
	
	
	
	public class TThread extends Thread{//塔的线程
		private int traindex;
		public TThread(int index){//输入tra的index
			super();
			traindex=index;
			this.setName("塔"+index);
		}
		
		synchronized public void run(){
			try{
				boolean ttt=false;
				boolean t=false;
				while(startstop){
					Thread.sleep(1000-tra[traindex].getAS());
					for(int i=0;i<count;i++){
						t=tra[traindex].Range(el[i].getX()*5+13, el[i].getY()*5+13);
						if(t){
							ttt=true;
							System.out.print("攻击");
							System.out.println("塔的坐标（"+tra[traindex].getX()+","+tra[traindex].getY()+"）");
							System.out.println("怪物的坐标（"+el[i].getX()*5+","+el[i].getY()*5+"）");
							if(tra[traindex].getLock(el[i].getOrder())){
							AThread a=new AThread(tra[traindex].getX(), tra[traindex].getY(), el[i].getX()*5+26, el[i].getY()*5+26);
							a.start();
							}
							el[i].changeHP(tra[traindex].attack(el[i].getOrder(), el[i].Amror(), el[i].getHP(), el[i].Mr()));
							System.out.println(tra[traindex].getName()+"攻击怪物"+el[i].getOrder()+"----剩余血量："+el[i].getHP());
							
						}
					}
					if(ttt){
						if(!tra[traindex].Range(el[tra[traindex].getLockorder()-1].getX()*5+13, el[tra[traindex].getLockorder()-1].getY()*5+13)){
							tra[traindex].checkLock();
							ttt=false;
							Thread.sleep(100);
						}	
					}
					
				}
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				System.out.println(this.getName()+"塔的线程停了");
			}
		}
		
	}
	
}
