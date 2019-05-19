package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ml {//中线
	
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
			//img1=ImageIO.read(new File("./素材/测试格子.jpg"));
			img1=ImageIO.read(new File("./素材/5px中线.jpg"));
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
