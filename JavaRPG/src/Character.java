import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {

	int x = 0;                     //x position relative to the world
    int y = 0;                     //y position relative to the world
    private BufferedImage image;
	
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

	public BufferedImage getImage() {
		return image;
	}

	public Character(int xx, int yy){
		 x = xx;
		 y = yy;
		 image();
	}
	
	void image(){
		try
        {
			image = ImageIO.read(getClass().getResourceAsStream("character.png"));
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
}
