package com.company;

import java.util.*;

public class kruskals
{
    HashMap<Integer , ArrayList<int[]>> map = new HashMap<>();
    int[] vals;
    int[] parents;
    int[] ranks;
    public void populate(int[][] pairs , int nodes)
    {
        PriorityQueue<int[]> vertices = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        vals = new int[nodes];
        parents = new int[nodes];
        ranks = new int[nodes];
        for(int i = 0 ; i < parents.length ; i ++) {
            parents[i] = i;
        }
        vertices.addAll(Arrays.asList(pairs));
        kruskals(vertices);
    }

    public void kruskals(PriorityQueue<int[] > q )
    {
        while(!q.isEmpty()) {
            int[] p = q.poll();
            if(union(p[0] , p[1])) {
                System.out.println(Arrays.toString(p));
                vals[p[1]] = p[2];
            }
        }
    }
    public int root(int val)
    {
        if(parents[val] == val) {
            return val;
        }
        return root(parents[val]);
    }
    public boolean union(int src , int dest)
    {
        int roots = root(src);
        int rootd = root(dest);
        if(roots == rootd) {
            return false;
        }
        if(ranks[rootd] > ranks[roots]) {
            ranks[rootd]++;
            parents[roots] = rootd;
        }
        else {
            ranks[roots]++;
            parents[rootd] = roots;
        }
        return true;
    }
}
