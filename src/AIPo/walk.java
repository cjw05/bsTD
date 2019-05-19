package AIPo;
import map.*;


public class walk {
	private fb fb=new fb();
	private int canwalk[]={0,1,2,3,51,52,53,54,55,88,77,76};//可走的点
	public int nowx=20,nowy=25;
	private int jl=4;
	int[][] record=new int[37*37*5*5][2];
	int count=0;
	int countt=0;
	
	
	public void init(){
		fb.test();
	}
	
	private boolean check(int n){//检查下个点是否可走
		for(int i=0;i<canwalk.length;i++){
		if(canwalk[i]==n){
		return true;
		}
		}
		return false;
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
		}else if(nowx==fb.jz.length-1 && nowy==fb.jz.length-1){
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
		}else if(nowx==fb.jz.length-1){
			if(a==4){
//				int c[]={3,2,1};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("我变向了！-"+a);
				return false;
			}
		}else if(nowy==fb.jz.length-1){
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
			b1=check(fb.jz[nowx][nowy-1]);
			b2=check(fb.jz[nowx+jl][nowy-1+jl]);
			b3=check(fb.jz[nowx+jl][nowy-1]);
			b4=check(fb.jz[nowx][nowy-1+jl]);
			break;
		case 2:	//往下走
			changex=nowx;
			changey=nowy+1;
			b1=check(fb.jz[nowx][nowy+1]);
			b2=check(fb.jz[nowx+jl][nowy+1+jl]);
			b3=check(fb.jz[nowx+jl][nowy+1]);
			b4=check(fb.jz[nowx][nowy+1+jl]);
			break;
		case 3:	//往左走
			changex=nowx-1;
			changey=nowy;
			b1=check(fb.jz[nowx-1][nowy]);
			b2=check(fb.jz[nowx-1+jl][nowy+jl]);
			b3=check(fb.jz[nowx-1+jl][nowy]);
			b4=check(fb.jz[nowx-1][nowy+jl]);
			break;
		case 4:	//往右走
			changex=nowx+1;
			changey=nowy;
			b1=check(fb.jz[nowx+1][nowy]);
			b2=check(fb.jz[nowx+1+jl][nowy+jl]);
			b3=check(fb.jz[nowx+1+jl][nowy]);
			b4=check(fb.jz[nowx+1][nowy+jl]);

		}
		
		for(int i=0;i<=count;i++){
			if(record[count][0]==changex && record[count][1]==changey){
				b5=false;
			}else{
				b5=true;
			}
		}
		
		
		if(b1 && b2 && b3 && b4 && b5){
	
		System.out.println("移动前坐标：（"+nowx+","+nowy+"）");
		System.out.println("移动后格子："+fb.jz[nowx][nowy]);
		System.out.println("移动后坐标：（"+changex+","+changey+"）");
		System.out.println("移动后格子："+fb.jz[changex][changey]);
		nowx=changex;
		nowy=changey;
		
		return true;
		}else{
			System.out.println("移动失败---"+fb.jz[changex][changey]);
			System.out.println();
			return false;
		}
	}
	public int getX(){
		return nowx;
	}
	public int getY(){
		return nowy;
	}
	
	
	public boolean checkRoad(){//检查迷宫是否被堵住
		int noup[]={2,3,4};//做不向上移动
		int nodown[]={1,3,4};//做不向下移动
		int noleft[]={1,2,4};//做不向左移动
		int noright[]={1,2,3};//做不向右移动
		int[][] record=new int[37*37*5*5][2];
		
		boolean t1=false,t2=false,t3=false;
		int[][] direction={{1,3,4},{2,3,4},{1,2,3},{1,2,4}};//{走了上不向下移动}...{走了左不向右移动}...
		int[][] dct;
		
		int checkpx,checkpy;//检查点x，y；
		
		start:for(int i=1;i<=4;i++){//起点
			t1=step(i);//这一步是否可以走
			int c=i;
			Record(t1);
			StartFirst:while(t1){//起点到1号点：
				for(int j=0;j<3;j++){
					step(direction[c][j]);
					if(step(direction[c][j]) && nowx==20 && nowy==90){//成功到达点1
						t2=true;
						break start;
					}
					c=direction[c][j];
				}
			}
		}
		
		return true;

		//return false;
		
	}
	public void Record(boolean t){
		if(t){
		record[count][0]=nowx;
		record[count][1]=nowy;
		count++;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		walk w=new walk();
		w.init();
		int[][] record=new int[25000][25000];
		System.out.println(record[10000][1000]);
//		
//			System.out.println("true");
		
	}

}
