package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class Agent {
    public static String sourceFlag = "/image/90-52.png";
    private int id;
    private int x;
    private int y;

    public Agent(int _id, int _x, int _y){
        this.id = _id;
        this.x = _x;
        this.y = _y;
    }

    public void drawAgent(AnchorPane root)
    {
        Image image = new Image(sourceFlag);
        ImageView view = new ImageView(image);
        root.getChildren().add(view);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
