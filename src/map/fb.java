package map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class fb{
	
	public BufferedImage img1=null,img2=null,img3=null,img4=null,img5=null,imgn=null,img6=null;
	public BufferedImage imgx=null,w1=null,w2=null,w3=null,w4=null,w5=null,stone=null,test=null,enemy=null;
	public BufferedImage d1=null,b1=null,y1=null,e1=null,g1=null,q1=null,r1=null,p1=null,hyaline=null;
	public BufferedImage[] health=new BufferedImage[20];
	public BufferedImage ammo=null;
	//public JLabel[] jm=new JLabel[34225];
	public int jms=0;
	public int zbx=0;
	public int zby=0;
	public int bl=5;
	public coordinate cd;
	////;
	
	
	//////////////////////////////////////////////////////////////////////////////
	//      0,1��ͨ��               3���ߵ�       88�յ�     76,77���ֵ�         51��1  52��2 53��3 54��4 55��5
	//      101=D;102=B;103=Y;104=Q;105=G;106=E;107=R;108=P
	//////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public BufferedImage getHealth(int percent){
		if(percent>0 && percent<=20){
		return health[percent];
		}else{
		return health[0];
		}
	}
	
	
	public void im(){
		try{
			System.out.println("���سɹ�");
			//img1=ImageIO.read(new File("./�ز�/���Ը���.jpg"));
			img1=ImageIO.read(new File("./�ز�/�ڸ���.jpg"));
			img2=ImageIO.read(new File("./�ز�/�׸���.jpg"));
			img3=ImageIO.read(new File("./�ز�/5px����.jpg"));
			img4=ImageIO.read(new File("./�ز�/5px�е�.jpg"));
			img5=ImageIO.read(new File("./�ز�/5px�����׸���.jpg"));
			img6=ImageIO.read(new File("./�ز�/5pxPink.jpg"));
			imgx=ImageIO.read(new File("./�ز�/ѡ��ͼƬ.jpg"));
			w1=ImageIO.read(new File("./�ز�/1point.jpg"));
			w2=ImageIO.read(new File("./�ز�/2point.jpg"));
			w3=ImageIO.read(new File("./�ز�/3point.jpg"));
			w4=ImageIO.read(new File("./�ز�/4point.jpg"));
			w5=ImageIO.read(new File("./�ز�/5point.jpg"));
			d1=ImageIO.read(new File("./�ز�/d1.jpg"));
			b1=ImageIO.read(new File("./�ز�/b1.jpg"));
			y1=ImageIO.read(new File("./�ز�/y1.jpg"));
			e1=ImageIO.read(new File("./�ز�/e1.jpg"));
			q1=ImageIO.read(new File("./�ز�/q1.jpg"));
			g1=ImageIO.read(new File("./�ز�/g1.jpg"));
			r1=ImageIO.read(new File("./�ز�/r1.jpg"));
			p1=ImageIO.read(new File("./�ز�/p1.jpg"));
			hyaline=ImageIO.read(new File("./�ز�/hyaline.jpg"));
			stone=ImageIO.read(new File("./�ز�/stone.jpg"));
			test=ImageIO.read(new File("./�ز�/test.png"));
			enemy=ImageIO.read(new File("./�ز�/5px�е�.jpg"));
			ammo=ImageIO.read(new File("./�ز�/Ammo.png"));
			
			for(int i=0;i<20;i++){
				health[i]=ImageIO.read(new File("./�ز�/health/health"+i+".jpg"));
			}
			
//			health[1]=ImageIO.read("./�ز�/health/health1.jpg");
//			health[2]=ImageIO.read("./�ز�/health/health2.jpg");
//			health[3]=ImageIO.read("./�ز�/health/health3.jpg");
//			health[4]=ImageIO.read("./�ز�/health/health4.jpg");
//			health[5]=ImageIO.read("./�ز�/health/health5.jpg");
//			health[6]=ImageIO.read("./�ز�/health/health6.jpg");
//			health[7]=ImageIO.read("./�ز�/health/health7.jpg");
//			health[8]=ImageIO.read("./�ز�/health/health8.jpg");
//			health[9]=ImageIO.read("./�ز�/health/health9.jpg");
//			health[10]=ImageIO.read("./�ز�/health/health10.jpg");
//			health[11]=ImageIO.read("./�ز�/health/health11.jpg");
//			health[12]=ImageIO.read("./�ز�/health/health12.jpg");
//			health[13]=ImageIO.read("./�ز�/health/health13.jpg");
//			health[14]=ImageIO.read("./�ز�/health/health14.jpg");
//			health[15]=ImageIO.read("./�ز�/health/health15.jpg");
//			health[16]=ImageIO.read("./�ز�/health/health16.jpg");
//			health[17]=ImageIO.read("./�ز�/health/health17.jpg");
//			health[18]=ImageIO.read("./�ز�/health/health18.jpg");
//			health[19]=ImageIO.read("./�ز�/health/health19.jpg");
//			health[20]=ImageIO.read("./�ز�/health/health20.jpg");
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static int jz[][]=new int[37*5][37*5];
	public static int jzb[][]=new int[37*5][37*5];
	int c=1;
	int p;
	
	
	
	public void walkPoint(int x,int y,int x1,int y1,int p){//·��������
		for(int i=x;i<=x1;i++){
			for(int j=y;j<=y1;j++){
				System.out.println("("+i+","+j+")");
				jz[i][j]=p;
				jzb[i][j]=p;
			}
		}
	}
	public void wp(){
		walkPoint(90, 20, 94, 24, 51);
		walkPoint(90, 160, 94, 164, 52);
		walkPoint(20, 160, 24, 164, 53);
		walkPoint(20, 90, 24, 94, 54);
		walkPoint(160, 90, 164, 94, 55);
		jz[20][20]=76;
		jz[22][22]=77;
		jzb[20][20]=76;
		jzb[22][22]=77;
		for(int i=160;i<165;i++){
			for(int j=160;j<165;j++){
				jz[i][j]=88;
				jzb[i][j]=88;
			}
		}
	}
	
	public int getRows(){
		return jz.length;
	}
	public int getColums(){
		return jz[0].length;
	}
	
	
	
	public void init(){
		for(int j=0;j<jz.length;j++){
			for(int i=0;i<jz[0].length;i++){
				if(j%10<5){
					if(i%10<5){
						p=1;
					}
					else{p=2;}
				}else{
					if(i%10<5){
						p=2;
					}
					else{p=1;}
					
				}
				
				switch(p){
				case 1:
					jz[j][i]=1;
					jzb[j][i]=1;
					break;
				case 2:
					jz[j][i]=0;
					jzb[j][i]=0;
					break;
				}
			}
		}
		
		for(int i=0;i<jz.length;i++){
			for(int j=0;j<5;j++){
				jz[i][90+j]=3;
				jz[90+j][i]=3;
				jzb[i][90+j]=3;
				jzb[90+j][i]=3;
			}
		}
		
	}
	
	
	
	public void test(){
		init();
		im();
		wp();
		
		
	}
	
	
	public int getjz(int x,int y){
		return jz[x][y];
	}
	
	public static void main(String[] args) {
		fb f=new fb();
		f.test();
		for(int i=0;i<f.jz.length;i++){
			for(int j=0;j<f.jz[0].length;j++){
				System.out.print(f.jz[i][j]);
			}
			System.out.println();
		}
		System.out.println(jz[90][20]);
	}
	
	
	
	
	
/*	public void xr(){//��Ⱦ��ͼ
		init();
		fmp();
		im();
		int mun=0;	
		for(int j=0;j<jz.length;j++){
			for(int i=0;i<jz[0].length;i++){
				switch(jz[j][i]){
				case 3:
					jm[jms]=new JLabel(new ImageIcon(img3));
					//cd.setCD(i, j,jms);
					break;
				case 1:
					jm[jms]=new JLabel(new ImageIcon(img1));
					//cd.setCD(i, j,jms);
					break;
				case 0:
					jm[jms]=new JLabel(new ImageIcon(img2));
					//cd.setCD(i, j,jms);
					break;
				case 5:
					jm[jms]=new JLabel(new ImageIcon(img4));
					break;
				}
				jm[jms].setBounds(zbx,zby,bl,bl);
				
				jms++;
				zbx=zbx+bl;
				mun++;
				System.out.print(jz[j][i]);
			}
			System.out.println("");
			zby=zby+bl;
			zbx=0;
		}

		System.out.println(mun);
		
	}
	*/	
//		class MouseHandler extends MouseAdapter{
//			public void mouseClicked(MouseEvent e){
//				if(e.getButton()==MouseEvent.BUTTON1){
//					System.out.println("("+e.getX()+","+e.getY()+")");
//				}
//			}
//			public void mouseEntered(MouseEvent e){
//				//System.out.println("("+e.getX()+","+e.getY()+")");
//			}
//		}
		
		
		
		
		
		
//		for(int e=0;e<37;e++){
//			if(e%2==0){
//				for(int w=0;w<5;w++){
//					for(int q=0;q<37;q++){
//						if(q%2==0){
//							for(int i=0;i<5;i++){
//								
//							}
//						}
//						else{
//							for(int j=0;j<5;j++){
//								jm[jms]=new JLabel(new ImageIcon(img2));
//								jm[jms].setBounds(zbx,zby,bl,bl);
//								jms++;
//								zbx=zbx+bl;
//								System.out.print("0");
//								mun++;
//							}
//						}
//						
//					}
//					zby=zby+bl;
//					zbx=0;
//					System.out.println("");//����
//					
//				}
//			}
//			else{
//				for(int w=0;w<5;w++){
//					for(int q=0;q<37;q++){
//						if(q%2==0){
//							for(int i=0;i<5;i++){
//								jm[jms]=new JLabel(new ImageIcon(img2));
//								jm[jms].setBounds(zbx,zby,bl,bl);
//								jms++;
//								zbx=zbx+bl;
//								System.out.print("0");
//								mun++;
//							}
//						}
//						else{
//							for(int j=0;j<5;j++){
//								jm[jms]=new JLabel(new ImageIcon(img1));
//								jm[jms].setBounds(zbx,zby,bl,bl);
//								jms++;
//								zbx=zbx+bl;
//								System.out.print("1");
//								mun++;
//								
//							}
//						}
//						
//					}
//					
//					zby=zby+bl;
//					zbx=0;
//					System.out.println("");//����
//					
//					
//				}
//			}
//		}
//			
//			
//			
//			
//			
//			System.out.println(mun);
//			
//			
//			
//			
//		}

	
	
	
	
	
}
