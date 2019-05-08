package leetcode;


import java.util.Stack;

public class SwapTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        int preValue = root.val;
        boolean isFirst = true;
        TreeNode preNode = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;
        while (p != null && !stack.isEmpty()) {
            if (p.left != null) {
                p = p.left;
                stack.push(p);
            } else {
                if (isFirst) {
                    preNode = p;
                    preValue = p.val;
                    isFirst = false;

                } else {
                    if (p.val > preValue) {
                        preValue = p.val;
                        preNode = p;
                    } else {

                        preNode.val = p.val;
                        p.val = preValue;

                        preNode = p;
                    }

                }

            }
            if (p.right != null) {
                p = p.right;
                stack.push(p);
            }
        }

    }
}
