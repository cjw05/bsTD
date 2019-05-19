package AIPo;
import java.util.ArrayList;
import java.util.Random;

import map.*;

public class checkMaze {

		private fb fb=new fb();
		private int canwalk[]={0,1,2,3,51,52,53,54,55,88};//可用走的属性
		public int[][] fk=new int[37][37];//大方块
		private int[][] record=new int[37*37][2];
		private int count=0;
		private int[][] pointXY={{18,4},{18,32},{4,32},{4,18},{32,18},{32,32}};
		public ArrayList<Integer> towerOrder=new ArrayList<>();
		
		int ii=0,jj=0;
		private int nowx=0,nowy=0;
		public void find37(){//判定37x37个整体方块的属性
			towerOrder.clear();
			int numa=0,numb=0;;
			for(int i=0;i<fb.jz.length;i=i+5){
				for(int j=0;j<fb.jz[0].length;j=j+5){
					fk[numa][numb]=fb.jz[i][j];
					if(fb.jz[i][j]>=101){
					towerOrder.add(fb.jz[i][j]);
					}
					numb++;
				}
				numa++;
				numb=0;
			}
		}
		public void display(){
			for(int i=0;i<fk.length;i++){
				for(int j=0;j<fk[0].length;j++){
					System.out.print(fk[i][j]);
				}
				System.out.println("");
			}
		}
		public int[][] getfk37(){
			find37();
			return fk;
		}
		ArrayList<Integer> passXX=new ArrayList<Integer>();
		ArrayList<Integer> passYY=new ArrayList<Integer>();
		public boolean checkRoad(){
			int countx=0;
			ArrayList<Integer> passx=new ArrayList<Integer>();
			ArrayList<Integer> passy=new ArrayList<Integer>();
			ArrayList<Integer> road=new ArrayList<Integer>();
			ArrayList<Integer> stepcount=new ArrayList<Integer>();
			Random rd=new Random();
			int nowx=5,nowy=4;
			int pd=0;
			int cw[]={51,52,53,54,55,88};
			passx.add(5);
			passy.add(4);
			while(true){
				for(int p=0;p<passx.size();p++){
					System.out.println("走一轮了-----"+passx.get(p)+"  "+passy.get(p));
					nowx=passx.get(p);
					nowy=passy.get(p);
					flag:for(int i=0;i<4;i++){
						int[] a=step(i,nowx,nowy);
						for(int w=0;w<passx.size();w++){
							if(passx.get(w)==a[0] && passy.get(w)==a[1]){
								continue flag;
							}
						}
						if(checkCan(a[0],a[1])){
							nowx=a[0];
							nowy=a[1];
							passx.add(a[0]);
							passy.add(a[1]);
							passXX.add(a[0]);
							passYY.add(a[1]);
						}
					}
				for(int ii=0;ii<6;ii++){
					if(fk[passx.get(p)][passy.get(p)]==cw[ii]){
						
						System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
						System.out.println(passx.get(p)+","+passy.get(p));
						pd++;
					}
				}
				
				}
				System.out.println("一共走了"+passx.size()+"步");
				System.out.println("经过了"+pd+"关键点");
				if(pd==6){
					return true;
				}
				return false;
			}
			
		}
		
		public void test(){
			int[][] a=new int[37][37];
			for(int i=0;i<37;i++){
				for(int j=0;j<37;j++){
					a[i][j]=1;
				}
			}
			for(int i=0;i<passXX.size();i++){
				int aa=passXX.get(i);
				int bb=passYY.get(i);
				a[aa][bb]=0;
				
			}
			
			
			for(int i=0;i<37;i++){
				for(int j=0;j<37;j++){
					System.out.print(a[i][j]);
				}
			}
		}
		
		
		
		
		
		
		
		public int[] step(int t,int x,int y){//下一步
			int[] a=new int[2];
			if(t==0){//上
				a[0]=x-1;
				a[1]=y;
			}else if(t==1){//下
				a[0]=x+1;
				a[1]=y;
			}else if(t==2){//左
				a[0]=x;
				a[1]=y-1;
			}else if(t==3){//右
				a[0]=x;
				a[1]=y+1;
			}
			if(a[0]<0 || a[1]<0 || a[0]>=37 || a[1]>=37){
				a[0]=x;
				a[1]=y;
			}
			return a;
		}
		public boolean checkCan(int x,int y){
			for(int i=0;i<canwalk.length;i++){
				if(canwalk[i]==fk[x][y]){
					
					return true;
				}
			}
			
			return false;
		}
		public void aaa(){
			for(int i=0;i<fk.length;i++){
				for(int j=0;j<fk[0].length;j++){
					if(fk[i][j]==51 || fk[i][j]==52 || fk[i][j]==53 || fk[i][j]==54 || fk[i][j]==55 || fk[i][j]==88){
						System.out.println(i+","+j);
					}
				}
			}
		}
		
		public boolean check(){
			find37();
			return checkRoad();
		}
		
		
		
		
		
		public static void main(String[] args) {
			checkMaze c=new checkMaze();
			c.fb.test();
			c.find37();
			for(int i=0;i<c.fk.length;i++){
				for(int j=0;j<c.fk[0].length;j++){
					System.out.print(c.fk[i][j]);
				}
				System.out.println();
			}
		}
		

	

}
