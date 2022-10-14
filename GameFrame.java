import javax.swing.*;

//Class to create window
public class GameFrame extends JFrame {

    GameFrame(){
//        GamePanel panel = new GamePanel();
//        this.add(panel);

        this.add(new GamePanel());
        this.setTitle("2nake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); //makes things fit snugly
        this.setVisible(true);
        this.setLocationRelativeTo(null); //puts window in middle of screen
    }

}
