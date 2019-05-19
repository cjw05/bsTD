package jssh;

public class HP {
	private double hp;
	private boolean t=true;
	public void setHP(double hp){
		if(t){
		this.hp=hp;
		t=false;
		}
	}
	public double changeHP(double DMG){
		hp=hp-DMG;
		return hp;
	}

	public double getHP(){
		return hp;
	}
}
