package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ml {//����
	
	public BufferedImage img1=null;
	public JLabel[] jm1=new JLabel[1850];
	public int jms=0;
	public int zbx=425;
	public int zby=0;
	public int xbx=0;
	public int xby=425;
	public static int bl=5;
	
	
	public void im(){
		try{
			//img1=ImageIO.read(new File("./�ز�/���Ը���.jpg"));
			img1=ImageIO.read(new File("./�ز�/5px����.jpg"));
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void xr(){
		im();
		
		
		for(int j=0;j<185;j++){
			for(int i=0;i<5;i++){
				jm1[jms]=new JLabel(new ImageIcon(img1));
				jm1[jms].setBounds(zbx,zby,bl,bl);
				jms++;
				zbx=zbx+bl;
			}
			zby=zby+bl;
			zbx=425;
		}
		
		System.out.println(jms);
		
		
		
		
		
		
		
	}

}
