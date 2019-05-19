package jssh;
import data.*;
public class Tower {
	private getTowerData getTower=new getTowerData();
	private static int[] Ordinal;
	private static String[] Name;
	private static int[] DMG;
	private static int[] AttackSpeed;
	private static int[] Range;
	private static int[] Trajectory;
	private static String[] Skill;
	
	
	
	public String[] getMSG(int index){
		String[] msg =new String[5];
		int c=0;
		for(int i=0;i<Ordinal.length;i++){
			if(Ordinal[i]==index){
				c=i;
			}
		}
		msg[0]=getName(c);
		msg[1]=getDMG(c)+"";
		msg[2]=getAttackSpeed(c)+"";
		msg[3]=getRange(c)+"";
		msg[4]=getTrajectory(c)+"";
		return msg;
		
	}
	public String[] getMSGa(int index){
		String[] msg =new String[5];
		int c=0;
		for(int i=0;i<Ordinal.length;i++){
			if(Ordinal[i]==index){
				c=i;
			}
		}
		msg[0]=getName(c);
		msg[1]=getDMG(c)+"";
		msg[2]=getAttackSpeed(c)+"";
		msg[3]=getRange(c)+"";
		msg[4]=getTrajectory(c)+"";
		return msg;
		
	}
	
	private int getDMG(int index){
		return DMG[index];
	}
	private int getAttackSpeed(int index){
		return AttackSpeed[index];
	}
	private String getName(int index){
		return Name[index];
	}
	private String Skill(int index){
		return Skill[index];
	}
	public int getRange(int index){
		return Range[index];
	}
	public int getTrajectory(int index) {
		return Trajectory[index];
	}
	public int getOrder(int index){
		return Ordinal[index];
	}
	public Tower(){
		String[][] a=getTower.getData();
		int rows=a.length;
		Ordinal=new int[rows];
		Name=new String[rows];
		DMG=new int[rows];
		AttackSpeed=new int[rows];
		Range=new int[rows];
		Trajectory=new int[rows];
		Skill=new String[rows];
		
		for(int i=0;i<a.length;i++){
			Ordinal[i]=Integer.parseInt(a[i][0]);
			Name[i]=a[i][1];
			DMG[i]=Integer.parseInt(a[i][2]);
			AttackSpeed[i]=Integer.parseInt(a[i][3]);
			Range[i]=Integer.parseInt(a[i][4]);
			Trajectory[i]=Integer.parseInt(a[i][5]);
		}
		
		
		
		
	}
	
	

}
