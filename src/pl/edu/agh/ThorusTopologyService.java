package pl.edu.agh;

import pl.edu.agh.models.Agent;
import pl.edu.agh.models.AgentImpl;
import pl.edu.agh.topology.TopologyService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Radek on 2015-05-05.
 */
public class ThorusTopologyService implements TopologyService {
    @Override
    public List<Agent> prepareTopology(List<String> agentIDs) {
        ArrayList<Agent> agentsList = createAgents(agentIDs);
        for(int i = 0; i < agentsList.size(); ++i){
            HashMap<String, Agent> agentNeighbours = new HashMap<String, Agent>();
            agentNeighbours.put("right", agentsList.get(i < agentsList.size() - 1 ? i + 1: 0));
            agentsList.get(i).setSurroundingAgents(agentNeighbours);
        }
        return agentsList;
    }

    private ArrayList<Agent> createAgents(List<String> agentIDs) {
        ArrayList<Agent> agentsList = new ArrayList<Agent>();
        for(String id: agentIDs){
            agentsList.add(new AgentImpl(id));
        }
        return agentsList;
    }
}
