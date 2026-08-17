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
    public int diameterOfBinaryTree(TreeNode root) {
        int sum[]=new int[1];
        diameter(root,sum);
       return sum[0];
      
    }
    public int diameter(TreeNode root,int []sum)//Take array bcz in java para is passed by value and refernce for array it is ref and for val it is by value
    {
        if(root==null)
        {
            return 0;
        }
        int left=diameter(root.left,sum);
        int right=diameter(root.right,sum);
        sum[0]=Math.max(sum[0],left+right);
        return Math.max(left,right)+1;

    }
}