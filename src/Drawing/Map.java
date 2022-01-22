package Drawing;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class Tree{
    int x,y;
    BufferedImage img;
    Tree(int x,int y, BufferedImage img){
        this.x =x;
        this.x =y;
        this.img =img;
    }

}
public class Map extends Draw{
    private ArrayList <Tree> tree = new ArrayList<Tree>();
    @Override
    public void draw(Graphics g) throws IOException{
        // g.setColor(Color.white);
        // g.fillRect((SCREEN_WIDTH/2)/2, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT);
        // g.setColor(Color.black);
        // g.drawLine(SCREEN_WIDTH/2, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT); 
        g.drawImage(imgRoad(),0, 0, null);
        
        // g.drawImage(imgTree(), 0, 30, null);
    }
    public void addTree(){
        
    }
    
}
