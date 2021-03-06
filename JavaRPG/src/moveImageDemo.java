import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class moveImageDemo extends JPanel implements ActionListener, KeyListener
{
    Timer t = new Timer(5, this);  //Call Action Listener every 5 seconds
    
    int x = 0;                     //x position
    int y = 0;                     //y position
    int velx = 0;               //Velocity in x direction
    int vely = 0;               //Velocity in y direction
    
    private BufferedImage image;
    
    //Constructor
    public moveImageDemo()
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
    }
    
    public void keyTyped(KeyEvent e)
    {
    }
    
    public void keyReleased(KeyEvent e)
    {
        velx = 0;
        vely = 0;
    }
    }
