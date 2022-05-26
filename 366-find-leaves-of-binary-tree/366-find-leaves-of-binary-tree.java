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
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList();
        getHeight(root);
        return res;
    }
    
    public int getHeight(TreeNode root){
        if(root==null) return -1;
        int height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        if(res.size() == height){
            res.add(new ArrayList());
        }
        res.get(height).add(root.val);
        return height;
    }
}