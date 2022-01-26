package actions;
import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class Tree{
    int x,y;
    BufferedImage img;
    Tree(int x,int y, BufferedImage img){
        this.x =x;
        this.y =y;
        this.img =img;
    }

}
public class Map extends Draw{
    private final int SIZE_LINE_WIDTH = 10;
    private final int SIZE_LINE_HEIGHT = 59;
    private int LINES_X = (SCREEN_WIDTH/2)-(SIZE_LINE_WIDTH/2);   
    private int LINES_Y = 5;   
    private ArrayList <Tree> trees = new ArrayList<Tree>();
    private ArrayList <Rectangle> Lines = new ArrayList<Rectangle>();

    @Override
    public void draw(Graphics g) throws Exception{
        g.drawImage(imgRoad(),0, 0, null);
        for(Rectangle line : Lines){            
            g.setColor(Color.white);
            g.fillRect(line.x, line.y ,line.width,line.height);
        }
        for(Tree tree : trees){                        
            g.drawImage(tree.img, tree.x,tree.y, null);
        }        
    }
    // setter
    public void setFirstAddTrees() throws Exception{
        int x1 = (195/2)-imgTree().getWidth();
        int x2 = 400-imgTree().getWidth();
        int y12 = -imgTree().getHeight();        
        // left tree
        for(int i=0; i < 6; i++){
            trees.add(new Tree(x1,y12, imgTree()));
            y12+= imgTree().getHeight()+30;
        }
        // right tree
        y12 =-imgTree().getHeight();
        for(int i=0; i < 6; i++){
            trees.add(new Tree(x2,y12, imgTree()));
            y12+=imgTree().getHeight()+30;            
        }

    }
    public void setMoveTrees(int speed){
        // left tree
        for(int i =0; i < trees.size(); i++){
            Tree tree = trees.get(i);
            if(tree.y >= 590){                                
                Tree newRect = new Tree(tree.x,-tree.img.getHeight()-50,tree.img);
                trees.set(i, newRect);                                    
            }else{
                Tree newRect = new Tree(tree.x,tree.y+speed,tree.img);
                trees.set(i, newRect);
            }                
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
        for(int i=0; i<11; i++){
            if(i %2 == 0){
                Lines.add(new Rectangle(LINES_X,LINES_Y,SIZE_LINE_WIDTH,SIZE_LINE_HEIGHT));
            }
            LINES_Y+=54;
        }        
        LINES_Y=5;
    }    
    public void setClear(){
        Lines.clear();
        trees.clear();
    }
}