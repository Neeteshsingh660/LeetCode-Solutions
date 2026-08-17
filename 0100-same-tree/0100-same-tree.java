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
    public boolean isSameTree(TreeNode p, TreeNode q) {
     int a=inorder(p,q);
     return a==-1?false:true;
    }
    public int inorder(TreeNode p, TreeNode q)
    {
        if(p==null&&q!=null||p!=null&&q==null)
        {
            return -1;
        }
        if(p==null&&q==null) return 0;
        int left=inorder(p.left,q.left);
        if(left==-1) return -1;
        if(p.val!=q.val)
        {
             return -1;
        }
       int right=inorder(p.right,q.right);
       if(right==-1) return -1;
       return 0;
        
    }
}