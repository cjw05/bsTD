package test;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import jssh.*;

public class Test {

	public static void main(String[] args) {
		ArrayList<Object> or=new ArrayList<>();
		or.add("ѡ��");
		or.add("ȡ��");
		or.add("ȡ��");
		Object[] ready=or.toArray();
		int r=JOptionPane.showOptionDialog(null,"����","ѡ��",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ready,ready[0]);
	}
}
