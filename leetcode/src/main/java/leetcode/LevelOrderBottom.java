package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderBottom {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<ArrayList<Integer>> res = new Stack<>();
        Queue<TreeNode> qTree = new LinkedList<>();
        if (root == null) return result;
        qTree.offer(root);
        while (!qTree.isEmpty()) {
            ArrayList<TreeNode> treeList = new ArrayList<>();
            for (int i = 0; i < qTree.size(); i++) {
                TreeNode pTree = qTree.poll();
                treeList.add(pTree);
            }
            ArrayList<Integer> tempList = new ArrayList<>();
            for (TreeNode tNode : treeList) {
                tempList.add(tNode.val);
                if (tNode.left != null) {
                    qTree.offer(tNode.left);
                }
                if (tNode.right != null) {
                    qTree.offer(tNode.right);
                }
            }

            res.push(tempList);
        }

        for (int i = 0; i < res.size(); i++) {
            result.add(res.pop());
        }
        //while(!res.isEmpty()) result.add(res.pop());

        return result;
    }

    public static void main(String[] args) {
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        TreeNode root = levelOrderBottom.new TreeNode(1);
        TreeNode left = levelOrderBottom.new TreeNode(2);
        root.left = left;
        int a;
        try {
            char b = (char) System.in.read();
            System.out.println(b);
        }catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<Integer>> res = levelOrderBottom.levelOrderBottom(root);
        //System.out.println(res);
    }
}
