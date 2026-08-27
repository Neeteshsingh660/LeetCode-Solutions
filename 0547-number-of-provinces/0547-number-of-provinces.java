// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//      ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<isConnected.length;i++)
//         {
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<isConnected.length;i++)
//         {
//             for(int j=0;j<isConnected.length;j++)
//             {
//                 if(i!=j&&isConnected[i][j]==1)
//                 {
//                     adj.get(i).add(j);
//                 }
//             }
//         }

//         System.out.println(adj);
//         boolean vis[]=new boolean[isConnected.length];
//         int c=0;
//         for(int i=0;i<vis.length;i++)
//         {
//              if(!vis[i])
//              {
//                 dfs(vis,i,adj);
//                 c++;

//              }

//         }
//         return c;
//     }

//     public void dfs(boolean vis[],int i,ArrayList<ArrayList<Integer>> adj)
//     {
//         vis[i]=true;
//         for(int node:adj.get(i))
//         {
//             if(!vis[node])
//             {
//                 dfs(vis,node,adj);

//             }
//         }
//     }
// }

class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[isConnected.length];

        int c = 0;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                c++;
                q.add(i);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    for (Integer node : adj.get(n)) {
                        if (!vis[node]) {
                            q.add(node);
                            vis[node] = true;
                        }

                    }
                }
            }
          
        }
        System.out.println(adj);

        return c;

    }

}