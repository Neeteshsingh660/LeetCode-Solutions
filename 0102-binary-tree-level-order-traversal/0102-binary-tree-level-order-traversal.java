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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
       
        Queue<TreeNode> q=new LinkedList<>();
       
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> l=new ArrayList<>();
            int level=q.size();
           
            for(int i=0;i<level;i++)
            {
                 TreeNode pq=q.poll();
                
                  if(pq.left!=null)
                  {
                    q.add(pq.left);
                  }
                  if(pq.right!=null)
                  {
                    q.add(pq.right);
                  }
             l.add(pq.val);
            }
            list.add(l);
        } 
        return list;  
    }
}