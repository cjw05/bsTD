package map;

public class coordinate {//坐标获取
	private int cdx,cdz,pi;//图像对应坐标（也是二维数组对应[z][x]）;pi对应的图像index
	
	
	public void setCD(int cdx,int cdz,int pi){//保存坐标
		this.cdx=cdx;
		this.cdz=cdz;
		this.pi=pi;
	}
	
	public int getCDX(){//坐标x
		return cdx;
	}
	public int getCDZ(){//坐标y
		return cdz;
	}
	

}
