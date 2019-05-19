package AIPo;
import jssh.*;
import test.ctext;
import test.ctext.AThread;

public class TowerRangeAttack {
	
	private String Name;
	private int DMG;
	private int AttackSpeed;
	private int Range;
	private int Trajectory;
	private int centerCircleX,centerCircleY;
	private boolean lock=false;
	private int lockorder=0;
	
	
	
	public TowerRangeAttack(String[] msg,int x,int y) {
		Name=msg[0];
		DMG=Integer.parseInt(msg[1]);
		AttackSpeed=Integer.parseInt(msg[2]);
		Range=Integer.parseInt(msg[3]);
		Trajectory=Integer.parseInt(msg[4]);
		centerCircleX=x*5+13;
		centerCircleY=y*5+13;
	}
	public boolean Range(int a,int b) {
		double c=Math.sqrt(((centerCircleX-a)*(centerCircleX-a))+((centerCircleY-b)*(centerCircleY-b)));
		if(c<=Range/2){
			return true;
		}else
		{
			return false;
		}
	}
	public String getName(){
		return Name;
	}
	public double attack(int order,int amror,double nowHP,int mr) {
		if(!lock) {
			use use=new use();
			lock=true;
			lockorder=order;
			
			return use.battle(amror, DMG, nowHP,mr);
			
		}else if(lock && lockt(order)) {
			use use=new use();
			return use.battle(amror, DMG, nowHP,mr);
		}
		return nowHP;
	}
	public boolean getLock(int order){
		if(!lock) {
			return true;
		}else if(lock && lockt(order)) {
		
			return true;
		}
		return false;
	}
	public boolean lockt(int order){
		if(this.lockorder==order){
			return true;
		}
		return false;
	}
	public int getX(){
		return centerCircleX;
	}
	public int getY(){
		return centerCircleY;
	}
	
	public int getLockorder() {
		return lockorder;
	}
	public int getAS(){

		return AttackSpeed;
	}
	
	
	public void checkLock() {
		if(lock){
		lock=false;
		lockorder=0;
		
		}
	}
	
	public double getChangeHP(double HP) {
		return HP;
	}
	public int[] getS() {
		// TODO Auto-generated method stub
		int a[]={centerCircleX,centerCircleY};
		return a ;
	}
	
	
	

}
