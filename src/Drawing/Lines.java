package Drawing;
import java.util.ArrayList;
import java.awt.*;
public class Lines extends Draw{    
    ArrayList <Rectangle> Lines = new ArrayList<Rectangle>();

    @Override
    public void draw(Graphics g){        
        for(int i=0; i<this.Lines.size(); i++){
            Rectangle line = this.Lines.get(i);
            g.setColor(Color.white);
            g.fillRect(line.x, line.y ,line.width,line.height);
        }
    }

    public void setMoveLines(int speed){
        for(int i =0; i < Lines.size(); i++){
            Rectangle oldLine = Lines.get(i);
            if(oldLine.y >= 590){                
                Rectangle newRect = new Rectangle(oldLine.x,-54+speed,oldLine.width,oldLine.height);
                Lines.set(i, newRect);                                    
            }else{
                Rectangle newRect = new Rectangle(oldLine.x,oldLine.y+speed,oldLine.width,oldLine.height);
                Lines.set(i, newRect);
            }                
        }
    }

    public void setFirstAddLines(){
        int x = LINES_X;
        int y = 5;                
        for(int i=0; i<11; i++){
            if(i %2 == 0){
                Lines.add(new Rectangle(x,y,SIZE_LINE_WIDTH,SIZE_LINE_HEIGHT));
            }
            y+=54;
        }        
    }    
    public void setClear(){
        Lines.clear();
    }
}
