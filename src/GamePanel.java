import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import actions.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GamePanel extends JPanel implements ActionListener,KeyListener,Constants{
    
    private EnemyCar enemyCar;
    private PlayerCar playerCar;
    private int limitLevel = 590;

    private int speed;       
       
    private Map map;
    private Score score;
    private GameOver gameOver;
    private Boolean restart = false;    

    private AudioInputStream audioInputStream;
    private Clip clip = AudioSystem.getClip();

    private boolean running = false;
    private Timer timer;
	

    GamePanel() throws Exception{
        
        speed = 5;                                              
        
        map = new Map();

        enemyCar = new EnemyCar();
                
        playerCar = new PlayerCar();

        score = new Score();

        gameOver = new GameOver();
        
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));  
        this.setBackground(Color.red);
        this.setFocusable(true);
        this.addKeyListener(this);        
        gameStart();
    }    

    @Override
    public void paintComponent(Graphics g) {                 
        try{
            map.draw(g);
            playerCar.draw(g);            
            enemyCar.draw(g);

            if(running){
                score.draw(g);
            }else{                                
                gameOver.draw(g,score.getScore());                
                clip.close();
                running = false; 
                restart = false;           
            }
            
        } catch (Exception e) {System.out.println(e.toString());}
       
    }
  
    public void nextLevel(){
        if(limitLevel == 0 && speed != 30){            
            speed++;
            limitLevel=590;
        }
        
    }
    public void startBackSound()throws Exception{
        clip.close();
        audioInputStream = AudioSystem.getAudioInputStream(new File(SOUND_BACKGROUND));
        clip.open(audioInputStream);
        clip.start();
    }

    public void gameStart() throws Exception{                  
        running = true;        
		timer = new Timer(20,this);
		timer.start();
        startBackSound();
        map.setFirstAddLines();
        enemyCar.setAddEnemies();
        map.setFirstAddTrees();
    }
    
    public void gameRestart() throws Exception{
        speed = 5;
        timer.stop();
        map.setClear();        
        enemyCar.setClear();
        enemyCar.setSpace(220);
        playerCar.setResetPosPlayer();
        score.setScore(0);        
        gameStart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(running){
                if(!clip.isRunning()) startBackSound();
                limitLevel--;
                running = playerCar.checkCollisions(enemyCar.getEnemies());
                playerCar.setMovePlayer();
                map.setMoveLines(speed);
                map.setMoveTrees(speed);
                enemyCar.setEnemiesMove(speed, score);                        
                enemyCar.setMakeSpace(speed);
                nextLevel();
            }else if(restart && !running){                                
                gameRestart();                
            }
        } catch (Exception er) {
            System.out.println(er);
        
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:        
                playerCar.setMoveP('U');                	
				break;
			case KeyEvent.VK_DOWN:                                
                playerCar.setMoveP('D');
				break;
			case KeyEvent.VK_LEFT:           
                playerCar.setMoveP('L');				
				break;
			case KeyEvent.VK_RIGHT:				
                playerCar.setMoveP('R');                
				break;
            case KeyEvent.VK_ENTER:
                restart=true;
                break;
		}
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    
}   