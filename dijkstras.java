package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class dijkstras {
    HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
    int[] vals;
    int[] parents;

    public void populate(int[][] pairs, int src, int count) {
        parents = new int[count];
        vals = new int[count];
        for (int[] i : pairs) {
            if (!map.containsKey(i[0])) {
                map.put(i[0], new ArrayList<>());
            }
            map.get(i[0]).add(new int[]{i[1], i[2]});
        }
        Arrays.fill(vals, Integer.MAX_VALUE);
        vals[src] = 0;
        dijkstra();
    }

    private void dijkstra() {
        HashSet<Integer> visited = new HashSet<>();
        int src = findmin(visited);
        while (src >= 0) {
            visited.add(src);
            int weight = vals[src];
            if (map.containsKey(src)) {
                for (int[] i : map.get(src)) {

                    int d = i[0];
                    int cost = i[1] + weight;
                    if (!visited.contains(d)) {
                        vals[d] = Math.min(vals[d], cost);
                        parents[d] = src;
                    }
                }
            }
            src = findmin(visited);
        }
    }

    private int findmin(HashSet<Integer> visited) {
        int min = Integer.MAX_VALUE;
        int po = -1;
        for (int i = 0; i < vals.length; i++) {
            if (!visited.contains(i) && vals[i] >= 0 && vals[i] < min) {
                po = i;
                min = vals[i];
            }
        }
        return po;
    }
}
