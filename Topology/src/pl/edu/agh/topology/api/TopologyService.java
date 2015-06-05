package pl.edu.agh.topology.api;

import pl.edu.agh.topology.impl.AgentImpl;

import java.util.ArrayList;
import java.util.List;

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
