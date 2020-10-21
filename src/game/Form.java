package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {

    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;
    public Color color;
    public String name;
    public int form = 1;

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;


        switch (name) {
            case "slategrey":
                color = Color.SLATEGRAY;
                break;
            case "darkgoldenrod":
                color = Color.DARKGOLDENROD;
                break;
            case "indianred":
                color = Color.INDIANRED;
                break;
            case "forestgreen":
                color = Color.FORESTGREEN;
                break;
            case "cadetblue":
                color = Color.CADETBLUE;
                break;
            case "hotpink":
                color = Color.HOTPINK;
                break;
            case "sandybrown":
                color = Color.SANDYBROWN;
                break;
        }

        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);

    }

    public String getName() {
        return name;
    }

    public void changeFormOfBlocks() {

        if (form != 4) {
            form++;
        } else {
            form = 1;
        }

    }
}
