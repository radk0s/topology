package pl.edu.agh;

import pl.edu.agh.models.Agent;
import pl.edu.agh.topology.TopologyService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Radek on 2015-05-05.
 */
public class CircularTopologyService extends TopologyService {
    @Override
    public List<Agent> prepareTopology(List<String> agentIDs) {
        ArrayList<Agent> agentsList = createAgents(agentIDs);
        for (int i = 0; i < agentsList.size(); ++i) {
            HashMap<String, Agent> agentNeighbours = new HashMap<String, Agent>();
            agentNeighbours.put("left", agentsList.get(i > 0 ? i - 1 : agentsList.size() - 1));
            agentNeighbours.put("right", agentsList.get(i < agentsList.size() - 1 ? i + 1 : 0));
            agentsList.get(i).setSurroundingAgents(agentNeighbours);
        }
        return agentsList;
    }
}

