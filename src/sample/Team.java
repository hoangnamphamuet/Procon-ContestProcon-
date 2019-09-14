package sample;

import java.util.ArrayList;

public class Team {
    private int teamID;
    private ArrayList <Agent> agents;
    private int titlePoint;
    private int areaPoint;

    public Team(int id, ArrayList<Agent> agents, int titlePoint, int areaPoint)
    {
        this.teamID = id;
        this.areaPoint = areaPoint;
        this.titlePoint = titlePoint;
        this.agents = agents;
    }
    public Team(Team team){
        this.teamID = team.getTeamID();
        this.agents = team.getAgents();
        this.titlePoint = team.getTitlePoint();
        this.areaPoint = team.getAreaPoint();
    }

    public void setAgents(ArrayList<Agent> agents) {
        this.agents = agents;
    }

    public void setAreaPoint(int areaPoint) {
        this.areaPoint = areaPoint;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public void setTitlePoint(int titlePoint) {
        this.titlePoint = titlePoint;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public int getAreaPoint() {
        return areaPoint;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getTitlePoint() {
        return titlePoint;
    }
}
