import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {

	private BufferedImage image;
	int x = 0,
		y = 0,
		gridx = 0,
    	gridy = 0,
    	buffDir,
    	dir;
	int[][] map;
	boolean canChangeDir = false,
			inGrid = true;
	public void updateDir(){
		//dummy variable to make things readable, will remove when code works.
		if((x % 16 == 0) && (y % 16 == 0)){
			inGrid = true;
			dir = buffDir;
		}else{
			inGrid = false;
		}
		
		if(!inGrid){
			canChangeDir = false;
		}else{
			canChangeDir = true;
		}
	}
	public void updateGridPos(){
		switch(buffDir){
		case 0:
			gridy = (int)Math.floor((double)y/16);
			break;
		case 1:
			gridx = (int)Math.ceil((double)x/16);
			break;
		case 2:
			gridy = (int)Math.ceil((double)y/16);
			break;
		case 3:
			gridx = (int)Math.floor((double)x/16);
			break;
			default:
				break;
		}
		System.out.println(gridx + ", " + gridy);
	}
	public void setMap(int[][] map) {
		this.map = map;
	}
	public void move(){
		switch(dir){
		case -1:
			//Character doesn't move
			break;
		case 0:
			//Character moves upward
			if(inGrid == false){
				y--;
			}else if(isClear() == true){
				y--;
			}
			break;
		case 1:
			//Character moves right
			if(inGrid == false){
				x++;
			}else if(isClear() == true){
				x++;
			}
			break;
		case 2:
			//Character moves down
			if(inGrid == false){
				y++;
			}else if(isClear() == true){
				y++;
			}
			break;
		case 3:
			//Character moves left
			if(inGrid == false){
				x--;
			}else if(isClear() == true){
				x--;
			}
			break;
		}
	}
	public boolean isClear(){
		switch(dir){
		case 0:
			//there is an offset because of the pictures hieght. this needs to be fixed asap.
			return (map[gridy][gridx] == 0);
		case 1:
			return (map[gridy + 1][gridx + 1] == 0);
		case 2:
			return (map[gridy + 2][gridx] == 0);
		case 3:
			return (map[gridy + 1][gridx - 1] == 0);
		}
		return false;
	}
	public void setBuffDir(int dir) {
		this.buffDir = dir;
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
