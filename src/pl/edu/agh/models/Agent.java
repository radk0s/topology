package pl.edu.agh.models;

import java.util.Map;

/**
 * Created by Radek on 2015-05-05.
 */
public interface Agent {
    Map<String, Agent> getSurroundingAgents();
}
