package jssh;

public class attack {
	private int basicAtt,addAtt,finalAtt;//»ù´¡¹¥»÷£¬ÔöÉË¹¥»÷£¬×îÖÕ¹¥»÷
	
	public void setbasicAtt(int basicAtt){
		this.basicAtt=basicAtt;
		buff();
	}
	private void buff(){
		finalAtt=basicAtt+0;
	}
	public int getfinalAtt(){
		return finalAtt;
	}

}
