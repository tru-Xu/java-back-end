package leetcode;

import java.util.*;


public class FindLadders {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        dict.add(end);
        HashMap<String, Integer> dis = new HashMap<>();
        dis.put(start, 1);
        boolean find = false;
        while(!queue.isEmpty()) {
            int count = queue.size();

            for(int i = 0; i < count; i++) {
                String cur = queue.poll();
                ArrayList<String> nextString = getNext(cur, dict);
                for(String s : nextString) {
                    if(s.equals(end)) {
                        find = true;
                        dis.put(s, dis.get(cur) + 1);
                    }
                    if(!dis.containsKey(s)) {
                        dis.put(s, dis.get(cur) + 1);
                        queue.offer(s);
                    }
                }
            }
            if(find) break;

        }
        if(find) {
            return dis.get(end);
        }else {
            return 0;
        }

    }

    private ArrayList<String> getNext(String cur, HashSet<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] charArray = cur.toCharArray();
        for (int i = 0; i < cur.length(); i++) {
            char old = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if(old == c) {
                    continue;
                }
                charArray[i] = c;
                String temp = String.valueOf(charArray);
                if(dict.contains(temp)) {
                    res.add(temp);
                }
            }
            old = charArray[i];
        }
        return res;
    }

    public static void main(String[] args) {

        FindLadders findLadders = new FindLadders();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result.clear();;
        String start = "hot";
        String end = "dog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
//        dict.add("lot");
//        dict.add("log");
        int len = findLadders.ladderLength(start, end, dict);
        System.out.println(len);

        String sub = "";
        char a = 'c';
        sub = sub+a;
        sub.toLowerCase();
    }
}
