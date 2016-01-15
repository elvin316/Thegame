import java.awt.*;
import javax.swing.*;

public class Gamecanvas extends Canvas{

    int margin;
    double tokenSize;		
    Board b;
    int[][] marking;
    
    
    public Gamecanvas(Board db) {
        setBackground(Color.WHITE);
        margin=20;
        tokenSize=0.7;
        b=db;
        marking = new int[8][8];
    }
    
    public void editb(int x,int y,String color){
    	b.setValue(x,y,color);
    }
					
    
    public int[] convert(int x, int y) {
	    int[] ans = new int[2];
	   
	int w=getWidth();
        int h=getHeight();

        int squareSize = Math.max(0, Math.min(w,h)-40) / 8; 
		
	ans[0]= (x-margin) / squareSize;
	ans[1]= (y-margin) / squareSize;
	    
	return ans;
    }
    
    public void paint(Graphics g) {
        
        int w=getWidth();
        int h=getHeight();

        int squareSize = Math.max(0, Math.min(w,h)-40) / 8;
        int tm = (squareSize-(int) (squareSize*tokenSize))/2;

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if ( (i+j) % 2 == 0) 
                    g.setColor(Color.BLACK);
                else 
                    g.setColor(Color.GRAY);
                
                g.fillRect(20+i*squareSize, 20+j*squareSize, 
                           squareSize, squareSize);
            }
        }

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (!(b.getValue(i,j).equals(""))) {
                	switch(b.getValue(i,j)) {
                	case "Red":
                    g.setColor(Color.RED);
                    break;
                	case "Yellow":
                    g.setColor(Color.YELLOW);
                    break;
                	case "Blue":
                    g.setColor(Color.BLUE);
                    break;
                	case "Green":
                    g.setColor(Color.BLUE);
                    break;
                	}
                    g.fillOval(20+tm+i*squareSize, 20+tm+j*squareSize, 
                               squareSize-2*tm, squareSize-2*tm);
                }
            }
        }
	


        // draw the board
        
    }

    

}
