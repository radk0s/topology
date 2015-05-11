package pl.edu.agh;


import pl.edu.agh.models.Agent;
import pl.edu.agh.topology.ThorusTopologyService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int AGENTS_NUMBER = 12;

    public static void main(String[] args) {

        ArrayList<String> iDsList = new ArrayList<String>();

        for (int i = 0; i < AGENTS_NUMBER; ++i){
            iDsList.add("agent_" + i);
        }

        CircularTopologyService circularTopologyService = new CircularTopologyService();
        List<Agent> agents = circularTopologyService.prepareTopology(iDsList);
        for (Agent agent: agents){
            System.out.println(agent);
        }

        ThorusTopologyService thorusTopologyService = new ThorusTopologyService();
        agents = thorusTopologyService.prepareTopology(iDsList);
        for (Agent agent: agents){
            System.out.println(agent);
        }
    }
}

//diagram klas UML, sekwencje
