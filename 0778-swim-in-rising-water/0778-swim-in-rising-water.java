class Pair{
    int time;
    int row;
    int col;
    Pair(int t,int r,int c)
    {
        time=t;
        row=r;
        col=c;
    }

}

class Solution {
    public int swimInWater(int[][] grid) {
        int time=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.time-b.time);
        q.add(new Pair(grid[0][0],0,0));
        int timer=0;
        int max=0;
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int tim=p.time;
            max=Math.max(tim,max);
            System.out.println(tim);
            int row=p.row;
            int col=p.col;
            if(row==n-1&&col==m-1) return max;
            int delr[]={-1,0,1,0};
            int delc[]={0,-1,0,1};
            for(int i=0;i<4;i++)
            {
                int r=row+delr[i];
                int c=col+delc[i];
                if(r>=0&&r<n&&c>=0&&c<m&&!vis[r][c])
                {
                    vis[r][c]=true;
                   
                        q.add(new Pair(grid[r][c],r,c));
                        timer++;
                
                }
            }

        }
        return timer;
    }
}