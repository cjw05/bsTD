package AIPo;
import map.*;


public class walk {
	private fb fb=new fb();
	private int canwalk[]={0,1,2,3,51,52,53,54,55,88,77,76};//���ߵĵ�
	public int nowx=20,nowy=25;
	private int jl=4;
	int[][] record=new int[37*37*5*5][2];
	int count=0;
	int countt=0;
	
	
	public void init(){
		fb.test();
	}
	
	private boolean check(int n){//����¸����Ƿ����
		for(int i=0;i<canwalk.length;i++){
		if(canwalk[i]==n){
		return true;
		}
		}
		return false;
	}
	
	public boolean step(int a){//��һ��
		boolean b1=false,b2=false,b3=false,b4=false,b5=false;
		int changex=0,changey=0;
		
		if(nowx==0 && nowy==0){
			if(a==3 || a==1){
//			int c[]={2,4};
//			int r=(int) (Math.random()*2);
//			a=c[r];
//			System.out.println("�Ҵ�����ˣ�-"+a);
				return false;
			}
		}else if(nowx==fb.jz.length-1 && nowy==fb.jz.length-1){
			if(a==2 || a==4){
//				int c[]={1,3};
//				int r=(int) (Math.random()*2);
//				a=c[r];
//				System.out.println("�Ҵ�����ˣ�-"+a);
				return false;
				}
		}else if(nowx==0){
			if(a==3){
//				int c[]={1,2,4};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("�ұ����ˣ�-"+a);
				return false;
			}
		}else if(nowy==0){
			if(a==1){
//				int c[]={3,2,4};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("�ұ����ˣ�-"+a);
				return false;
			}
		}else if(nowx==fb.jz.length-1){
			if(a==4){
//				int c[]={3,2,1};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("�ұ����ˣ�-"+a);
				return false;
			}
		}else if(nowy==fb.jz.length-1){
			if(a==2){
//				int c[]={3,1,4};
//				int r=(int) (Math.random()*3);
//				a=c[r];
//				System.out.println("�ұ����ˣ�-"+a);
				return false;
			}
			
		}
		switch (a) {
		case 1:	//������
			changex=nowx;
			changey=nowy-1;
			b1=check(fb.jz[nowx][nowy-1]);
			b2=check(fb.jz[nowx+jl][nowy-1+jl]);
			b3=check(fb.jz[nowx+jl][nowy-1]);
			b4=check(fb.jz[nowx][nowy-1+jl]);
			break;
		case 2:	//������
			changex=nowx;
			changey=nowy+1;
			b1=check(fb.jz[nowx][nowy+1]);
			b2=check(fb.jz[nowx+jl][nowy+1+jl]);
			b3=check(fb.jz[nowx+jl][nowy+1]);
			b4=check(fb.jz[nowx][nowy+1+jl]);
			break;
		case 3:	//������
			changex=nowx-1;
			changey=nowy;
			b1=check(fb.jz[nowx-1][nowy]);
			b2=check(fb.jz[nowx-1+jl][nowy+jl]);
			b3=check(fb.jz[nowx-1+jl][nowy]);
			b4=check(fb.jz[nowx-1][nowy+jl]);
			break;
		case 4:	//������
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
	
		System.out.println("�ƶ�ǰ���꣺��"+nowx+","+nowy+"��");
		System.out.println("�ƶ�����ӣ�"+fb.jz[nowx][nowy]);
		System.out.println("�ƶ������꣺��"+changex+","+changey+"��");
		System.out.println("�ƶ�����ӣ�"+fb.jz[changex][changey]);
		nowx=changex;
		nowy=changey;
		
		return true;
		}else{
			System.out.println("�ƶ�ʧ��---"+fb.jz[changex][changey]);
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
	
	
	public boolean checkRoad(){//����Թ��Ƿ񱻶�ס
		int noup[]={2,3,4};//���������ƶ�
		int nodown[]={1,3,4};//���������ƶ�
		int noleft[]={1,2,4};//���������ƶ�
		int noright[]={1,2,3};//���������ƶ�
		int[][] record=new int[37*37*5*5][2];
		
		boolean t1=false,t2=false,t3=false;
		int[][] direction={{1,3,4},{2,3,4},{1,2,3},{1,2,4}};//{�����ϲ������ƶ�}...{�����������ƶ�}...
		int[][] dct;
		
		int checkpx,checkpy;//����x��y��
		
		start:for(int i=1;i<=4;i++){//���
			t1=step(i);//��һ���Ƿ������
			int c=i;
			Record(t1);
			StartFirst:while(t1){//��㵽1�ŵ㣺
				for(int j=0;j<3;j++){
					step(direction[c][j]);
					if(step(direction[c][j]) && nowx==20 && nowy==90){//�ɹ������1
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
