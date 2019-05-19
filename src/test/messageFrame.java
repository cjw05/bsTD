package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import AIPo.Enemy;
import data.getEnemyData;
import data.getTowerData;
import map.*;
import jssh.*;

public class messageFrame extends JFrame{

	private ztfk ztfk=new ztfk();
	private fb fb=new fb();
	private getTowerData gtd=new getTowerData();
	
	private Enemy enemy=new Enemy();
	private ArrayList<Integer> towerindex=new ArrayList<>();
	private Tower Tower=new Tower();
	private String castleHP="100";
	private String Loop="1";
	
	
	private String enemyName="����";
	private String Health="0";//����ֵ
	private String Armor="0";//����
	private String Speed="0";//�ƶ��ٶ�
	private String Mr="0";//ħ��
	private String ArmorP="0%";
	private String MrP="0%";
	private String ESkill="null";
	private JLabel enemyname=new JLabel(enemyName);
	private JLabel health=new JLabel("����ֵ��"+Health);
	private JLabel speed=new JLabel("�ƶ��ٶȣ�"+Speed);
	private JLabel armor=new JLabel("����ֵ��"+Armor);
	private JLabel armorp=new JLabel("������⣺"+ArmorP);
	private JLabel mr=new JLabel("ħ�����ԣ�"+Mr);
	private JLabel mrp=new JLabel("ħ�����⣺"+MrP);
	private JLabel eskill=new JLabel(ESkill);
	
	
	
	
	
	
	private String TownName="��";
	private String DMG="0";//������
	private String AttackSpeed="0";//�����ٶ�
	private String Ballistic="0";//����
	private String Skill=null;//����
	private String Range="0";//������Χ
	private JLabel castlehp=new JLabel("�Ǳ�����ֵ��"+castleHP);
	private JLabel ready=new JLabel("������׼���׶�");
	private JLabel loop=new JLabel("�����ǵ�"+Loop+"��");
	private JLabel lb=new JLabel(TownName);
	private JLabel dmg=new JLabel("��������"+DMG);
	private JLabel attackspeed=new JLabel("�����ٶȣ�"+AttackSpeed);
	private JLabel range=new JLabel("������Χ��"+Range);
	private JLabel skill=new JLabel("���ܣ�"+Skill);
	
	
	public messageFrame(){
		String[][] s=gtd.getData();
		ArrayList<Integer> ss=new ArrayList<>(); 
		for(String[] i:s){
			ss.add(Integer.parseInt(i[0]));
		}
		towerindex=ss;
		this.setTitle("��Ϣ");
		this.setResizable(false);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setBounds(950,200,500,500);
		this.setBackground(Color.black);
		init();
		

	}
	public void init(){
		ready.setForeground(Color.red);
		this.getContentPane().add(castlehp);
		this.getContentPane().add(loop);
		this.getContentPane().add(enemyname);
		this.getContentPane().add(health);
		this.getContentPane().add(speed);
		this.getContentPane().add(armor);
		this.getContentPane().add(mr);
		this.getContentPane().add(eskill);
		this.getContentPane().add(lb);
		this.getContentPane().add(dmg);
		this.getContentPane().add(attackspeed);
		this.getContentPane().add(range);
		this.getContentPane().add(skill);
		this.getContentPane().add(armorp);
		this.getContentPane().add(mrp);
		this.getContentPane().add(ready);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
		});
		
		
	
		
		
	}
	
	
	public void setcastle(String hp){//�Ǳ�Ѫ��
		castleHP=hp;
	}
	public boolean check(int index){
			if(towerindex.contains(ztfk.getInt(index))){
				setTownMg(index);
				return true;
			}
		return false;
	}
	public void setTownMg(int index){//ѡ��������Ϣ
		int[] a=ztfk.getzhsz(index);
		int n=fb.getjz(a[0], a[1]);
		String[] MSG=Tower.getMSG(n);
		this.TownName=MSG[0];
		this.DMG=MSG[1];
		this.AttackSpeed=MSG[2];
		this.Range=MSG[3];
		changeL();
	}
	public void setEnemy(int lp){
		String[] MSG=enemy.getMSG(lp);
		this.Loop=MSG[0]+"";
		this.enemyName=MSG[1];
		this.Health=MSG[2];
		this.Speed=MSG[3];
		this.Armor=MSG[4];
		this.Mr=MSG[5];
		changeL();
	}
	
	private void changeL(){
		
		castlehp.setText("�Ǳ�����ֵ��"+castleHP);
		loop.setText("�����ǵ�"+Loop+"��");
		health.setText("����ֵ��"+Health);	
		speed.setText("�ƶ��ٶȣ�"+Speed);
		armor.setText("����ֵ��"+Armor);
		armorp.setText("������⣺"+ArmorP);
		mr.setText("ħ�����ԣ�"+Mr);
		mrp.setText("ħ�����⣺"+MrP);

		
		
		
		
		
		lb.setText(TownName);
		dmg.setText("��������"+DMG);
		attackspeed.setText("�����ٶȣ�"+AttackSpeed);
		range.setText("�������룺"+Range);
		skill.setText(Skill);
		
		
		
	}
	public void tz(){//����labelλ��
		castlehp.setBounds(10, 10, 100, 20);
		ready.setBounds(150,10,100,20);
		loop.setBounds(310,10,100,20);
		
		
		
		enemyname.setBounds(10,35,200,20);
		health.setBounds(10,60,120,20);
		armor.setBounds(160,60,120,20);
		armorp.setBounds(310,60,120,20);
		speed.setBounds(10,90,120,20);
		mr.setBounds(160,90,120,20);
		mrp.setBounds(310,90,120,20);
		eskill.setBounds(10,120,120,20);
		
		
		
		
		
		
		
		lb.setBounds(10,220,120,20);
		dmg.setBounds(10,250,120,20);
		attackspeed.setBounds(160,250,120,20);
		range.setBounds(310,250,120,20);
		skill.setBounds(10,280,120,20);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
