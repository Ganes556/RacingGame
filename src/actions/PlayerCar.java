package actions;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class Player{
    int x,y;    
    BufferedImage img;
    Player(int x, int y, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }
}
public class PlayerCar extends Draw{
    private int PLAYER_Y = (SCREEN_HEIGHT-(CAR_SIZE_HEIGHT+5));    
    private int moveUpDown = 0;
    private int moveRightLeft= 0;
    private char moveP = 'R';

    @Override
    public void draw(Graphics g) throws IOException{        
        int y = PLAYER_Y+(moveUpDown); 
        int x = RIGHT_LEFT_POS_CAR[moveRightLeft];        
        g.drawImage(imgPlayer(), x, y, null);        
    }

    // another
    public void checkLimitPanel(){
        int y = (SCREEN_HEIGHT-(CAR_SIZE_HEIGHT+5)+(moveUpDown));
        if(y >= SCREEN_HEIGHT-(CAR_SIZE_HEIGHT+5)){
            moveUpDown=0;
        }else if( y <= 0){
            moveUpDown=-510;
        }
    }
    
    public Boolean checkCollisions(ArrayList <Enemy> enemies){
        for(Enemy rect :  enemies){    
            Rectangle p = new Rectangle(RIGHT_LEFT_POS_CAR[moveRightLeft], PLAYER_Y +(moveUpDown), CAR_SIZE_WIDTH,CAR_SIZE_HEIGHT);
            Rectangle e = new Rectangle(rect.x, rect.y, rect.img.getWidth(),rect.img.getHeight());

            if(p.intersects(e)){
                return false;
            }
        }
        return true;
    }

    // getter
    public int getMoveP(){
        return moveP;
    }
    public int getPLAYER_Y(){
        return PLAYER_Y; 
    }
    // setter
    public void setMovePlayer(){
        switch(moveP){
            case 'U':                
            moveUpDown -= 15;
            checkLimitPanel();
                break;
            case 'D':
                moveUpDown += 15;
                checkLimitPanel();
                break;
            case 'L':
                moveRightLeft = 0;	                
                break;
            case 'R':
                moveRightLeft = 1;
                break;            
        }
        moveP = '0';
    }
    public void setResetPosPlayer(){
        this.moveRightLeft = 1;
        this.moveUpDown =0;
    }
    
    public void setMoveP(char moveP){
        this.moveP =  moveP;
    }
}
