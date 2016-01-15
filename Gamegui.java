import javax.swing.*;

import java.awt.*;
public class Gamegui extends JFrame {
	JPanel buttonPanel;
    JButton b1, b2, b3;
    static Gamecanvas canvas;
    Board b;
    Game currentgame;
    
    public Gamegui(){
        b=new Board();

        setSize(800,600);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout() );
        

        b1 = new JButton("button 1");
        b2 = new JButton("button 2");
        b3 = new JButton("button 3");
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
       
        cp.add(buttonPanel, BorderLayout.EAST);

        canvas= new Gamecanvas(b);
        cp.add(canvas,BorderLayout.CENTER);

    }
    
    public static void main(String[] args) {
        Gamegui frame = new Gamegui();
        frame.setVisible(true);
    }
    
}
