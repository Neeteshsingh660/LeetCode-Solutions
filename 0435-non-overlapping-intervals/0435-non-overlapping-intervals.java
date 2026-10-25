class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        
        int ele=intervals[0][1];
        int c=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(ele>intervals[i][0])
            {
                
                c++;
            }
            else{
                  ele=intervals[i][1];
            }
        }
    return c;
        
    }
}