import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Listener extends KeyAdapter{
	public int[] keysDown = new int[222];
	
	public Listener(){
		for(int i = 0; i < 222; i ++){
			keysDown[i] = 0;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		keysDown[key] = 1;
	}
	@Override
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		keysDown[key] = 0;
	}
}
