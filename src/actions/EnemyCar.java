package actions;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;

class Enemy{
    int x,y,width,height;    
    BufferedImage img;
    Enemy(int x, int y, BufferedImage img,int width,int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }
}

public class EnemyCar extends Draw{
    private int ENEMY_Y = 5;
    private int space = 220;

    Random rand = new Random();
    ArrayList <Enemy> Enemies = new ArrayList<Enemy>();
    // ArrayList <Rectangle> colLimit  = new ArrayList<Rectangle>();
    @Override
    public void draw(Graphics g) throws IOException{        
        for(Enemy rect : Enemies){
            // g.setColor(Color.red);
            g.drawImage(rect.img, rect.x, rect.y, null);
            // g.fillRect(rect.x, rect.y ,rect.width,rect.height);
        }
    }

    // getter
    public ArrayList <Enemy> getEnemies(){
        return Enemies;
    }    
    
    // setter 
    public void setAddEnemies() throws IOException{
        int x = RIGHT_LEFT_POS_CAR[Math.abs(rand.nextInt()%2)];
        int y = ENEMY_Y-CAR_SIZE_HEIGHT;
        Enemies.add(new Enemy(x,y,imgEnemy(),CAR_SIZE_WIDTH,CAR_SIZE_HEIGHT));        
    }
    
    public void setEnemiesMove(int speed, Score score) throws IOException{
        if(Enemies.size() > 0){
            for(int i =0; i < Enemies.size(); i++){
                Enemy oldEnemy = Enemies.get(i);
                if(oldEnemy.y >= 590){
                    Enemies.remove(i);   
                    score.setScore(score.getScore()+1);
                }else{
                    Enemy newRect = new Enemy(oldEnemy.x,oldEnemy.y+speed,oldEnemy.img,CAR_SIZE_WIDTH,CAR_SIZE_HEIGHT);
                    Enemies.set(i, newRect);
                }                
            }
        }        
        if(space <= 0){                   
            int ran = ThreadLocalRandom.current().nextInt(210, 300 + 1);
            space = ran;
            this.setAddEnemies();
        }
    }
    public void setClear(){
        Enemies.clear();
    }

    public void setSpace(int space){
        this.space = space;
    }

    public void setMakeSpace(int speed){
        this.space -=speed;
    }
}
