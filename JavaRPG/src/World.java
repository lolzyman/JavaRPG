import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class World extends JPanel implements ActionListener, KeyListener
{
    Timer t = new Timer(5, this);  //Call Action Listener every 5 seconds
    
    int[][] keysDown = new int[200][10];
    int lastKey;
    
    BackgroundImage back = new BackgroundImage();
    Character me = new Character(218,218);
    //Constructor
    public World()
    {
        t.start();                              //Start Timer
        addKeyListener(this);                   //Add key listener to JPanal
        setFocusable(true);                     //Sets focus to this (to use keyListener)
        setFocusTraversalKeysEnabled(false);
        
    }
    
    
    /*public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(x,y,40,40));
    }*/
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	setBackground(Color.RED);
        g.drawImage(back.getImage(), back.getX(), back.getY(), null);
        g.drawImage(me.getImage(),me.getX(),me.getY(),null);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        back.updatePosition();
    }
    
    public void updateMovement(int keyCode){
    	switch(keyCode){
    	//left key
    	case 37:
    		if(back.isMoving()){
    			back.setXque(1);
    		}else{
    			back.setVelx(1);
    			back.setMoving(true);
    		}
    	//up key
    	case 38:
    		if(back.isMoving()){
    			back.setYque(1);
    		}else{
    			back.setVely(1);
    			back.setMoving(true);
    		}
    		break;
    	//right key
    	case 39:
    		if(back.isMoving()){
    			back.setXque(-1);
    		}else{
    			back.setVelx(-1);
    			back.setMoving(true);
    		}
    	//down key
    	case 40:
    		if(back.isMoving()){
    			back.setYque(-1);
    		}else{
    			back.setVely(-1);
    			back.setMoving(true);
    		}
    		break;
    		
    	}
    }
    
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        keysDown[code][0] = 1;
        lastKey = code;
        updateMovement(code);

    }
    
    public void keyTyped(KeyEvent e)
    {
    }
    
    public void keyReleased(KeyEvent e)
    {
    	int code = e.getKeyCode();
    	keysDown[code][0] = 1;
    	
    	if(lastKey == code){
    		lastKey = -1;
    	}
    	
    	switch(code){
    	//left key
    	case 37:
    		if(back.isMoving()){
    			back.setXque(0);
    		}else{
    			back.setVelx(0);
    		}
    		break;
    	//up key
    	case 38:
    		if(back.isMoving()){
    			back.setYque(0);
    		}else{
    			back.setVely(0);
    		}
    		break;
    	//right key
    	case 39:
    		if(back.isMoving()){
    			back.setXque(0);
    		}else{
    			back.setVelx(0);
    		}
    		break;
    	//down key
    	case 40:
    		if(back.isMoving()){
    			back.setYque(0);
    		}else{
    			back.setVely(0);
    		}
    		break;
    		
    	}
    }
}
