package map;

public class coordinate {//�����ȡ
	private int cdx,cdz,pi;//ͼ���Ӧ���꣨Ҳ�Ƕ�ά�����Ӧ[z][x]��;pi��Ӧ��ͼ��index
	
	
	public void setCD(int cdx,int cdz,int pi){//��������
		this.cdx=cdx;
		this.cdz=cdz;
		this.pi=pi;
	}
	
	public int getCDX(){//����x
		return cdx;
	}
	public int getCDZ(){//����y
		return cdz;
	}
	

}
