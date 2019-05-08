package leetcode;

import java.util.*;

public class MergeIntervals {


    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        //queue.poll()
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
    }
}
