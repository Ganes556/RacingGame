import javax.swing.ImageIcon;
import javax.swing.JFrame;
import actions.Constants;
public class GameFrame extends JFrame implements Constants{
    GameFrame() throws Exception{       
        ImageIcon img = new ImageIcon(ICON);         
        this.add(new GamePanel());        
        this.setTitle("Car Game");        
        this.setIconImage(img.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setResizable(false);        
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}