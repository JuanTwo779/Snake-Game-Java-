import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS]; //holds body of the snake in x-coords
    final int y[] = new int[GAME_UNITS]; //holds body of the snake in y-coords
    int bodyParts = 5;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R'; //L, U, R, D
    boolean running = false;
    Timer timer; //Swing class
    Random random; //Random class

    GamePanel(){
        random = new Random();
        //JPanel methods
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);

        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        newApple(); //create new apple
        running = true;
        timer = new Timer(DELAY,this); //this is from action listener
        timer.start();
    }

    //swing method
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++){
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT); //draws line from (x1,y1) to (x2,y2)
            g.drawLine(0, i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        }
    }

    public void newApple(){

    }

    public void move(){

    }

    public void checkApple(){

    }

    public void checkCollisions(){

    }

    public void gameOver(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
