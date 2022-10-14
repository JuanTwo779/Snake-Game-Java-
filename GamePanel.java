import javax.swing.*; //Graphics
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//class for things in the window
public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 750; //starts from bottom left of frame
    static final int SCREEN_HEIGHT = 750; //starts from top of frame
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
        random = new Random(); //makes object for all methods called by constructor, to use
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
        super.paintComponent(g); //super calls the super class (JPanel) method
        draw(g);
    }

    public void draw(Graphics g){
        for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++){
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT); //draws line from (x1,y1) to (x2,y2)
            g.drawLine(0, i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        }
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) { //head of snake
                g.setColor(new Color(34,139,34));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            else{
                g.setColor(new Color(45,180,0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleX = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move(){
        //switches body parts
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1]; //i.e. x[6] becomes x[5], x[5] becomes x[4]...
            y[i] = y[i-1];
        }

        switch(direction) {
        case 'U':
            y[0] = y[0] - UNIT_SIZE;
            break;
        case 'D':
            y[0] = y[0] + UNIT_SIZE;
            break;
        case 'L':
            x[0] = x[0] - UNIT_SIZE;
            break;
        case 'R':
            x[0] = x[0] + UNIT_SIZE;
            break;
        }
    }

    public void checkApple(){

    }

    public void checkCollisions(){
        for (int i = bodyParts; i > 0; i--) { //head touches body
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        //head touches left border
        if (x[0] < 0){
            running = false;
        }
        //head touches right border
        if (x[0] > SCREEN_WIDTH){
            running = false;
        }
        //head touches top border
        if (y[0] < 0){
            running = false;
        }
        //head touches bottom border
        if (y[0] > SCREEN_HEIGHT){
            running = false;
        }

        if (!running){
            timer.stop();
        }
    }

    public void gameOver(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
