package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class kosaraju
{
    HashMap<Integer , ArrayList<Integer>> map;
    public void kosaraju(int[][] travels , int n)
    {
        map = buildadj(travels);
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0 ; i < n ; i++)
        {
            if(!visited.contains(i)) {
                dfss(i , visited , st);
            }
        }
        map = rev(travels);
        visited = new HashSet<>();
        while(!st.empty()) {
            int p = st.pop();
            if(!visited.contains(p)) {
                dfsp(p, visited);
            }
            System.out.println("\n");
        }
    }
    private HashMap<Integer, ArrayList<Integer>> rev(int[][] travels)
    {
        HashMap<Integer , ArrayList<Integer>> revm = new HashMap<>();
        for(int[] i : travels) {
            if(!revm.containsKey(i[1])) {
                revm.put(i[1] , new ArrayList<>());
            }
            revm.get(i[1]).add(i[0]);
        }
        return revm;
    }
    private void dfss(int i , HashSet<Integer> visited , Stack<Integer> st)
    {
        if(visited.contains(i)) {
            return;
        }
        visited.add(i);
        for(int v : map.getOrDefault(i,new ArrayList<>())) {
            dfss(v , visited , st);
        }
        st.push(i);
    }
    private void dfsp(int i , HashSet<Integer> visited)
    {
        if(visited.contains(i) ) {
            return;
        }
        visited.add(i);
        for(int v : map.getOrDefault(i,new ArrayList<>())) {
            dfsp(v , visited);
        }
        System.out.println(i+" ");
    }
    private HashMap<Integer,ArrayList<Integer>> buildadj(int[][] edges)
    {
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        for(int[] i : edges) {
            if(!map.containsKey(i[0])) {
                map.put(i[0] , new ArrayList<>());
            }
            map.get(i[0]).add(i[1]);
        }
        return map;
    }
}
