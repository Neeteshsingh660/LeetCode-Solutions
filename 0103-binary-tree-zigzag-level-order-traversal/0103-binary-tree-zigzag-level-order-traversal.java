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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
       
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int k=0;
        while(!q.isEmpty())
        {
            int level=q.size();
            List<Integer> arr=new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                TreeNode pq=q.remove();
                if(pq.left!=null)
                {
                    q.add(pq.left);
                }
                if(pq.right!=null)
                {
                    q.add(pq.right);
                }
                arr.add(pq.val);
            }
            if(k%2==1){
                Collections.reverse(arr);
                list.add(arr);
            }
            else{
                list.add(arr);
            }
            k++;
            
        }
        return list;
    }
}