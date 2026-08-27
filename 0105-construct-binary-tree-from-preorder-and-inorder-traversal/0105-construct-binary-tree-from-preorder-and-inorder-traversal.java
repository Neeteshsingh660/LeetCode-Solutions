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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            h.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,h);
        
    }
    public TreeNode build(int []pre,int ps,int pe,int []in,int is,int ie,HashMap<Integer,Integer> h)
    {
        if(is>ie||ps>pe)
        {
            return null;
        }
        TreeNode a=new TreeNode(pre[ps]);
        int indexOfIn=h.get(a.val);
        int mid=indexOfIn-is;
       a.left= build(pre,ps+1,ps+mid,in,is,indexOfIn-1,h);
       a.right=build(pre,ps+mid+1,pe,in,indexOfIn+1,ie,h);
       return a;
    }
}