import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class World extends JPanel implements ActionListener
{
	int timerSpeed = 5;
	//This calls calls the actionPerformed class every 5 milliseconds.
	//We will wan't to rebuild the timer to call an update function every millisecond
	//and handle the key listeners differently
    Timer t = new Timer(timerSpeed, this);  //Call Action Listener every 5 milliseconds
    int[][] mapGrid;
    
    BackgroundImage back = new BackgroundImage();
    Character me = new Character(0,0);
    LoadMap map = new LoadMap("map1.txt");
    MultiPurposeStack keyArrayWASD;
    MasterKeyListener master;
    
    //Constructor
    public World()
    {
        setFocusable(true);                     //Sets focus to this (to use keyListener)
        setFocusTraversalKeysEnabled(false);
        ImportCSV importer = new ImportCSV();
        mapGrid = importer.importArray("map1.csv");
        int[] charPos = map.getCharPos();
        me = new Character(charPos[0] * 16, charPos[1] * 16);
        me.setMap(mapGrid);
        master = new MasterKeyListener(this);
        keyArrayWASD = master.getKeyArrayWASD();
        
        t.start();
    }
    public void paint(Graphics g)
    {
    	super.paint(g);
    	setBackground(Color.RED);
        g.drawImage(back.getImage(), back.getX(), back.getY(), null);
        g.drawImage(me.getImage(),me.getX(),me.getY(),null);
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(!keyArrayWASD.isEmpty()){
    		switch(keyArrayWASD.getHead().getIntValue()){
    		case 0:
    			me.setBuffDir(0);
    			break;
    		case 1:
    			me.setBuffDir(1);
    			break;
    		case 2:
    			me.setBuffDir(2);
    			break;
    		case 3:
    			me.setBuffDir(3);
    			break;
    		default:
    			me.setBuffDir(-1);
    		}
    	}else if(keyArrayWASD.isEmpty()){
			me.setBuffDir(-1);
		}
    	me.updateDir();
    	me.move();
    	me.updateGridPos();
    	repaint();
    }    
}