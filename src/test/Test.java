package test;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import jssh.*;

public class Test {

	public static void main(String[] args) {
		ArrayList<Object> or=new ArrayList<>();
		or.add("选择");
		or.add("取消");
		or.add("取消");
		Object[] ready=or.toArray();
		int r=JOptionPane.showOptionDialog(null,"方块","选择",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ready,ready[0]);
	}
}
