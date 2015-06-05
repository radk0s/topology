package pl.edu.agh.topology.api;

import java.util.Map;

public interface Agent {
    Map<String, Agent> getSurroundingAgents();
    void setSurroundingAgents(Map<String, Agent> neighbours);
    String getId();
}
