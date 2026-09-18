class Pair{
    int node;
    long wt;
    Pair(int n,long w)
    {
        node=n;
        wt=w;
    }
}

class Tuple{
    int node;
    long dis;
    Tuple(int n,long w)
    {
        node=n;
        dis=w;
    }
}
class Solution {
    long mod=1000000007;
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]:roads)
        {
            int a=i[0];
            int b=i[1];
            int c=i[2];
            adj.get(a).add(new Pair(b,c));
            adj.get(b).add(new Pair(a,c));
        }
       PriorityQueue<Tuple> q =
    new PriorityQueue<>((a,b)->Long.compare(a.dis,b.dis));
        long ways[]=new long[n];
        long dis[]=new long[n];
        q.add(new Tuple(0,0));
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        ways[0]=1;
        while(!q.isEmpty())
        {
            Tuple p=q.poll();
            int node=p.node;
            long d=p.dis;
            for(Pair it:adj.get(node))
            {
                int adjnode=it.node;
                long wt=it.wt;
                if(d+wt<dis[adjnode])
                {
                    dis[adjnode]=d+wt;
                    ways[adjnode] =ways[node];
                    q.add(new Tuple(adjnode,d+wt));

                }
                else if(d+wt==dis[adjnode])
                {
                    ways[adjnode]=(ways[adjnode]+ways[node])%mod;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(ways[i]+"   ");
        }
         for(int i=0;i<n;i++)
        {
            System.out.print(dis[i]+"   ");
        }
        return (int)ways[n-1];

        
    }
}