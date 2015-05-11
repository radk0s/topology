package pl.edu.agh.topology;

import pl.edu.agh.models.Agent;
import java.util.List;

/**
 * Created by Radek on 2015-05-05.
 */
public interface TopologyService {
    List<Agent> prepareTopology(List<String> agentIDs);
}
