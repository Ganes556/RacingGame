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
        // Score
        g.setColor(Color.white);
        g.drawString("Score", 320, sizeFont);        
        // Value of score
        g.drawString(String.valueOf(score), (320 + metrics.stringWidth("Score")/2)-metrics.stringWidth(String.valueOf(score))/2,  sizeFont + 30);
    }
    // getter
    public int getScore() {
        return score;
    }
    // setter
    public void setScore(int score) {
        this.score =score;
    }
}
