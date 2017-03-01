import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class World extends JPanel implements ActionListener, KeyListener
{
    Timer t = new Timer(5, this);  //Call Action Listener every 5 seconds
    int[][] mapGrid;
    int[][] keysDown = new int[200][10];
    int lastKey;
    
    BackgroundImage back = new BackgroundImage();
    Character me = new Character(0,0);
    MultiPurposeStack keys = new MultiPurposeStack();
    LoadMap map = new LoadMap("map1.txt");
    
    
    //Constructor
    public World()
    {
        t.start();                              //Start Timer
        addKeyListener(this);                   //Add key listener to JPanal
        setFocusable(true);                     //Sets focus to this (to use keyListener)
        setFocusTraversalKeysEnabled(false);
        ImportCSV importer = new ImportCSV();
        mapGrid = importer.importArray("map1.csv");
        int[] charPos = map.getCharPos();
        me = new Character(charPos[0] * 16, charPos[1] * 16);
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
        //back.updatePosition();
        me.update();
    }
    public void checkDir(){
    	int dir = -1;
    	if(keys.getLength() != 0)
    	for(int i = keys.getLength(); i > 1; i--){
    		System.out.print(i + " ");
    		switch(keys.getNodeAt(i).getIntValue()){
    		case 37:
    			dir = 3;
    			break;
    		case 38:
    			dir = 0;
    			break;
    		case 39:
    			dir = 1;
    			break;
    		case 40:
    			dir = 2;
    			break;
    		default:
    			//Irrelevant key code
    			break;	
    		}
    	}
    	me.setDir(dir);
    	System.out.println("/n" + dir);
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
        
        keys.addBeginning(code);
        System.out.println(e.getKeyCode());
        checkDir();
    }
    public void keyTyped(KeyEvent e)
    {
    }  
    public void keyReleased(KeyEvent e)
    {
    	int code = e.getKeyCode();
    	
    	keys.deleteValue(code);
    	checkDir();
    	
    	
    	
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
