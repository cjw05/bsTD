package AIPo;
import data.*;
import map.*;

public class FindEnemy {
	
	private getTowerData getTowerData=new getTowerData();
	private fb fb=new fb();
	private int towerCode[];
	private int count=0;
	private int[][] datatower;
	private int num=0;
	
	private void init(){
		String[][] a=getTowerData.getData();
		towerCode=new int[getTowerData.getRows()];
		for(int i=0;i<a.length;i++){
			towerCode[i]=Integer.parseInt(a[i][0]);
		}
		
		
	}
	
	public FindEnemy(){
		init();
	}
	
	public void createRangeCount(){
		count=0;
		for(int i=0;i<fb.getRows();i++){
			for(int j=0;j<fb.getColums();j++){
				flag:for(int q=0;q<towerCode.length;q++){
					if(towerCode[q]==fb.getjz(i, j)){
						count++;
						break flag;
					}
				}
				
			}
		}
	}
	public void createRange() {
		datatower=new int[count][3];
		num=0;
		for(int i=0;i<fb.getRows();i++){
			for(int j=0;j<fb.getColums();j++){
				flag:for(int q=0;q<towerCode.length;q++){
					if(towerCode[q]==fb.getjz(i, j)){
						int code=fb.getjz(i, j);
						send(code,i,j);
						num++;
						break flag;
					}
				}
				
			}
		}
	}
	public int[][] getdata(){
		return datatower;
	}
	
	public void send(int code,int x,int y){
		datatower[num][0]=code;
		datatower[num][1]=x;
		datatower[num][2]=y;
	}
	public int getCount() {
		return count;
	}
	
	
	
	

}
