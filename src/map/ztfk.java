package map;
import java.util.Random;

import map.*;
import test.*;


public class ztfk {//���巽��
	
	private int cdm;//��������
	public static int zhsz[][]=new int[37*37*5*5][2];//�������[][2]
	private ctext tx;
	public int zi=0;
	private fb fb=new fb();
	private int sfk[]=new int[25];
	public int[] unuseindex={3825,4150,16750,17450,29700,30050,30400};//������index
	
	public void compose(){
		
	}
	
	public int[] getzhsz(int index){
		return zhsz[index];
	}
	
	public void zh(){//���
		fb fb=new fb();
		fb.test();
		for(int i=0;i<185;i=i+5){
			for(int j=0;j<185;j=j+5){
				js(i,j,i+4,j+4);
				
			}
		}
		
		
	}
	public int getInt(int index){//����zhsz��index��ȡfz��Ӧ�Ĵ���
		 return fb.getjz(zhsz[index][0], zhsz[index][1]);
	}
	
	
	
	
	public void js(int xa, int ya, int xb, int yb){//�������巽�������
		//(xa,ya).(xb,yb)
		for(int i=xa;i<=xb;i++){
			for(int j=ya;j<=yb;j++){
				zhsz[zi][0]=i;
				zhsz[zi][1]=j;
				zi++;
			}
		}
	}
	
	
	
	
	public int selectIndex(int xa,int ya){//�������������巽���index
//		tx=new ctext();
		int num=0;
		for(int i=xa;i>=xa-5;i--){
			for(int j=ya;j>=ya-5;j--){
				for(int ii=0;ii<zhsz.length;ii++) {
					num++;
					if(i==zhsz[ii][0]*5 && j==zhsz[ii][1]*5) {
						System.out.println(zhsz[ii][0]+","+zhsz[ii][1]);
						return jss(ii);
					}
				}
			}
		}
		System.out.println("����ʧ�ܣ���Ѱ�ˣ�"+num);
		return -1;
	}
	
	public int jss(int index) {
		flag:for(int i=0;i<37*37*5*5;i=i+25) {
			for(int j=index;j>index-25;j--) {
				if(i==j) {
					System.out.println("25�����е�:"+i);
					return i;
				}
			}
		}
	return -1;
	}
	
	public void setFK(int index){//���ѡ�д󷽿���ֵ
		fb.jz[zhsz[index][0]][zhsz[index][1]]=rdb();
		for(int i=index+1;i<index+25;i++){
			int a=zhsz[i][0];
			int b=zhsz[i][1];
			fb.jz[a][b]=100;
		}
		
	}
	public void upgrade(int index,int Int){//����ѡ�д󷽿���ֵ
		fb.jz[zhsz[index][0]][zhsz[index][1]]=Int;
		for(int i=index+1;i<index+25;i++){
			int a=zhsz[i][0];
			int b=zhsz[i][1];
			fb.jz[a][b]=100;
		}
		
	}
	
	
	
	public int rdb(){//���������
		Random rd=new Random();
		return 101+rd.nextInt(8);
		
	}
	
	public void changeStone(int index){//ѡ�з��齨��ʯͷ
		fb.jz[zhsz[index][0]][zhsz[index][1]]=99;
		for(int i=index+1;i<index+25;i++){
			int a=zhsz[i][0];
			int b=zhsz[i][1];
			fb.jz[a][b]=100;
		}
		for(int i=index;i<index+25;i++){
			int a=zhsz[i][0];
			int b=zhsz[i][1];
			System.out.println(fb.jz[a][b]);
		}
	}
	
	
	public void resetFk(int index){//����ѡ�д󷽿���ֵ
		for(int i=index;i<index+25;i++){
			int a=zhsz[i][0];
			int b=zhsz[i][1];
			
			fb.jz[a][b]=fb.jzb[a][b];
		}
	}
	public void selectFK(int index){//ѡ�з���Ч��
		int num=0;
		for(int i=index;i<index+25;i++){
			int a=zhsz[i][0];
			int b=zhsz[i][1];
			System.out.println(a+","+b);
			sfk[num]=fb.jz[a][b];
			fb.jz[a][b]=12;
			num++;
			
		}
	}
	public void selectKF(int index){//��ѯ����
		int num=0;
		for(int i=index;i<index+25;i++){
			int a=zhsz[i][0];
			int b=zhsz[i][1];
			fb.jz[a][b]=sfk[num];
			num++;
			
		}
	}
	public boolean check(int index){//����Ƿ���÷���
		for(int i=0;i<unuseindex.length;i++){
			if(unuseindex[i]==index){
				return false;
				}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		ztfk a=new ztfk();
//		for(int i=0;i<zhsz.length;i++){
//			for(int j=0;j<2;j++){
//				System.out.print(zhsz[i][j]);
//				if(j==0){
//					System.out.print(",");
//				}
//			}
//			System.out.println("");
//		}
		int a101=0,a102=0,a103=0,a104=0,a105=0,a106=0,a107=0,a108=0;
		for(int i=0;i<100;i++){
			int b=a.rdb();
			System.out.println(b);
			switch(b){
			case 101:
				a101++;
				break;
			case 102:
				a102++;
				break;
			case 103:
				a103++;
				break;
			case 104:
				a104++;
				break;
			case 105:
				a105++;
				break;
			case 106:
				a106++;
				break;
			case 107:
				a107++;
				break;
			case 108:
				a108++;
				break;
				
			}
		}
		System.out.println(a101+","+a102+","+a103+","+a104+","+a105+","+a106+","+a107+","+a108+",");
	}

}
