package data;
import java.io.File; 
import java.io.IOException; 
import jxl.Cell; 
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException; 



public class getTowerData {
	private int rows;
	private int columns;

	//1,3,4,5,6列转化成int
	
	
	
	public String[][] getData() {
		
		 try { 
		  File f=new File("./tower.xls"); 
		  Workbook book=Workbook.getWorkbook(f);// 		
		  Sheet sheet=book.getSheet(0); //获得第一个工作表对象 
		  String[][] a=new String[sheet.getRows()-1][sheet.getColumns()];
		  for(int i=0;i<sheet.getRows()-1;i++){ 
		   for(int j=0;j<sheet.getColumns();j++){ 
		    Cell cell=sheet.getCell(j, i+1); //获得单元格
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
	public static void main(String[] args) {
		getTowerData b=new getTowerData();
		String[][] a=b.getData();
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
		int c=Integer.parseInt(a[0][0]);
		System.out.println("------------"+c);
	}
}
