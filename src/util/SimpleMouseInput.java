package util;
import java.awt.*;
import java.awt.event.*;


public class SimpleMouseInput implements MouseListener,MouseMotionListener,MouseWheelListener{

	private static final int BUTTON_COUNT=3;
	private Point mousePos;
	private Point currentPos;
	private boolean[] mouse;
	private int[] polled;
	private int notches;
	private int polledNotches;
	public SimpleMouseInput(){
		mousePos=new Point(0,0);
		currentPos=new Point(0,0);
		mouse=new boolean[BUTTON_COUNT];
		polled=new int[BUTTON_COUNT];
		
	}
	
	public synchronized void poll(){
		mousePos=new Point(currentPos);
		polledNotches=notches;
		notches=0;
		for(int i=0;i<mouse.length;i++){
			if(mouse[i]){
				polled[i]++;
			}else{
				polled[i]=0;
			}
		}
	}
	public Point getPosition(){
		return mousePos;
	}
	
	public int getNotches(){
		return polledNotches;
	}
	
	public boolean buttonDown(int button){
		return polled[button-1]>0;
		
	}
	
	public boolean buttonDownOnce(int button){
		return polled[button-1]==1;
	}
	
	public synchronized void mousePressed(MouseEvent e){
		int button=e.getButton()-1;
		if(button>=0 && button<mouse.length){
			 mouse[button]=true;
		}
	}
	
	public void mouseClicked(MouseEvent e){
	}

	@Override
	public synchronized void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		notches+=e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		currentPos=e.getPoint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}

	@Override
	public synchronized void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int button=e.getButton()-1;
		if(button>=0 && button<mouse.length){
			 mouse[button]=false;
		}
	}


	
	
}
