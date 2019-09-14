package sample;

import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Arrays;

public class ChessBoard {
    public static final String url = "/image/square.png";
    private int width;
    private int heigh;

    private int point[][] = null;
    private Rectangle [][] map;

    public ChessBoard(int _width, int _height, int [][] _points)
    {
        this.width = _width;
        this.heigh = _height;
        point = new int[_width][_height];
        this.map = new Rectangle[_width][_height];

        for(int i = 0; i<width; i++)
        {
            for(int j=0; j<heigh; j++) {
                this.point[i][j] = _points[i][j];
            }
        }
        for(int i=0; i<width; i++)
        {
            for(int j=0; j<heigh; j++)
            {
                map[i][j] = new Rectangle(50,50, Color.WHITE);
                map[i][j].setStroke(Color.BLACK);
            }
        }

    }

    public void drawChessBoard(AnchorPane root)
    {
       int x = 0, y = 0;
       for(int i=0; i<width; i++)
        {
            x = 0;
            for(int j=0;j<heigh; j++)
            {
                Text text = new Text(Integer.toString(this.point[i][j]));
                StackPane stack = new StackPane();
                stack.setLayoutX(x+50);
                stack.setLayoutY(y);
                stack.getChildren().addAll(map[i][j],text);

                root.getChildren().add(stack);
                x+=50;
            }
            y += 50;
        }
    }

    public int getHeigh() {
        return heigh;
    }

    public int getWidth() {
        return width;
    }

    public int[][] getPoint() {
        return point;
    }

    public Rectangle[][] getMap() {
        return map;
    }

    public void setMapforTeam1(int i, int j) {
        this.map[i][j].setFill(Color.AQUA);
    }

    public void setMapforTem2(int i, int j) {
        this.map[i][j].setFill(Color.YELLOW);
    }
}




