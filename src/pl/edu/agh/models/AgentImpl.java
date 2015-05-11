package pl.edu.agh.models;

import java.util.Map;

/**
 * Created by bj on 11.05.15.
 */
public class AgentImpl implements Agent {


    private Map<String, Agent> surroundingAgents;
    private String id;


    public AgentImpl(String id) {
        this.id = id;
    }

    @Override
    public Map<String, Agent> getSurroundingAgents() {
        return surroundingAgents;
    }

    @Override
    public void setSurroundingAgents(Map<String, Agent> surroundingAgents) {
        this.surroundingAgents = surroundingAgents;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " {" +
                "surroundingAgents = " + printSurroundingAgents() +
                '}';
    }

    private String printSurroundingAgents() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.getSurroundingAgents() != null){
            for(String dir: this.getSurroundingAgents().keySet()){
                stringBuilder.append("(" + dir + ", " + this.getSurroundingAgents().get(dir).getId() + "),");
            }
        }
        return stringBuilder.toString();
    }
}
