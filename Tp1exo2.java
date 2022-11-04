import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tp1exo2 extends JFrame {
    final static int BOARD_COLS = 10;
    final static int BOARD_ROWS = 10;
    final static int BOARD_WIDTH = 300;
    final static int BOARD_HEIGHT = 330;
    final static int CELL_WIDTH = 30;
    final static int CELL_HEIGHT = 30;
    final static int EMPTY_CELL = 0;
    final static int NEW_CELL = 10;
    final static int ONE_CELL = 1;
    final static int TWO_CELL = 2;
    final static int THREE_CELL = 3;

    final static int Mines = 10;


    int CELL_X,CELL_Y;
    int [][] BOARD_CELLS = new int [10][10];
    int [][] NEIGHBORS_CELLS = new int [10][10];
    int [][] REVEALED_CELLS = new int[10][10];
    public static boolean playing = false;


    public Tp1exo2() {
        JFrame frame = new JFrame();
        frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        frame.setLocation(500,500);
        frame.setVisible(true);
        frame.add(new Board());
    }

    class Board extends JPanel {
        public Board() {
            setSize(BOARD_WIDTH, BOARD_HEIGHT);
            setBackground(Color.BLACK);
            initBoard();
            setVisible(true);
            addMouseListener(new BoardEvents());
        }

        private void initBoard() {
        }


        public int randomMines(){
            Random random = new Random();
            int max,min,rand,mines;
            max=7;
            min=0;
            mines=0;

            // if randomNum is 1 so the cell is a mine
            for(int i=0;i<BOARD_ROWS;i++){
                for(int j=0;j<BOARD_COLS;j++){
                    rand = random.nextInt(((max-min)+1)+min);
                    if(rand == 1) {
                        BOARD_CELLS[i][j] = 9;
                        mines++;
                    }
                    else{
                        BOARD_CELLS[i][j] = -1;
                    }
                }
            }
            return 1;
        }



        public void countMines(int offX,int offY){
            int neighbor;
            int totalNeighbors=0;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int k,m;
                    k=offX+i;
                    m=offY+j;
                    if(k>-1 && k<BOARD_COLS && m>-1 && m<BOARD_ROWS) {
                        neighbor = BOARD_CELLS[k][m];
                        if (neighbor == 9) {
                            totalNeighbors++;
                        }
                    }
                }
            }
            NEIGHBORS_CELLS[offX][offY]=totalNeighbors;
        }


        public void revealMines(){
            for(int i=0;i<BOARD_ROWS;i++){
                for(int j=0;j<BOARD_COLS;j++){
                    REVEALED_CELLS[i][j]=1;
                }
            }
        }
        public void revealCell(int offX,int offY){
            int neighbor;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int k,m;
                    k=offX+i;
                    m=offY+j;
                    if(k>-1 && k<BOARD_COLS && m>-1 && m<BOARD_ROWS) {
                        neighbor = BOARD_CELLS[k][m];
                        if(neighbor != 9 && REVEALED_CELLS[offX+i][offY+j]==0) {
                            REVEALED_CELLS[offX+i][offY+j] = 1;
                        }
                    }
                }
            }
        }

        private class BoardEvents extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CELL_X = e.getX()/CELL_HEIGHT;
                CELL_Y = e.getY()/CELL_WIDTH;
                playing = true;

                if(BOARD_CELLS[CELL_X][CELL_Y]==9) {
                    System.out.println("mine clicked" + CELL_X + "->" + CELL_Y);
                    revealMines();
                }
                else {
                    countMines(CELL_X,CELL_Y);
                    revealCell(CELL_X,CELL_Y);
                }
                repaint();
            }
        }
        public void revealCells(Graphics g){
            Image[] img = new Image[15];
            var path10 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 10 + ".png";
            img[10] = (new ImageIcon(path10)).getImage();
            var path9 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 9 + ".png";
            img[9] = (new ImageIcon(path9)).getImage();
            var path0 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 0 + ".png";
            img[0] = (new ImageIcon(path0)).getImage();
            var path1 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 1 + ".png";
            img[1] = (new ImageIcon(path1)).getImage();
            var path2 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 2 + ".png";
            img[2] = (new ImageIcon(path2)).getImage();
            var path3 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 3 + ".png";
            img[3] = (new ImageIcon(path3)).getImage();
            var path4 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 4 + ".png";
            img[4] = (new ImageIcon(path4)).getImage();
            var path5 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 5 + ".png";
            img[5] = (new ImageIcon(path5)).getImage();
            var path6 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 6 + ".png";
            img[6] = (new ImageIcon(path6)).getImage();
            var path7 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 7 + ".png";
            img[7] = (new ImageIcon(path7)).getImage();
            var path8 = "/run/media/hacked/3AA82768A82721BD/TP-IHM-MASTER/src/assets/" + 8 + ".png";
            img[8] = (new ImageIcon(path8)).getImage();


            int cell;

            for(int i=0;i<BOARD_ROWS;i++){
                for(int j=0;j<BOARD_COLS;j++){
                    countMines(i,j);
                    cell=BOARD_CELLS[i][j];

                    if(REVEALED_CELLS[i][j] == 0) {
                        g.drawImage(img[10], CELL_WIDTH * i, CELL_WIDTH * j, CELL_WIDTH, CELL_HEIGHT, this);
                    }
                    else if(REVEALED_CELLS[i][j] == 1) {
                        if(cell == 9)
                            g.drawImage(img[9], CELL_WIDTH * i, CELL_WIDTH * j, CELL_WIDTH, CELL_HEIGHT, this);
                        else
                        g.drawImage(img[NEIGHBORS_CELLS[i][j]], CELL_WIDTH * i, CELL_WIDTH * j, CELL_WIDTH, CELL_HEIGHT, this);
                    }
                    }
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
                // initialize random mines
                if(!playing) {
                    randomMines();
                }
                revealCells(g);
            System.out.println(Arrays.deepToString(BOARD_CELLS));
            System.out.println(Arrays.deepToString(REVEALED_CELLS));

        }
    }
    }

