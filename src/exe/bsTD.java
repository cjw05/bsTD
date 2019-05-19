package exe;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

import test.ctext;

public class bsTD {

	public static void main(String[] args) {
		final ctext app=new ctext();
		
		app.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				app.shutdown();
			}
		});
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				app.createAndShowGUI();
			}
		});
	}

}
