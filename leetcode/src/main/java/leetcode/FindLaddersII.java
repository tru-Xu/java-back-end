package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class FindLaddersII {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, ArrayList<String>> hashNeighbor = new HashMap<>();
        HashMap<String, Integer> dis = new HashMap<>();
        if(dict.size() == 0) {
            return result;
        }

        dict.add(start);
        dict.add(end);
        bfs(start, end, dict, hashNeighbor, dis);
        dfs(start, end, hashNeighbor, dis, list, result);
        return result;

    }

    private void bfs(String start, String end, HashSet<String> dict,
                     HashMap<String, ArrayList<String>> hashNeighbor, HashMap<String, Integer> dis){
        for(String s : dict) {
            hashNeighbor.put(s, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        boolean find = false;
        queue.offer(start);
        dis.put(start, 0);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                String cur = queue.poll();
                ArrayList<String> neighbors = getNeighbors(cur, dict);
                hashNeighbor.put(cur, neighbors);
                for(String s : neighbors) {
                    if(!dis.containsKey(s)) {
                        dis.put(s, dis.get(cur) + 1);
                        if(end.equals(s)) {
                            find = true;
                        } else {
                            queue.offer(s);
                        }
                    }
                }
            }
            if(find) {
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String cur, HashSet<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] charArr = cur.toCharArray();
        int count = cur.length();
        for(int i = 0; i < count; i++){
            char old = charArr[i];
            for (char c = 'com.aily.bean'; c <= 'z'; c++) {
                if(old == c) {
                    continue;
                }
                charArr[i] = c;
                String temp = String.valueOf(charArr);
                if(dict.contains(temp)) {
                    res.add(temp);
                }
            }
            charArr[i] = old;
        }
        return res;
    }

    private void dfs(String start, String end, HashMap<String, ArrayList<String>> hashNeighbor,
                     HashMap<String, Integer> dis, ArrayList<String> list, ArrayList<ArrayList<String>> result) {
        list.add(start);
        if(start.equals(end)) {
            result.add(new ArrayList<>(list));
        } else {
            for(String s : hashNeighbor.get(start)) {
                if(dis.get(s) == dis.get(start) + 1) {
                    dfs(s, end, hashNeighbor, dis, list, result);
                }
            }
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {

        FindLaddersII findLadders = new FindLaddersII();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        String start = "com.aily.bean";
        String end = "c";
        HashSet<String> dict = new HashSet<>();
        dict.add("com.aily.bean");
        dict.add("b");
        dict.add("c");
//        dict.add("lot");
//        dict.add("log");
        result = findLadders.findLadders(start, end, dict);
        System.out.println(result);
    }
}
