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
    public TreeNode reverseOddLevels(TreeNode root){
        reverse(root.left, root.right, 1);
        return root;
    }

    private void reverse(TreeNode left, TreeNode right, int level){
        if(left == null ||  right == null) return;
        if(level%2 == 1){
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }
        reverse(left.left, right.right, level + 1);
        reverse(left.right, right.left, level + 1);
    }
}