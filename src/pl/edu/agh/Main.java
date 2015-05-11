package pl.edu.agh;


import pl.edu.agh.models.Agent;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int AGENTS_NUMBER = 5;

    public static void main(String[] args) {

        ArrayList<String> iDsList = new ArrayList<String>();

        for (int i = 0; i < AGENTS_NUMBER; ++i){
            iDsList.add("agent_" + i);
        }

        ThorusTopologyService topologyService = new ThorusTopologyService();
        List<Agent> agents = topologyService.prepareTopology(iDsList);
        for (Agent agent: agents){
            System.out.println(agent);
        }
    }
}

//diagram klas UML, sekwencje
