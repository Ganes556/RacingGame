package actions;
import java.awt.*;
public class GameOver extends Draw{
    private int sizeFontGameOver = 40;
    private int sizeFontScore = 30;
    private int sizeFontPressEnter = 35;
    private String fontFamily = "Ink Free";
    @Override
    public void draw(Graphics g, int score){
        g.setFont(new Font(fontFamily,Font.BOLD,sizeFontGameOver));
        FontMetrics metrics =  g.getFontMetrics(g.getFont());

        // transparant bg
        g.setColor(new Color(0,0,0,150));
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // game over
        g.setColor(Color.red);
        g.drawString("Game Over", SCREEN_WIDTH/2-metrics.stringWidth("Game Over")/2, SCREEN_HEIGHT/4);

        // score
        g.setColor(Color.white);
        g.setFont(new Font(fontFamily,Font.BOLD,sizeFontScore));
        FontMetrics metrics2 = g.getFontMetrics(g.getFont());
        g.drawString("Score", SCREEN_WIDTH/2-metrics2.stringWidth("Score")/2, (SCREEN_HEIGHT/4)+sizeFontGameOver+10);
        g.drawString(String.valueOf(score), SCREEN_WIDTH/2-metrics2.stringWidth(String.valueOf(score))/2, (SCREEN_HEIGHT/4)+sizeFontGameOver*2+10);
        
        // press enter to restart
        g.setColor(new Color(255,255,255,127));
        g.setFont(new Font(fontFamily,Font.BOLD,sizeFontPressEnter));
        FontMetrics metrics3 = g.getFontMetrics(g.getFont());
        g.drawString("Press enter...", SCREEN_WIDTH/2-metrics3.stringWidth("Press enter...")/2, (SCREEN_HEIGHT/4)+sizeFontGameOver*4+10);
        
    }
}
