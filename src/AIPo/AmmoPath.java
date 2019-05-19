package AIPo;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import map.*;

public class AmmoPath {
	
	private ztfk zt;
	int bs;
	
	
//	private void init(){
//		f.test();
//		for(int j=0;j<f.jz.length;j++){
//			for(int i=0;i<f.jz[0].length;i++){
//				System.out.print(f.jz[j][i]);
//			}
//			System.out.println("");
//		}
//	}
	private void init1(){
		zt.compose();
	}
	int bx = 0,by=0,sx=0,sy=0;
	int num=0;
	
    public int[][] js1(int x,int y,int xx,int yy){
    	int[][] sz=new int[200][200];
    	num=0;
    	
    	if(xx>=x){
    		if(yy>=y){
    			int ax=xx-x;
    			int ay=yy-y;
    			bx=xx;
    			by=yy;
    			sx=x;
    			sy=y;
    			bs=1;//判定起点比终点x,y都小---x,y+
    			while(true){
    				boolean t1=true,t2=true;
    				if(ax>=2){
    					if(ax%2==0){
    						ax=ax/2;
    					}else{
    						ax=ax/2+1;
    					}
    					t1=false;
    				}
    				if(ay>=2){
    					if(ay%2==0){
    						ay=ay/2;
    					}else{
    						ay=ay/2+1;
    					}
    					t2=false;
    				}
    				sz[num][0]=ax;
    				sz[num][1]=ay;
    				num++;
    				if(t1 && t2){
    					break;
    				}
    				
    				
    			}
    			
    		}else if(y>=yy){
    			int ax=xx-x;
    			int ay=y-yy;
    			bx=xx;
    			by=y;
    			sx=x;
    			sy=yy;
    			bs=2;//判定起点比终点x小---x+;
    			while(true){
    				boolean t1=true,t2=true;
    				if(ax>=2){
    					if(ax%2==0){
    						ax=ax/2;
    					}else{
    						ax=ax/2+1;
    					}
    					t1=false;
    				}
    				if(ay>=2){
    					if(ay%2==0){
    						ay=ay/2;
    					}else{
    						ay=ay/2+1;
    					}
    					t2=false;
    				}
    				sz[num][0]=ax;
    				sz[num][1]=ay;
    				num++;
    				if(t1 && t2){
    					break;
    				}
    				
    			}
    		
    	}
    	}else if(x>=xx){
    		if(yy>=y){
    			int ax=x-xx;
    			int ay=yy-y;
    			bx=x;
    			by=yy;
    			sx=xx;
    			sy=y;
    			bs=3;//判定起点比终点y小---y+;
    			while(true){
    				boolean t1=true,t2=true;
    				if(ax>=2){
    					if(ax%2==0){
    						ax=ax/2;
    					}else{
    						ax=ax/2+1;
    					}
    					t1=false;
    				}
    				if(ay>=2){
    					if(ay%2==0){
    						ay=ay/2;
    					}else{
    						ay=ay/2+1;
    					}
    					t2=false;
    				}
    				if(t1 && t2){
    					break;
    				}
    				sz[num][0]=ax;
    				sz[num][1]=ay;
    				num++;
    			}
    		}else if(y>=yy){
    			int ax=x-xx;
    			int ay=y-yy;
    			bx=x;
    			by=y;
    			sx=xx;
    			sy=yy;
    			bs=4;//判定起点比终点都大;
    			while(true){
    				boolean t1=true,t2=true;
    				if(ax>=2){
    					if(ax%2==0){
    						ax=ax/2;
    					}else{
    						ax=ax/2+1;
    					}
    					t1=false;
    				}
    				if(ay>=2){
    					if(ay%2==0){
    						ay=ay/2;
    					}else{
    						ay=ay/2+1;
    					}
    					t2=false;
    				}
    				if(t1 && t2){
    					break;
    				}
    				sz[num][0]=ax;
    				sz[num][1]=ay;
    				num++;
    			}
    		}
    		
    	}
    	int count=1;
    	int[][] xy=new int[num*2+1][2];
    	if(bs==1 || bs==4){
    	xy[0][0]=bx;
    	xy[0][1]=by;
    	for(int i=1;i<num;i++){
    		
    		int xxx=sx+sz[0][0];
    		int yyy=sy+sz[0][1];
    		xxx=xxx+sz[i][0];
    		yyy=yyy+sz[i][1];
    		xy[count][0]=xxx;
    		xy[count][1]=yyy;
    		count++;
    		
    	}
    	
    	for(int i=0;i<=num;i++){
    		int xxx=sx+sz[i][0];
    		int yyy=sy+sz[i][1];
    		xy[count][0]=xxx;
    		xy[count][1]=yyy;
    		count++;
    		
    	}
    	}
    	if(bs==2 || bs==3){
    		xy[0][0]=x;
    		xy[0][1]=y;
    		if(bs==2){
    			System.out.println("调用了2");
    			for(int i=num-1;i>=0;i--){
    	    		int xxx=x+sz[i][0];
    	    		int yyy=y-sz[i][1];
    	    		xy[count][0]=xxx;
    	    		xy[count][1]=yyy;
    	    		count++;
    	    		
    	    	}
    			for(int i=num-1;i>=0;i--){
    	    		int xxx=x+sz[0][0];
    	    		int yyy=y-sz[0][1];
    	    		xxx=xxx+sz[i][0];
    	    		yyy=yyy-sz[i][1];
    	    		xy[count][0]=xxx;
    	    		xy[count][1]=yyy;
    	    		count++;
    	    		
    	    	}
    		}else if(bs==3){
    			System.out.println("调用了3");
    			for(int i=num-1;i>=0;i--){
    	    		int xxx=x-sz[i][0];
    	    		int yyy=y+sz[i][1];
    	    		xy[count][0]=xxx;
    	    		xy[count][1]=yyy;
    	    		count++;
    	    		
    	    	}
    			for(int i=num-1;i>=0;i--){
    	    		int xxx=x-sz[0][0];
    	    		int yyy=y+sz[0][1];
    	    		xxx=xxx-sz[i][0];
    	    		yyy=yyy+sz[i][1];
    	    		xy[count][0]=xxx;
    	    		xy[count][1]=yyy;
    	    		count++;
    	    		
    	    	}
    		}
    		
    	}
    	
    	
    	return xy;
    	
    	
    }
    
    
    
    
    ArrayList<Integer> b=new ArrayList<Integer>();
	ArrayList<Integer> bb=new ArrayList<Integer>();
    public void walk(int[][] sz){
    	b.clear();
    	bb.clear();
    	
    	ArrayList<Integer> szx=new ArrayList<Integer>();
    	ArrayList<Integer> szy=new ArrayList<Integer>();
    	int cc=0;
    	int jj;
    	if(bs==1 || bs==4){
    	for(int i=0;i<sz.length-1;i++){
    		szx.clear();
        	szy.clear();
    		jj=1;
    		for(int j=sz[i+1][0];j<sz[i][0];j++){
    			szx.add(sz[i][0]-jj);
    			jj++;
    		}
    		jj=1;
    		for(int t=sz[i+1][1];t<=sz[i][1];t++){
    			szy.add(sz[i][1]-jj);
    			jj++;
    			
    		}
    		if(szx.size()==0){
    			szx.add(sz[i][0]);
    		}
    		if(szy.size()==0){
    			szy.add(sz[i][1]);
    		}
    		if(b.size()==0){
    			b.add(sz[0][0]);
    			
    		}
    		if(bb.size()==0){
    			bb.add(sz[0][1]);
    			
    		}
    		
    		if(szx.size()>szy.size()){
    			int c=szx.size()-szy.size();
    			for(int q=0;q<szy.size();q++){
    				b.add(szx.get(q));
    				bb.add(szy.get(q));
    				cc++;
    			}
    			for(int qq=szy.size();qq<szy.size()+c;qq++){
    				
    				b.add(szx.get(qq));
    				bb.add(szy.get(szy.size()-1));
    				cc++;
    			}
    		}else{
    			int c=szy.size()-szx.size();
    			for(int q=0;q<szx.size();q++){
    				b.add(szx.get(q));
    				bb.add(szy.get(q));
    				
    				cc++;
    			}
    			
    			for(int qq=szx.size();qq<szx.size()+c;qq++){
    				b.add(szx.get(szx.size()-1));
    				bb.add(szy.get(qq));
    				cc++;
    				
    			}
    		}
    		
    	}
    	}
    	
    	
    	
    	
    	
    	
    	
    	if(bs==2 || bs==3){
        	for(int i=0;i<sz.length-1;i++){
        		szx.clear();
            	szy.clear();
        		jj=1;
        		if(bs==3){
        		for(int j=sz[i][0];j>sz[i+1][0];j--){
        			szx.add(sz[i][0]-jj);
        			jj++;
        		}
        		}else if(bs==2){
        			for(int j=sz[i][0];j<sz[i+1][0];j++){
            			szx.add(sz[i][0]+jj);
            			jj++;
            		}
        		}
        		jj=1;
        		if(bs==2){
            		for(int j=sz[i][1];j>sz[i+1][1];j--){
            			szy.add(sz[i][1]-jj);
            			jj++;
            		}
            		}else if(bs==3){
            			for(int j=sz[i][1];j<sz[i+1][1];j++){
                			szy.add(sz[i][1]+jj);
                			jj++;
                		}
            		}
        		if(szx.size()==0){
        			szx.add(sz[i][0]);
        		}
        		if(szy.size()==0){
        			szy.add(sz[i][1]);
        		}
        		if(b.size()==0){
        			b.add(sz[0][0]);
        			
        		}
        		if(bb.size()==0){
        			bb.add(sz[0][1]);
        			
        		}
        		
        		if(szx.size()>szy.size()){
        			int c=szx.size()-szy.size();
        			for(int q=0;q<szy.size();q++){
        				b.add(szx.get(q));
        				bb.add(szy.get(q));
        				cc++;
        			}
        			for(int qq=szy.size();qq<szy.size()+c;qq++){
        				
        				b.add(szx.get(qq));
        				bb.add(szy.get(szy.size()-1));
        				cc++;
        			}
        		}else{
        			int c=szy.size()-szx.size();
        			for(int q=0;q<szx.size();q++){
        				b.add(szx.get(q));
        				bb.add(szy.get(q));
        				
        				cc++;
        			}
        			
        			for(int qq=szx.size();qq<szx.size()+c;qq++){
        				b.add(szx.get(szx.size()-1));
        				bb.add(szy.get(qq));
        				cc++;
        				
        			}
        		}
        		
        	}
        	}
    	
    	
    }
    public boolean getbs(){
    	if(bs==1){
    		return false;
    	}
    	return true;
    }
    public ArrayList<Integer> getx(){
    	return b;
    }
    public ArrayList<Integer> gety(){
    	return bb;
    }
	
	public static void main(String[] args) {

	}
}
