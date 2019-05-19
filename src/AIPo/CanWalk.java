package AIPo;
import map.*;

public class CanWalk {
	private fb fb=new fb();
	private int canwalk[]={0,1,2,3,51,52,53,54,55,77,76,88};
	private int[][] raid=new int[37][37];
	private int[][] record=new int[37*37][2];
	private int count=0;
	int ii=0,jj=0;
	private int nowx=0,nowy=0;
	
	public void xs(){
		for(int i=0;i<fb.jz.length;i=i+5){
			flag:for(int j=0;j<fb.jz[0].length;j=j+5){
				for(int z=0;z<canwalk.length;z++){
					if(canwalk[z]==fb.jz[i][j]){
						raid[ii][jj]=0;
						jj++;
						break;
					}
					else if(z==canwalk.length-1){
						
						raid[ii][jj]=1;
						jj++;
						break;
					}
					
				}
				
			}
			ii++;
			jj=0;
			System.out.println("");
		}
	}
	
	public void xx(){
		for(int i=0;i<raid.length;i++){
			for(int j=0;j<raid[0].length;j++){
				System.out.print(raid[i][j]);
			}
			System.out.println("");
		}
	}
	
	
	public void lj(int x1,int y1,int x2,int y2){
		boolean t=true,t1=true,t2=false;
		int xf=0,xfx=0;
		int yf=0,yfy=0;
		nowx=x1;
		nowy=y1;
		if(x1<=x2){
			xf=4;//往右
			xfx=3;
		}else if(x1>x2){
			xf=3;//左
			xfx=4;
		}
		if(y1<=y2){
			yf=2;//下
			yfy=1;
		}else if(y1>y2){
			yf=1;//上
			yfy=2;
		}
		while(t){
			while(t1){
				t1=step(xf);
				if(t1){
					continue;
				}
				t1=step(yf);
				if(t1){
					continue;
				}
				
				t2=true;
			}
			while(t2){
				t2=step(xfx);
				if(t2){
					continue;
				}
				t2=step(yfy);
				if(t2){
					continue;
				}
			}
			
		}	
	}
	public void js(){
		lj(4, 5, 4, 18);
	}
	public boolean step(int a){//走一步
		boolean b1=false,b2=false,b3=false,b4=false,b5=false;
		int changex=0,changey=0;
		
		if(nowx==0 && nowy==0){
			if(a==3 || a==1){
//			int c[]={2,4};
//			int r=(int) (Math.random()*2);
//			a=c[r];
//			System.out.println("我大变向了！-"+a);
				return false;
			}
		}else if(nowx==36 && nowy==36){
			if(a==2 || a==4){
//				int c[]={1,3};
//				int r=(int) (Math.random()*2);
//				a=c[r];
//				System.out.println("我大变向了！-"+a);
				return false;
				}
		}else if(nowx==0){
			if(a==3){
//				int c[]={1,2,4};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("我变向了！-"+a);
				return false;
			}
		}else if(nowy==0){
			if(a==1){
//				int c[]={3,2,4};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("我变向了！-"+a);
				return false;
			}
		}else if(nowx==36){
			if(a==4){
//				int c[]={3,2,1};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("我变向了！-"+a);
				return false;
			}
		}else if(nowy==36){
			if(a==2){
//				int c[]={3,1,4};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("我变向了！-"+a);
				return false;
			}
			
		}
		switch (a) {
		case 1:	//往上走
			changex=nowx;
			changey=nowy-1;
			b1=check(raid[nowx][nowy-1]);
			break;
		case 2:	//往下走
			changex=nowx;
			changey=nowy+1;
			b1=check(raid[nowx][nowy+1]);
			
			break;
		case 3:	//往左走
			changex=nowx-1;
			changey=nowy;
			b1=check(raid[nowx-1][nowy]);
			
			break;
		case 4:	//往右走
			changex=nowx+1;
			changey=nowy;
			b1=check(raid[nowx+1][nowy]);
			

		}
		
		
		
		if(b1 && b5){
	
		System.out.println("移动前坐标：（"+nowx+","+nowy+"）");
		System.out.println("移动后格子："+raid[nowx][nowy]);
		System.out.println("移动后坐标：（"+changex+","+changey+"）");
		System.out.println("移动后格子："+raid[changex][changey]);
		nowx=changex;
		nowy=changey;
		return true;
		}else{
			System.out.println("移动失败---"+raid[changex][changey]);
			System.out.println();
			return false;
		}
	}
	private boolean check(int n){//检查下个点是否可走
		
		if(0==n){
		return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {

		
	}

}
