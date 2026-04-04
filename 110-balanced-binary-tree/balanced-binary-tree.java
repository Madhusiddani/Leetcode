/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode rootNode) {
        return calculateHeight(rootNode) != -1;
    }

    private int calculateHeight(TreeNode currentNode) {
        if (currentNode == null) return 0;

        int leftSubtreeHeight = calculateHeight(currentNode.left);
        if (leftSubtreeHeight == -1) return -1;

        int rightSubtreeHeight = calculateHeight(currentNode.right);
        if (rightSubtreeHeight == -1) return -1;

        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}