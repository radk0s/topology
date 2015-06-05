package pl.edu.agh.topology;

import pl.edu.agh.topology.api.Agent;
import pl.edu.agh.topology.api.TopologyService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static TopologyService service;

    private static final int AGENTS_NUMBER = 12;

    public static void main(String[] args) {

        List<String> iDsList = new ArrayList<String>();

        for (int i = 0; i < AGENTS_NUMBER; ++i) {
            iDsList.add("agent_" + i);
        }

        List<Agent> agents = service.prepareTopology(iDsList);
        for (Agent agent : agents) {
            System.out.println(agent);
        }
    }
}
