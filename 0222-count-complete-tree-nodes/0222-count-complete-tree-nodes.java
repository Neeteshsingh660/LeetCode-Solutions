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
    public int countNodes(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int left=leftheight(root);
        int right=rightheight(root);
        if(left==right) return (int)Math.pow(2,left)-1;
        return countNodes(root.left)+countNodes(root.right)+1;

        
    }
    public int leftheight(TreeNode root)
    {
        TreeNode curr=root.left;
        int c=1; //Start counting from that node only
        while(curr!=null)
        {
          c++;
          curr=curr.left;
        }
        return c;
    }
    public int rightheight(TreeNode root)
    {
        TreeNode curr=root.right;
        int c=1;    //Start counting from that node only
        while(curr!=null)
        {
          c++;
          curr=curr.right;
        }
        return c;
    }
}