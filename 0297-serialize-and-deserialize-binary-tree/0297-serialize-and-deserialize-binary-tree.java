/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        StringBuilder s=new StringBuilder("");
        while(!q.isEmpty())
        {
            TreeNode n=q.poll();
            if(n==null)
            {
                s.append("#,");
                continue;
            }
            s.append(n.val).append(",");
            q.add(n.left);
            q.add(n.right);
        }
       
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#,")||data.length()==0)
        {
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        String []arr=data.split(",");
     
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
         q.add(root);
        for(int i=1;i<arr.length;i++)
        {
            TreeNode p=q.poll();
            if(!arr[i].equals("#"))
            {
                TreeNode n=new TreeNode(Integer.parseInt(arr[i]));
                p.left=n;
                q.add(n);

            }
            if(i+1<arr.length&&!arr[++i].equals("#"))
            {
                TreeNode n=new TreeNode(Integer.parseInt(arr[i]));
                p.right=n;
                q.add(n);

            }
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));