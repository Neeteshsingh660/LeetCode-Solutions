class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        int k=0;
        int n=intervals.length;
        int add[][]=new int[n+1][2];
        while(i<n&&intervals[i][1]<newInterval[0])
        {
            add[i][0]=intervals[i][0];
            add[i][1]=intervals[i][1];
            i++;
            k++;
            
        }
        
     
        while(i<n&&intervals[i][0]<=newInterval[1])
        {
              newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;

        }
        add[k][0]=newInterval[0];
        add[k][1]=newInterval[1];
        k++;
           while(i < n) {
            add[k][0] = intervals[i][0];
            add[k][1] = intervals[i][1];
            i++;
            k++;
        }

        return Arrays.copyOf(add, k);
    }
}