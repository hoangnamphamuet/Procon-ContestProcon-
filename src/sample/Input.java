package sample;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
public class Input {

    public static Match ReadFileInput(){
        /**
         *  doc file json lay dau vao
         */
        String source = "src/maps/A-1.json";
        try{
            String contens = new String(Files.readAllBytes(Paths.get(source)));
            JSONObject object = new JSONObject(contens);
            JSONArray array = object.getJSONArray("points");

            int width, height;
            width = object.getInt("width");
            height = object.getInt("height");
            /**
             * lay ban co
             */
            int [][] maps = new int [array.length()][];
            for(int i=0; i<array.length(); i++){
                JSONArray innerOfArray = (JSONArray) array.get(i);
                int [] stringArray;// = new String[innerOfArray.length()];
                stringArray = new int [innerOfArray.length()];
                for(int j = 0; j<innerOfArray.length(); j++)
                {
                    stringArray[j] = (int) innerOfArray.get(j);
                }
                maps[i] = stringArray;
            }

            ChessBoard board = new ChessBoard(width, height, maps);
            /**
             * lay thong tin title
             */
            JSONArray tileOfJSON = object.getJSONArray("tiled");
            int [][] tile = new int [tileOfJSON.length()][];

            for(int i=0; i<tileOfJSON.length(); i++){
                JSONArray innerOfArray = (JSONArray) tileOfJSON.get(i);
                int [] stringArray;// = new String[innerOfArray.length()];
                stringArray = new int [innerOfArray.length()];
                for(int j = 0; j<innerOfArray.length(); j++)
                {
                    stringArray[j] = (int) innerOfArray.get(j);
                }
                tile[i] = stringArray;
            }
            /**
             * phan lay thong tin team
             */
            JSONArray teams = object.getJSONArray("teams");
            ArrayList<Team> tmpTeam = new ArrayList<>();
            for(int i=0; i<teams.length(); i++) {
                JSONObject tmpObject = teams.getJSONObject(i);
                int teamID, titlePoint, areaPoint;
                teamID = tmpObject.getInt("teamID");
                titlePoint = tmpObject.getInt("tilePoint");
                areaPoint = tmpObject.getInt("areaPoint");

                ArrayList<Agent> agents = new ArrayList<>();
                JSONArray agentsOfJson = tmpObject.getJSONArray("agents");

                for (int j = 0; j < agentsOfJson.length(); j++) {
                    int agentID, x, y;
                    agentID = agentsOfJson.getJSONObject(i).getInt("agentID");
                    x = agentsOfJson.getJSONObject(i).getInt("x");
                    y = agentsOfJson.getJSONObject(i).getInt("y");

                    Agent agent = new Agent(agentID, x, y);
                    agents.add(agent);
                }
                Team newTeam = new Team(teamID, agents, titlePoint, areaPoint);
                System.out.println(newTeam.getTitlePoint());
                tmpTeam.add(newTeam);

            }

            /**
             * cho thong tin vao trong match
             */
            Match match = new Match(board,tmpTeam,tile);
            return match;
        }
        catch (IOException e){
            System.out.println(e);
        }


        return null;
    }

}
