package sample;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Match {
    private ChessBoard chessBoard;
    private ArrayList<Team> teams;
    private int [][] tile;

    public Match( ChessBoard chessBoard, ArrayList<Team> teams, int [][] _tile)
    {
        this.tile = new int[chessBoard.getWidth()][chessBoard.getHeigh()];
        this.chessBoard = chessBoard;
        this.teams = teams;
        this.tile = _tile;
    }
    public Match(Match match){
        this.chessBoard = match.getChessBoard();
        this.tile = match.getTile();
        this.teams = match.getTeams();
    }
    public void drawMap(AnchorPane root)
    {
        Team team1, team2;
        team1 = new Team(this.teams.get(0));
        team2 = new Team(this.teams.get(1));

        int x = 0, y = 150;
        for(int i=0; i<chessBoard.getWidth(); i++)
        {
            x = 600;
            for(int j=0;j<chessBoard.getHeigh(); j++)
            {
                Text text = new Text(Integer.toString(chessBoard.getPoint()[i][j]));
                StackPane stack = new StackPane();
                stack.setLayoutX(x+50);
                stack.setLayoutY(y);

                if(this.tile[i][j] == team1.getTeamID())
                    chessBoard.setMapforTeam1(i,j);
                if(this.tile[i][j] == team2.getTeamID())
                    chessBoard.setMapforTem2(i,j);

                stack.getChildren().addAll(chessBoard.getMap()[i][j],text);
                root.getChildren().add(stack);
                x+=50;
            }
            y += 50;
        }
    }
    public void drawScore(AnchorPane root){
        StackPane stack1 = new StackPane();
        StackPane stack2 = new StackPane();
        StackPane stack3 = new StackPane();
        StackPane stack4 = new StackPane();
        StackPane stack5 = new StackPane();
        StackPane stack6 = new StackPane();

        stack1.setLayoutX(50);
        stack1.setLayoutY(50);
        Text teamId1 = new Text("Team: "+ Integer.toString(this.teams.get(0).getTeamID()));
        Text teamId2 = new Text("Team: " + Integer.toString(this.teams.get(1).getTeamID()));
        Text scoreTilePTeam1 = new Text("tile Point: "+Integer.toString(this.teams.get(0).getTitlePoint()));
        Text scoreTilePTeam2 = new Text("tile Point: "+Integer.toString(this.teams.get(1).getTitlePoint()));
        Text scoreAreaPTeam1 = new Text("Area Point: "+Integer.toString(this.teams.get(0).getAreaPoint()));
        Text scoreAreaPTeam2 = new Text("Area Point: "+Integer.toString(this.teams.get(1).getAreaPoint()));

        teamId1.setFont(Font.font("",20));
        teamId2.setFont(Font.font("",20));
        scoreTilePTeam1.setFont(Font.font("",20));
        scoreTilePTeam2.setFont(Font.font("",20));
        scoreAreaPTeam1.setFont(Font.font("",20));
        scoreAreaPTeam2.setFont(Font.font("",20));


        stack1.getChildren().add(teamId1);
        stack2.getChildren().add(teamId2);
        stack3.getChildren().add(scoreAreaPTeam1);
        stack4.getChildren().add(scoreAreaPTeam2);
        stack5.getChildren().add(scoreTilePTeam1);
        stack6.getChildren().add(scoreTilePTeam2);

        stack1.setLayoutX(20);
        stack1.setLayoutY(100);
        stack2.setLayoutX(1400);
        stack2.setLayoutY(100);
        stack3.setLayoutX(20);
        stack3.setLayoutY(200);
        stack4.setLayoutX(1400);
        stack4.setLayoutY(200);
        stack5.setLayoutX(20);
        stack5.setLayoutY(300);
        stack6.setLayoutX(1400);
        stack6.setLayoutY(300);

        root.getChildren().add(stack1);
        root.getChildren().add(stack2);
        root.getChildren().add(stack3);
        root.getChildren().add(stack4);
        root.getChildren().add(stack5);
        root.getChildren().add(stack6);
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public int[][] getTile() {
        return tile;
    }
}
