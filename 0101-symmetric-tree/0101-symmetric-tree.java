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
    public boolean isSymmetric(TreeNode root) {
        return Symmetric(root.left,root.right);
    }
    public boolean Symmetric(TreeNode q,TreeNode p)
    {
        if(p==null||q==null)
        {
            return p==q;
        }
        boolean left=(p.val==q.val)&&Symmetric(q.left,p.right);
        boolean right=(p.val==q.val)&&Symmetric(q.right,p.left);
        return left&&right;
    }
}