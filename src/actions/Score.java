package actions;
import java.awt.*;
public class Score extends Draw{
    private int score = 0;
    private int sizeFont = 30;
    private String fontFamily = "Ink Free";
    @Override
    public void draw(Graphics g){
        g.setFont(new Font(fontFamily,Font.BOLD,sizeFont));
        FontMetrics metrics =  g.getFontMetrics(g.getFont());
                
        g.setColor(Color.white);
        // Score
        g.drawString("Score", 320, sizeFont);        
        g.drawString(String.valueOf(score), (320 + metrics.stringWidth("Score")/2)-metrics.stringWidth(String.valueOf(score))/2,  sizeFont + 30);
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score =score;
    }
}
