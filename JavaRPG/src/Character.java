import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {

	int x = 0;                     //x position relative to the world
    int y = 0;                     //y position relative to the world
    int gridx = 0;
    int gridy = 0;
    int dir = -1;
    int buffdir = -1;
    boolean moving = false;
    private BufferedImage image;
    
    public void maintain(int[][] map){
    	if(dir == -1){
    		moving = false;
    		return;
    	}
    	switch(dir){
    	case 0:
    		if(map[gridx][gridy - 0] == 0){
    			moving = true;
    		}
    		break;
    	case 1:
    		if(map[gridx + 1][gridy] == 0){
    			moving = true;
    		}
    		break;
    	case 2:
    		if(map[gridx][gridy + 1] == 0){
    			moving = true;
    		}
    		break;
    	case 3:
    		if(map[gridx - 0][gridy] == 0){
    			moving = true;
    		}
    		break;
    	}
    }
    public void update(){
    	if(moving){
    		if(((x % 16) + (y % 16)) == 0){
    			moving = false;
    			dir = buffdir;
    			return;
    		}
    	}
    	//System.out.println(dir);
    	switch(dir){
    	case 0:
    		y--;
    		moving = true;
    		break;
    	case 1:
    		x++;
    		break;
    	case 2:
    		y++;
    		break;
    	case 3:
    		x--;
    		break;
    		default:
    			dir = -1;
    			break;
    	}
    }
    public void setDir(int i){
    	dir = i;
    }
    public int getGridx() {
		return gridx;
	}
	public void setGridx(int gridx) {
		this.gridx = gridx;
	}
	public int getGridy() {
		return gridy;
	}
	public void setGridy(int gridy) {
		this.gridy = gridy;
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
	public BufferedImage getImage() {
		return image;
	}
	public Character(int xx, int yy){
		 x = xx;
		 y = yy;
		 gridx= xx/16;
		 gridy= yy/16;
		 image();
	}	
	void image(){
		try
        {
			image = ImageIO.read(getClass().getResourceAsStream("Character1.png"));
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
}
