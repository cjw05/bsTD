package jssh;

public class armor {
	private double basicAm,buffAm,hj;//基础护甲，改变后的护甲，最终减伤
	
	public void setAm(double am){
		this.basicAm=am;//获取基础护甲
		buff();//计算最终护甲
	}

	public double getHj(){
		hj=(0.052*buffAm)/(0.9+(0.048*buffAm));
		return hj;
	}
	private void buff(){
		buffAm=basicAm;
	}
}
