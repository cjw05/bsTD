package jssh;

public class armor {
	private double basicAm,buffAm,hj;//�������ף��ı��Ļ��ף����ռ���
	
	public void setAm(double am){
		this.basicAm=am;//��ȡ��������
		buff();//�������ջ���
	}

	public double getHj(){
		hj=(0.052*buffAm)/(0.9+(0.048*buffAm));
		return hj;
	}
	private void buff(){
		buffAm=basicAm;
	}
}
