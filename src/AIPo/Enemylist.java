package AIPo;

import java.awt.Graphics;
import map.*;

public class Enemylist {
	
	private fb fb=new fb();
	private walk Aiwalk=new walk();
	private int order;//ÐòÁÐ
	private int health;
	private int speed;
	private int amror;
	private int mr;//Ä§¿¹
	private int[] buff;
	private volatile double nowHP;
	private int nowX,nowY;
	private int loop;
	private boolean death=false;
	
	public Enemylist(String[] msg,int order) {
		this.order=order;
		loop=Integer.parseInt(msg[0]);
		health=Integer.parseInt(msg[2]);
		speed=Integer.parseInt(msg[3]);
		amror=Integer.parseInt(msg[4]);
		mr=Integer.parseInt(msg[5]);
		nowX=20;
		nowY=25;
		nowHP=health;
	}
	
	public double NowHP() {
		return nowHP;
	}
	public int Amror() {
		return amror;
	}
	public int Mr() {
		return mr;
	}
	public int getOrder(){
		return order;
	}
	
	public void changeHP(double HP) {
		this.nowHP=HP;
		if(HP<=0){
			nowX=0;
			nowY=0;
			death=true;
		}
		
		
	}
	public boolean death(){
		return death;
	}
	public void move(int x,int y){
		nowX=x;
		nowY=y;
	}
	public int getX(){
		return nowX;
	}
	public int getY(){
		return nowY;
	}
	
	public boolean check(int order) {
		if(this.order==order) {
			return true;
		}
		return false;
	}
	public int getHealth(){
		return health;
	}
	public double getHP(){
		return nowHP;
	}
	
	
	

}
