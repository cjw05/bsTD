package jssh;

public class use {
	private armor am=new armor();
	private attack at=new attack();
	private HP hp=new HP();
	
	
	
	public void target(double a){//��������λ����
		am.setAm(a);
		
	}
	
	public void me(int a){//������λ
		
		at.setbasicAtt(a);
	}
	
	
	
	public double battle(int amror,int attack,double nowHP,int mr){//�����˺���Ȼ��۳�HP
		am.setAm(amror);
		at.setbasicAtt(attack);
		hp.setHP(nowHP);
		double DMG=at.getfinalAtt()*(1-am.getHj());
		return hp.changeHP(DMG);
	}
	public static void main(String[] args) {
		use u=new use();
		double a=u.battle(20, 100, 200, 1);
		System.out.println(a);
	}
	
}
