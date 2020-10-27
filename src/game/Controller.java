package game;


import javafx.scene.shape.Rectangle;

public class Controller {

    public static final int MOVE = Tetris.MOVE;
    public static final int SIZE = Tetris.SIZE;
    public static final int XMAX = Tetris.XMAX;
    public static final int YMAX = Tetris.YMAX;
    public static int[][] MESH = Tetris.MESH;


    public static void moveRight(Form form) {

        if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE
                && form.c.getX() + MOVE <= XMAX - SIZE && form.d.getX() + MOVE <= XMAX - SIZE) {

            int moveA = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
            int moveB = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
            int moveC = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
            int moveD = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];

            if (moveA == 0 && moveA == moveB && moveB == moveC && moveC == moveD) {
                form.a.setX(form.a.getX() + MOVE);
                form.b.setX(form.b.getX() + MOVE);
                form.c.setX(form.c.getX() + MOVE);
                form.d.setX(form.d.getX() + MOVE);
            }

        }

    }

    public static void moveLeft(Form form) {

        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0
                && form.c.getX() - MOVE >= 0 && form.d.getX() - MOVE >= 0) {

            int moveA = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveB = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveC = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveD = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];

            if (moveA == 0 && moveA == moveB && moveB == moveC && moveC == moveD) {
                form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);
            }

        }

    }

    public static Form createRectangles() {

        int block = (int) (Math.random() * 100); //*dodaje 2 miejsca po przecinku
        String name;
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1);
        Rectangle b = new Rectangle(SIZE - 1, SIZE - 1);
        Rectangle c = new Rectangle(SIZE - 1, SIZE - 1);
        Rectangle d = new Rectangle(SIZE - 1, SIZE - 1);

        if (block < 15) {
            //jesli math.random wylosuje liczbe mniejsa od 15 to bedzie ten blok:

            a.setX(XMAX / 2 - SIZE);     //125
            b.setX(XMAX / 2 - SIZE);    //25
            b.setY(SIZE);               //25
            c.setX(XMAX / 2);           //150
            c.setY(SIZE);               //25    [][][]
            d.setX(XMAX / 2 + SIZE);    //175   []
            d.setY(SIZE);               //25
            name = "slategrey";

            //jesli math.random wylosuje liczbe mniejsa od 30 to bedzie ten blok:
        } else if (block < 30) {

            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);               //[][][]
            c.setX(XMAX / 2);           //    []
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "darkgoldenrod";

        } else if (block < 45) {

            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            b.setX(XMAX / 2 - SIZE);
            //c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "indianred";

        } else if (block < 60) {

            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            b.setX(XMAX / 2);
            //c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "forestgreen";

        } else if (block < 75) {

            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            b.setX(XMAX / 2);
            //c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            //d.setY(SIZE);
            name = "cadetblue";

        } else if (block < 90) {

            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            b.setX(XMAX / 2 + SIZE);
            //c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "hotpink";

        } else {

            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            //c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            //d.setY(SIZE);
            name = "sandybrown";

        }
        return new Form(a, b, c, d, name);
    }
}