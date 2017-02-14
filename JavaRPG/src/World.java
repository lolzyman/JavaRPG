import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class World extends JPanel implements ActionListener, KeyListener
{
    Timer t = new Timer(5, this);  //Call Action Listener every 5 seconds
    
    int[][] keysDown = new int[200][10];
    int lastKey;
    int x = 0;                     //x position
    int y = 0;                     //y position
    int velx = 0;               //Velocity in x direction
    int vely = 0;               //Velocity in y direction
    
    private BufferedImage image;
    
    //Constructor
    public World()
    {
        t.start();                              //Start Timer
        addKeyListener(this);                   //Add key listener to JPanal
        setFocusable(true);                     //Sets focus to this (to use keyListener)
        setFocusTraversalKeysEnabled(false);
        
        
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("CenterCampus.jpg"));
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
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
        g.drawImage(image, x, y, null);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        x += velx;
        y += vely;
        
        if (x < -480)
        {
            x = -480;
        }
        else if (x > 20)
        {
            x = 20;
        }
        
        if (y < -230)
        {
            y = -230;
        }
        else if (y > 20)
        {
            y = 20;
        }
    }
    
    public void updateMovement(int keyCode){
    	switch(keyCode){
    	//left key
    	case 37:
    		velx = 1;
    		break;
    	//up key
    	case 38:
    		vely = 1;
    		break;
    	//right key
    	case 39:
    		velx = -1;
    		break;
    	//down key
    	case 40:
    		vely = -1;
    		break;
    		
    	}
    }
    public void up()
    {
        vely = 1;
        velx = 0;
        
    }
    
    public void down()
    {
        vely = -1;
        velx = 0;
    }
    
    public void left()
    {
        velx = 1;
        vely = 0;
    }
    
    public void right()
    {
        velx = -1;
        vely = 0;
        
    }
    
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        keysDown[code][0] = 1;
        lastKey = code;
        updateMovement(code);
        /*
        if(code == KeyEvent.VK_UP)
        {
            up();
        }
        
        if(code == KeyEvent.VK_DOWN)
        {
            down();
        }
        
        if(code == KeyEvent.VK_LEFT)
        {
            left();
        }
        
        if(code == KeyEvent.VK_RIGHT)
        {
            right();
        }
        */
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
    		velx = 0;
    		break;
    	//up key
    	case 38:
    		vely = 0;
    		break;
    	//right key
    	case 39:
    		velx = 0;
    		break;
    	//down key
    	case 40:
    		vely = 0;
    		break;
    		
    	}
    }
}
