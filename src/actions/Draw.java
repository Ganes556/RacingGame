package actions;
import java.awt.*;

import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Draw implements Constants {
    // get assets
    public BufferedImage imgPlayer() throws Exception{
        return ImageIO.read(new File(IMG_PLAYER));
    }
    public BufferedImage imgRoad() throws Exception{
        return ImageIO.read(new File(IMG_ROAD));
    }
    public BufferedImage imgTree() throws Exception{
        return ImageIO.read(new File(IMG_TREE));
    }
    public BufferedImage imgEnemy() throws Exception{
        Random rand = new Random();
        BufferedImage enemy1 = ImageIO.read(new File(IMG_ENEMY1));
        BufferedImage enemy2 = ImageIO.read(new File(IMG_ENEMY2));
        BufferedImage enemy3 = ImageIO.read(new File(IMG_ENEMY3));
        BufferedImage[] enemies = {enemy1,enemy2,enemy3};
        return enemies[Math.abs(rand.nextInt()%3)];
    }
    // drawing
    public void draw(Graphics g) throws Exception{}
    public void draw(Graphics g, int score)throws Exception{}
    public void draw(Graphics g,ArrayList <Rectangle> allPos)throws Exception{}
}