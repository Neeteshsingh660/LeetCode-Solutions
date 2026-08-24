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

        // Store parent of every node
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {

            TreeNode currentNode = treeQueue.poll();

            if (currentNode.left != null) {
                treeQueue.add(currentNode.left);
                parentMap.put(currentNode.left.val, currentNode);
            }

            if (currentNode.right != null) {
                treeQueue.add(currentNode.right);
                parentMap.put(currentNode.right.val, currentNode);
            }
        }

        // Store visited nodes
        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.put(target.val, 1);

        // BFS starting from target
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(target);

        int distance = 0;

        while (distance < k) {

            int size = bfsQueue.size();

            for (int i = 0; i < size; i++) {

                TreeNode currentNode = bfsQueue.poll();

                // Move to left child
                if (currentNode.left != null &&
                    !visited.containsKey(currentNode.left.val)) {

                    bfsQueue.add(currentNode.left);
                    visited.put(currentNode.left.val, 1);
                }

                // Move to right child
                if (currentNode.right != null &&
                    !visited.containsKey(currentNode.right.val)) {

                    bfsQueue.add(currentNode.right);
                    visited.put(currentNode.right.val, 1);
                }

                // Move to parent
                if (parentMap.containsKey(currentNode.val)) {

                    TreeNode parentNode = parentMap.get(currentNode.val);

                    if (!visited.containsKey(parentNode.val)) {

                        bfsQueue.add(parentNode);
                        visited.put(parentNode.val, 1);
                    }
                }
            }

            distance++;
        }

        // All nodes currently in the queue are at distance k
        ArrayList<Integer> result = new ArrayList<>();

        while (!bfsQueue.isEmpty()) {
            result.add(bfsQueue.poll().val);
        }

        return result;
    }
}