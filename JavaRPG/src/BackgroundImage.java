import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundImage {
	int x = -62;                     //x position
    int y = -60;                     //y position
    int velx = 0;               //Velocity in x direction
    int vely = 0;               //Velocity in y direction
    int dir = 0;
    int xque;
    int yque;
    int interval = 16;
    int initialInterval = 16;
    boolean moving = false;
	private BufferedImage image, character;
	
	public BufferedImage getCharacter() {
		return character;
	}

	public void setCharacter(BufferedImage character) {
		this.character = character;
	}

	public BackgroundImage(){
		image();
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	void image(){
		try
        {
			image = ImageIO.read(getClass().getResourceAsStream("testMap.png"));
            character = ImageIO.read(getClass().getResourceAsStream("character.png"));
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
	void pushQues(){
		velx = xque;
		vely = yque;
	}
	
	public void updatePosition(){
		
        if(moving){
        	x += velx;
            y += vely;
        	if(interval == 0){
        		moving = false;
        		interval = initialInterval;
        		pushQues();
        	}
        	interval--;
        }else{
        	velx = 0;
        	vely = 0;
        }
        
        //Boundary Checks
        /******/
        if (x < -1040)
        {
            x = -1040;
        }
        else if (x > 0)
        {
            x = 0;
        }
        
        if (y < -541)
        {
            y = -541;
        }
        else if (y > 0)
        {
            y = 0;
        }
        /******/
	}

	public int getXque() {
		return xque;
	}

	public void setXque(int xque) {
		this.xque = xque;
	}

	public int getYque() {
		return yque;
	}

	public void setYque(int yque) {
		this.yque = yque;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelx() {
		return velx;
	}

	public void setVelx(int velx) {
		this.velx = velx;
	}

	public int getVely() {
		return vely;
	}

	public void setVely(int vely) {
		this.vely = vely;
	}
}
