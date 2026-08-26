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
    int col;
    int row;
    TreeNode root;
    Pair(int c,int r,TreeNode t)
    {
        col=c;
        row=r;
        root=t;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> h=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,root));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int x=p.col;
            int y=p.row;
            TreeNode r=p.root;
            if(h.containsKey(x)==false)
            {
                h.put(x,new TreeMap<>());

            }
            if(h.get(x).containsKey(y)==false)
            {
                h.get(x).put(y,new PriorityQueue<>());
            }
            h.get(x).get(y).add(r.val);
           if(r.left!=null)
           {
            q.add(new Pair(x-1,y+1,r.left));
           }
            if(r.right!=null)
           {
            q.add(new Pair(x+1,y+1,r.right));
           }


        }
        System.out.println(h);
        List<List<Integer>> l=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> k:h.values())
        {
             List<Integer> list=new ArrayList<>();
            for(PriorityQueue<Integer> p:k.values())
            {
               
               while(!p.isEmpty())
               {
                list.add(p.poll());
               }
            }
             l.add(list);
        }
       return l;
    }
}