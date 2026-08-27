class Solution {
    public int amountOfTime(TreeNode root, int start) {

        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode startNode = null;

        queue.add(root);
        parentMap.put(root.val, null);

        // Create parent mapping
        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.poll();

            if (currentNode.val == start) {
                startNode = currentNode;
            }

            if (currentNode.left != null) {
                queue.add(currentNode.left);
                parentMap.put(currentNode.left.val, currentNode);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
                parentMap.put(currentNode.right.val, currentNode);
            }
        }

        HashMap<Integer, Boolean> visited = new HashMap<>();
        visited.put(startNode.val, true);

        Queue<TreeNode> burnQueue = new LinkedList<>();
        burnQueue.add(startNode);

        int time = 0;

        while (!burnQueue.isEmpty()) {

            int levelSize = burnQueue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = burnQueue.poll();

                // Left child
                if (currentNode.left != null &&
                    !visited.containsKey(currentNode.left.val)) {

                    burnQueue.add(currentNode.left);
                    visited.put(currentNode.left.val, true);
                }

                // Right child
                if (currentNode.right != null &&
                    !visited.containsKey(currentNode.right.val)) {

                    burnQueue.add(currentNode.right);
                    visited.put(currentNode.right.val, true);
                }

                // Parent
                TreeNode parent = parentMap.get(currentNode.val);

                if (parent != null &&
                    !visited.containsKey(parent.val)) {

                    burnQueue.add(parent);
                    visited.put(parent.val, true);
                }
            }

            time++;
        }

        return time - 1;
    }
}