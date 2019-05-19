package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.File; 
import java.io.IOException; 
import jxl.Cell; 
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException;
import map.ztfk; 

public class SynthesisTower {
	public static ArrayList<Integer[]> CraftGuide=new ArrayList<Integer[]>();
	public static ArrayList<Integer> compose=new ArrayList<>();
	public static ArrayList<String> name=new ArrayList<>();
	private int rows;
	private int columns;
	
	public SynthesisTower(){
		setData(getData());
	}
	public String[][] getData() {
		 try { 
		  File f=new File("./tower.xls"); 
		  Workbook book=Workbook.getWorkbook(f);// 		
		  Sheet sheet=book.getSheet(1); //获得第二个工作表对象 
		  String[][] a=new String[sheet.getRows()-2][sheet.getColumns()];
		  for(int i=0;i<sheet.getRows()-2;i++){ 
		   for(int j=0;j<sheet.getColumns();j++){ 
		    Cell cell=sheet.getCell(j, i+2); //获得单元格
		    a[i][j]=cell.getContents() ;
		   } 
		  } 
		  rows=sheet.getRows()-1;
		  book.close();
		  return a;
		 } catch (BiffException e) { 
		  // TODO Auto-generated catch block 
		  e.printStackTrace(); 
		 } catch (IOException e) { 
		  // TODO Auto-generated catch block 
		  e.printStackTrace(); 
		 }
		return null; 
		} 
	
	public int getRows(){
		return rows;
	}
	public void setData(String[][] s){
		for(String[] i:s){
			Integer[] a={Integer.parseInt(i[0]),Integer.parseInt(i[1]),Integer.parseInt(i[2])};
			CraftGuide.add(a);
			compose.add(Integer.parseInt(i[3]));
			name.add(i[4]);
		}
		
	}
	public ArrayList<Integer> check(int Int){
		int count=0;
		ArrayList<Integer> d=new ArrayList<>();
		flag:for(Integer[] i:CraftGuide){
			for(int j=0;j<i.length;j++){
				if(i[j]==Int){
				d.add(count);
				}
			}
			count++;
		}
		return d;
	}
	public String[][] data(ArrayList<Integer> a){
		String[][] s=new String[a.size()][2];
		int count=0;
		for(Integer i:a){
			s[count][0]=compose.get(i)+"";
			s[count][1]=name.get(i);
			count++;
		}
		
		return s;
	}
	public ArrayList<Integer> nowRount(ArrayList<Integer> a,ArrayList<Integer> b){
		//a=有选中方块的合成列表  b=当前5个建筑
		String[][] s=new String[a.size()][2];
		boolean t1=false,t2=false,t3=false;
		
		int count=0;
		ArrayList<Integer> n=new ArrayList<>();//可合成的index
//		for(Integer i:a){
//			s[count][0]=compose.get(i)+"";
//			s[count][1]=name.get(i);
//			count++;
//		}
		
			
			flag:for(Integer l:a){
				int num=0;
				for(Integer i:CraftGuide.get(l)){
					for(Integer j:b){
						if(i==j){
							System.out.println("22222");
							num++;
						}
						if(num==3){
							System.out.println("333");
							n.add(l);
							continue flag;
						}
					}
				}
				System.out.println("-----------");
				num=0;
			}
			
		return n;
		
		
		
	}
	
	public static void main(String[] args) {
		SynthesisTower b=new SynthesisTower();
		Object[] ready={"选择","取消"};
//		String[][] a=b.test(b.check(101));
		ArrayList<Integer> nowBuild=new ArrayList<>();
		nowBuild.add(102);
		nowBuild.add(103);
		nowBuild.add(101);
		nowBuild.add(103);
		nowBuild.add(104);
		nowBuild.add(105);
		nowBuild.add(106);
		
		ArrayList<Integer> al=b.nowRount(b.check(104),nowBuild);
		if(!(al.size()==0)){
			ArrayList<Object> or=new ArrayList<>();
			or.add("选择");
			or.add("取消");
			for(Integer ali:al){
				System.out.println("111");
				or.add(name.get(ali));
			}
			ready=or.toArray();
		}
		
		int r=JOptionPane.showOptionDialog(null,"方块","选择",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ready,ready[0]);
		
	}
	
	
	
	
	
	
	
	
}
