package sample;

import javafx.scene.layout.AnchorPane;

public class PlayGame {
   public static void play(AnchorPane pane){
       Match match = Input.ReadFileInput();
       match.drawMap(pane);
       match.drawScore(pane);
   }
}
