import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        Game obj = new Game();
      
    }
}
class Game extends JFrame{
    public Game(){
        GamePlay gamePlay = new GamePlay();
        setBounds(10,10,706,600);
        setTitle("Brick Backer Game");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
        
        add(gamePlay);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX()+" "+e.getY());
            }
        });
    }


}