import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import Drawing.*;

public class GamePanel extends JPanel implements ActionListener,KeyListener,Constants{
    
    private EnemyCar enemyCar;
    private PlayerCar playerCar;
    private int batasLevel = 590;

    private int speed;       
    
    private Lines lines;    
    private Map map;
    private Score score;
    private GameOver gameOver;
   
    private Boolean restart = false;
    
    // int countScore =0;
    boolean running = false;
    Timer timer;
	

    GamePanel() throws IOException{
        speed = 5;                                              
        
        map = new Map();

        enemyCar = new EnemyCar();
        
        lines = new Lines();

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
    public void paint(Graphics g) { 
        // agar update ui sebelumnya 
        super.paintComponent(g);             
        try{

            map.draw(g);
            playerCar.draw(g);
            lines.draw(g);
            enemyCar.draw(g);
            if(running){
                score.draw(g);
            }else{                                
                gameOver.draw(g,score.getScore());
                running = false; 
                restart = false;           
            }
            
        } catch (IOException e) {System.out.println(e.toString());}   
       
    }
  
    public void nextLevel(){
        if(batasLevel == 0 && speed != 30){            
            speed++;
            batasLevel=590;            
        }
        
    }
    public void gameStart() throws IOException{        
        running = true;        
		timer = new Timer(20,this);
		timer.start();
        lines.setFirstAddLines();
        enemyCar.setAddEnemies();
    }
    
    public void gameRestart() throws IOException{
        speed = 5;
        timer.stop();
        enemyCar.setClear();
        lines.setClear();
        playerCar.setResetPosPlayer();
        enemyCar.setSpace(220);
        gameStart();        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(running){               
                batasLevel--;
                running = playerCar.checkCollisions(enemyCar.getEnemies());
                nextLevel();
                playerCar.setMovePlayer();
                lines.setMoveLines(speed);
                enemyCar.setEnemiesMove(speed, score);                        
                enemyCar.setMakeSpace(speed);
            }else if(restart && !running){
                gameRestart();                
            }
        } catch (IOException er) {
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