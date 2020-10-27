package game;


import com.sun.jdi.ArrayReference;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import java.util.*;

public class Tetris extends Application {

    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane group = new Pane();
    private static Form object;
    private static Form nextObj;
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    public static int top = 0;
    private static boolean game = true;
    //private static Form nextObj = Controller.createRectangles();
    private static int linesNo = 0;

    @Override
    public void start(Stage stage) throws Exception {

        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoreText = new Text("SCORE: ");
        scoreText.setStyle("-fx-font: 20 arial;");
        scoreText.setY(50);
        scoreText.setX(XMAX + 5);
        scoreText.setFill(Color.FORESTGREEN);

        Text level = new Text("LINES: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoreText, line, level);

        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        object = a;
        nextObj = Controller.createRectangles();
        stage.setScene(scene);
        stage.setTitle("[T][E][T][R][I][S]");
        stage.show();

        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (object.a.getY() == 0 || object.b.getY() == 0 ||
                                object.c.getY() == 0 || object.d.getY() == 0)
                            top++;
                        else
                            top = 0;
                        if (top == 2) {
                            Text gameOver = new Text("[G][A][M][E] [O][V][E][R]");
                            gameOver.setFill(Color.RED);
                            gameOver.setStyle("-fx-font: 60 arial;");
                            gameOver.setY(250);
                            gameOver.setX(10);
                            group.getChildren().add(gameOver);
                            game = false;
                        }
                        if (top == 15) {
                            System.exit(0);
                        }
                        if (game) {
                            MoveDown(object);
                            scoreText.setText("SCORE: " + Integer.toString(score));
                            level.setText("LEVEL: " + Integer.toString(linesNo));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);

    }

    private void moveOnKeyPress(Form form) {

        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {

                case RIGHT:
                    Controller.moveRight(form);
                    break;

                case DOWN:
                    MoveDown(form);
                    score++;
                    break;
                case LEFT:
                    Controller.moveLeft(form);
                    break;

                case UP:
                    MoveTurn(form);
                    break;

            }

        });
    }

    private void MoveTurn(Form form) {
        int f = form.form;
        Rectangle a = form.a;
        Rectangle b = form.b;
        Rectangle c = form.c;
        Rectangle d = form.d;

        switch (form.getName()) {
            case "slategrey":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }

            case "darkgoldenrod":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }

            case "indianred":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
            case "forestgreen":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
            case "cadetblue":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
            case "indianred":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
            case "hotpink":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
            case "sandybrown":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 3 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                if (f == 4 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeFormOfBlocks();
                    break;
                }
                break;

        }
    }

    private void removeCompleteRows(Pane pane) {

        ArrayList<Node> rects = new ArrayList<>();
        ArrayList<Integer> lines = new ArrayList<>();
        ArrayList<Node> newRects = new ArrayList<>();
        int full = 0;

        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1)
                    full++;
            }
            if (full == MESH.length)
                lines.add(i + lines.size());
            full = 0;
        }
        if (lines.size() > 0)
            do {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                score = score + 50;
                linesNo++;

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);

                    } else
                        newRects.add(node);
                }

                for (Node node : newRects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }

                    lines.remove(0);
                    rects.clear();
                    newRects.clear();

                    for (Node node : pane.getChildren()) {
                        if (node instanceof Rectangle)
                            rects.add(node);
                    }

                    for (Node node : rects) {
                        Rectangle a = (Rectangle) node;
                        try {
                            MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("error");
                        }
                    }
                    rects.clear();
                }
            }
            } while (lines.size() > 0) ;

    }


        private boolean cB (Rectangle rectangle,int x, int y){
            boolean yb = false;
            boolean xb = false;

            if (x >= 0)
                xb = rectangle.getX() + x * MOVE <= XMAX - SIZE;

            if (x < 0)
                xb = rectangle.getX() + x * MOVE >= 0;

            if (x >= 0)
                yb = rectangle.getY() + y * MOVE > 0;

            if (x >= 0)
                yb = rectangle.getY() + y * MOVE < YMAX;
            return xb && yb && MESH[((int) rectangle.getX() / SIZE) + x][((int) rectangle.getY() / SIZE) - y] == 0;
        }



    public static void main(String[] args) {
        launch(args);
    }
}
