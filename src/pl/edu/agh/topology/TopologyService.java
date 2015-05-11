package pl.edu.agh.topology;

import pl.edu.agh.models.Agent;
import pl.edu.agh.models.AgentImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Radek on 2015-05-05.
 */
public abstract class TopologyService {
    public abstract List<Agent> prepareTopology(List<String> agentIDs);

    public ArrayList<Agent> createAgents(List<String> agentIDs) {
        ArrayList<Agent> agentsList = new ArrayList<Agent>();
        for(String id: agentIDs){
            agentsList.add(new AgentImpl(id));
        }
        return agentsList;
    }
}
