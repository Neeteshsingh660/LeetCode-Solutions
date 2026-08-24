/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer,TreeNode> h=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        h.put(-1,root);
        int p=0;
        while(!q.isEmpty())
        {
            TreeNode pq=q.poll();
            if(pq.left!=null)
            {
                q.add(pq.left);
                h.put(pq.left.val,pq);
            }
            if(pq.right!=null)
            {
                q.add(pq.right);
                h.put(pq.right.val,pq);
            }

        }
       // System.out.println(h);
        HashMap<Integer,Integer> hash=new HashMap<>();
        hash.put(target.val,1);
        Queue<TreeNode> a=new LinkedList<>();
        a.add(target);
        while(p!=k)
        {
           int size=a.size();
           for(int i=0;i<size;i++)
           {
            TreeNode l=a.poll();
            if(l.left!=null&&!hash.containsKey(l.left.val))
            {
                a.add(l.left);
                 hash.put(l.left.val,1);

            }
            if(l.right!=null&&!hash.containsKey(l.right.val))
            {
                a.add(l.right);
                hash.put(l.right.val,1);
            }
            if(h.containsKey(l.val)&&!hash.containsKey(h.get(l.val).val))
            {
               
                a.add(h.get(l.val));
                hash.put(h.get(l.val).val,1);
            }
           } 
           p++;
        
        }
        ArrayList<Integer> m=new ArrayList<>();
        while(!a.isEmpty())
        {
            m.add(a.poll().val);
        }
        System.out.println(m);
        return m;

    }
}