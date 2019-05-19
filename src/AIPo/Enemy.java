package AIPo;
import data.*;
public class Enemy {
	private getEnemyData getEnemy=new getEnemyData();
	private static int[] loop;
	private static String[] Name;
	private static int[] health;
	private static int[] Speed;
	private static int[] amror;
	private static int[] mr;
	private static String[] Skill;
	private static double[] nowHP;
	private int count;
	
	
	public double[] NowHP() {
		return nowHP;
	}
	public void clearHP() {
		nowHP=null;
	}
	
	public void newLoop(int loop,int count) {
		double hp=getHP(loop-1);
		this.count=count;
		nowHP=new double[count];
		for(int i=0;i<count;i++) {
			nowHP[i]=hp;
		}
	}
	public int getCount(){
		return count;
	}
	
	
	
	
	public String[] getMSG(int index){
		newLoop(index, 10);
		String[] msg =new String[20];
		int c=0;
		for(int i=0;i<loop.length;i++){
			if(loop[i]==index)
			{
				
				c=i;
			}
		}
		System.out.println("µÚ"+c+"²¨");
		msg[0]=getloop(c)+"";
		msg[1]=getName(c);
		msg[2]=getHP(c)+"";
		msg[3]=getSpeed(c)+"";
		msg[4]=getAmror(c)+"";
		msg[5]=getMr(c)+"";
		return msg;
		
	}
	private int getloop(int index){
		return loop[index];
	}
	
	public int getHP(int index){
		return health[index];
	}
	private int getSpeed(int index){
		return Speed[index];
	}
	private String getName(int index){
		return Name[index];
	}
	private String Skill(int index){
		return Skill[index];
	}
	public int getAmror(int index){
		return amror[index];
	}
	public int getMr(int index){
		return mr[index];
	}
	public Enemy(){
		String[][] a=getEnemy.getData();
		int rows=a.length;
		loop=new int[rows];
		Name=new String[rows];
		health=new int[rows];
		Speed=new int[rows];
		amror=new int[rows];
		mr=new int[rows];
		Skill=new String[rows];
		for(int i=0;i<a.length;i++){
			loop[i]=Integer.parseInt(a[i][0]);
			Name[i]=a[i][1];
			health[i]=Integer.parseInt(a[i][2]);
			Speed[i]=Integer.parseInt(a[i][3]);
			amror[i]=Integer.parseInt(a[i][4]);
			mr[i]=Integer.parseInt(a[i][5]);
		}
		newLoop(1, 10);
		
		
		
		
	}
	
	

}
