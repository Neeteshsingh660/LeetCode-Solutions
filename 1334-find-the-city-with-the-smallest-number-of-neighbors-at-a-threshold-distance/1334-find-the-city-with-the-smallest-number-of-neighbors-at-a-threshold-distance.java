class Solution {
    public int findTheCity(int p, int[][] edges, int distanceThreshold) {
        int n=p;
       
        int dis[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<p;j++)
            {
                if(i!=j)
                {
                    dis[i][j]=Integer.MAX_VALUE;
                }
                else
                dis[i][j]=0;
            }
        }
        for(int []i:edges)
        {
            int a=i[0];
            int b=i[1];
            int c=i[2];
            dis[a][b]=c;
            dis[b][a]=c;
            
        }
        for(int k=0;k<p;k++)
        {
            for(int i=0;i<p;i++)
            {
                for(int j=0;j<p;j++)
                {
                    if(dis[i][k]!=Integer.MAX_VALUE&&dis[k][j]!=Integer.MAX_VALUE)
                    {
                        dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                       
                    
                    }
                }
            }
        }
        int no=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<p;i++)
            {
                int c=0;
                for(int j=0;j<p;j++)
                {
                      if(dis[i][j]<=distanceThreshold)
                      {
                      
                        c++;
                      }
                }
               
                if(c<=min)
                {
                    min=c;
                    no=i;
                }
            }
            

     return no;
    }
}