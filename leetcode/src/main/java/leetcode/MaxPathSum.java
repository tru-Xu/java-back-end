package leetcode;

import java.util.HashMap;

public class MaxPathSum {


     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public int maxPathSum(TreeNode root) {

        if(root == null) {
            return 0;
        }
        HashMap<TreeNode, Integer> leftRecord = new HashMap<>();
        HashMap<TreeNode, Integer> rightRecord = new HashMap<>();
        int len = getPathSum(root, leftRecord, rightRecord);
        int max = root.val;
        for(TreeNode key:leftRecord.keySet()) {
            int temp = key.val + leftRecord.get(key) + rightRecord.get(key);
            max = max > temp ? max : temp;
        }
        return max;
    }

    private int getPathSum(TreeNode root, HashMap<TreeNode, Integer> leftRecord, HashMap<TreeNode, Integer> rightRecord) {
        if(root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if(!leftRecord.containsKey(root)) {
            left = getPathSum(root.left, leftRecord, rightRecord);
            leftRecord.put(root, left);
        } else {
            left = leftRecord.get(root);
        }
        if(!rightRecord.containsKey(root)) {
            right = getPathSum(root.right, leftRecord, rightRecord);
            rightRecord.put(root, right);
        }else {
            right = rightRecord.get(root);
        }

        return root.val + (left > right ? left : right);

    }

    public static void main(String[] args) {
         MaxPathSum maxPathSum = new MaxPathSum();
         TreeNode root = maxPathSum.new TreeNode(1);
         TreeNode left = maxPathSum.new TreeNode(2);
         root.left = left;
         int max = maxPathSum.maxPathSum(root);
         System.out.println(max);
    }
}
