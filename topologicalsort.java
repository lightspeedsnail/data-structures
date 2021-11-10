package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class topologicalsort
{
    HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Integer> toposorted = new ArrayList<>();
    public void populate(int[][] pairs)
    {
        for(int[] i : pairs) {
            if(!map.containsKey(i[0])) {
                map.put(i[0] , new ArrayList<>());
            }
            map.get(i[0]).add(i[1]);
        }
        HashSet<Integer> visited = new HashSet<>();
        for(int i : map.keySet()) {
            topologcal( i, visited);
        }
    }
    public void topologcal(int src , HashSet<Integer> visited)
    {
        if(visited.contains(src)) {
            return;
        }
        if(!map.containsKey(src)) {
            visited.add(src);
            toposorted.add(0,src);
            return;
        }
        visited.add(src);
        for(int i : map.get(src)) {
            topologcal(i , visited);
        }
        toposorted.add(0,src);
    }
}
