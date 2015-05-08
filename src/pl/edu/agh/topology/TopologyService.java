package pl.edu.agh.topology;

import pl.edu.agh.models.Agent;
import java.util.List;

/**
 * Created by Radek on 2015-05-05.
 */
abstract class TopologyService {
    abstract public List<Agent> prepareTopology(List<String> agentIDs);
}
