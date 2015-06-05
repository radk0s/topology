package pl.edu.agh.topology;

import pl.edu.agh.topology.api.Agent;
import pl.edu.agh.topology.api.TopologyService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bj on 11.05.15.
 */
public class ThorusTopology extends TopologyService {
    @Override
    public List<Agent> prepareTopology(List<String> agentIDs) {
        ArrayList<Agent> agentsList = createAgents(agentIDs);
        int length = findMeshLength(agentIDs.size());
        int height = agentIDs.size() / length;
        System.out.println("size: " + agentIDs.size() + ", length: " + length + ", height: " + height);
        for (int h = 0; h < height; ++h) {
            for (int l = 0; l < length; ++l){
                int agentNum = h * length + l;
                //System.out.println("h: " + h + ", l: " + l + " agent: " + agentNum);
                if(h == 0){
                    if (l == 0){
                        putSurroundingAgents(agentsList, agentNum, length - 1, 1, length * (height - 1), length);
                    } else if (l == length - 1){
                        putSurroundingAgents(agentsList, agentNum, length - 2, 0, length * height - 1, length * 2 - 1);
                    } else {
                        putSurroundingAgents(agentsList, agentNum, agentNum - 1, agentNum + 1, length * (height - 1) + agentNum, agentNum + length);
                    }
                } else if (h == height - 1){
                    if (l == 0){
                        putSurroundingAgents(agentsList, agentNum, length * height - 1, agentNum + 1, length * (height - 2), 0);
                    } else if (l == length - 1){
                        putSurroundingAgents(agentsList, agentNum, agentNum - 1, length * (height - 1), length * (height - 1) - 1, length - 1);
                    } else {
                        putSurroundingAgents(agentsList, agentNum, agentNum - 1, agentNum + 1, length * (height - 2) + l, l);
                    }
                } else {
                    if (l == 0){
                        putSurroundingAgents(agentsList, agentNum, agentNum + length - 1, agentNum + 1, (h - 1) * l + l, (h + 1) * length);
                    } else if (l == length - 1){
                        putSurroundingAgents(agentsList, agentNum, agentNum - 1, agentNum - length + 1, (h - 1) * l + l, agentNum + length);
                    } else {
                        putSurroundingAgents(agentsList, agentNum, agentNum - 1, agentNum + 1, agentNum - length, agentNum + length);
                    }
                }
            }
        }
        return agentsList;
    }

    private void putSurroundingAgents(ArrayList<Agent> agentsList, int agentNum, int left, int right, int up, int down) {
        HashMap<String, Agent> agentNeighbours = new HashMap<String, Agent>();
        agentNeighbours.put("left", agentsList.get(left));
        agentNeighbours.put("right", agentsList.get(right));
        agentNeighbours.put("up", agentsList.get(up));
        agentNeighbours.put("down", agentsList.get(down));
        agentsList.get(agentNum).setSurroundingAgents(agentNeighbours);
    }


    private int findMeshLength(int size) {
        int length = size / 3;
        while (!(size % length == 0)){
            --length;
        }
        return length;
    }
}
