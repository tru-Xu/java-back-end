package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MergeKSort {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        ListNode[] pArr = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            pArr[i] = lists.get(i);
        }

        int nullNum = 0;
        while (nullNum < lists.size()) {
            nullNum = 0;
            boolean first = true;
            int minIndex = 0;
            int min = 0;
            for (int i = 0; i < lists.size(); i++) {
                if (pArr[i] != null) {
                    if (first || pArr[i].val < min) {
                        min = pArr[i].val;
                        minIndex = i;
                        first = false;
                    }
                } else {
                    nullNum++;
                }
            }
            if (!first) {
                p.next = pArr[minIndex];
                p = p.next;
                pArr[minIndex] = pArr[minIndex].next;
            }
        }
        return res.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        MergeKSort mergeKSort = new MergeKSort();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        mergeKSort.mergeKLists(list);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        stack.push(1);
        queue.poll();
        stack.pop();

    }
}
