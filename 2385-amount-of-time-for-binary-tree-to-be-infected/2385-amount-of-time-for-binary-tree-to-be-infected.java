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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,TreeNode> h=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode org=null;
        q.add(root);
        h.put(root.val,null);
        while(!q.isEmpty())
        {
            TreeNode p=q.poll();
            if(p.val==start)
            {
               org=p;
            }
            if(p.left!=null)
            {
               q.add(p.left);
               h.put(p.left.val,p);
            }
            if(p.right!=null)
            {
               q.add(p.right);
               h.put(p.right.val,p);
            }
        }
        System.out.println(h);
        HashMap<Integer,Boolean> hash=new HashMap<>();
       hash.put(org.val,true);
        Queue<TreeNode> u=new LinkedList<>();
        u.add(org);
        int c=0;
        while(!u.isEmpty())
        {
            c++;
            int n=u.size();
            for(int i=0;i<n;i++)
            {
                TreeNode a=u.poll();
                
                if(a.left!=null&&hash.containsKey(a.left.val)==false)
                {
                    u.add(a.left);
                    hash.put(a.left.val,true);
                    
                }
                if(a.right!=null&&hash.containsKey(a.right.val)==false)
                {
                      u.add(a.right);
                      hash.put(a.right.val,true);
                }
                if(h.get(a.val)!=null&&hash.containsKey(h.get(a.val).val)==false)
                {
                    u.add(h.get(a.val));
                    hash.put(h.get(a.val).val,true);
                }
                
            }
            
        }

        return c-1;
    }
}