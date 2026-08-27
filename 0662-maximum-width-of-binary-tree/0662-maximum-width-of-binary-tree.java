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
 class Pair{
    TreeNode root;
    int ind;
    Pair(TreeNode r,int i){
        root=r;
        ind=i;

    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int max=0;
        while(!q.isEmpty())
        {
            int first=0;
            int last=0;
            int n=q.size();
            int min=q.peek().ind;
            for(int i=0;i<n;i++)
            {
                Pair p=q.poll();
                TreeNode l=p.root;
                int k=p.ind-min;
                if(i==0) first=k;
                if(i==n-1) last=k;
                if(l.left!=null)
                {
                    q.add(new Pair(l.left,2*k+1));
                }
                if(l.right!=null)
                {
                    q.add(new Pair(l.right,2*k+2));
                }
            }
           max=Math.max(max,last-first+1);
        }

      return max;  
    }
}