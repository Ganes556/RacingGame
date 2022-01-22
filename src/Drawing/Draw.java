package Drawing;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;

public class Draw implements Constants {
    public BufferedImage imgPlayer() throws IOException{
        return ImageIO.read(new File("D:\\perkuliahan\\OneDrive - STIKOM Bali\\Mata Kuliah - Pembelajaran\\SEMESTER III\\pemograman pbo\\buat UAS\\MakeGame\\assets\\player.png"));
    }
    public BufferedImage imgRoad() throws IOException{
        return ImageIO.read(new File("D:\\perkuliahan\\OneDrive - STIKOM Bali\\Mata Kuliah - Pembelajaran\\SEMESTER III\\pemograman pbo\\buat UAS\\MakeGame\\assets\\road.png"));
    }
    public BufferedImage imgTree() throws IOException{
        return ImageIO.read(new File("D:\\perkuliahan\\OneDrive - STIKOM Bali\\Mata Kuliah - Pembelajaran\\SEMESTER III\\pemograman pbo\\buat UAS\\MakeGame\\assets\\tree.png"));
    }
    public BufferedImage imgEnemy() throws IOException{
        Random rand = new Random();
        BufferedImage enemy1 = ImageIO.read(new File("D:\\perkuliahan\\OneDrive - STIKOM Bali\\Mata Kuliah - Pembelajaran\\SEMESTER III\\pemograman pbo\\buat UAS\\MakeGame\\assets\\enemy1.png"));
        BufferedImage enemy2 = ImageIO.read(new File("D:\\perkuliahan\\OneDrive - STIKOM Bali\\Mata Kuliah - Pembelajaran\\SEMESTER III\\pemograman pbo\\buat UAS\\MakeGame\\assets\\enemy2.png"));
        BufferedImage enemy3 = ImageIO.read(new File("D:\\perkuliahan\\OneDrive - STIKOM Bali\\Mata Kuliah - Pembelajaran\\SEMESTER III\\pemograman pbo\\buat UAS\\MakeGame\\assets\\enemy3.png"));
        BufferedImage[] enemies = {enemy1,enemy2,enemy3};
        return enemies[Math.abs(rand.nextInt()%3)];
    }

    public void draw(Graphics g) throws IOException{}
    public void draw(Graphics g, int score)throws IOException{}
    public void draw(Graphics g,ArrayList <Rectangle> allPos)throws IOException{}    
    
}