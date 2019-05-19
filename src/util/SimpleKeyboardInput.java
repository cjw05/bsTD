package util;
import java.awt.event.*;

public class SimpleKeyboardInput implements KeyListener{

	private boolean[] keys;
	public SimpleKeyboardInput(){
		keys=new boolean[256];
	}
	
	public synchronized boolean keyDown(int keyCode){
		return keys[keyCode];
	}
	
	public synchronized void keyPressed(KeyEvent e){
		int keyCode=e.getKeyCode();
		if(keyCode>=0 && keyCode<keys.length){
			keys[keyCode]=true;	
		}
	}
	public void keyTyped(KeyEvent e){
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode=e.getKeyCode();
		if(keyCode>=0 && keyCode<keys.length){
			keys[keyCode]=false;	
		}
	}
}
