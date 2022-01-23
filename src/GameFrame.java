import javax.swing.*;
public class GameFrame extends JFrame {
    GameFrame() throws Exception{        
        this.add(new GamePanel());
        this.setTitle("Car Game");        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setResizable(false);        
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}