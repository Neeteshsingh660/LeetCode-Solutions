class Solution {
    public int jump(int[] nums) {
    
     int r=0;
     int jumps=0;
      int far=0;
      int start=0;
      while(r<nums.length-1)
      {
       
        for(int i=start;i<=r;i++)
        {
            far=Math.max(far,i+nums[i]);
        }
        
        jumps++;
        start=r;
        r=far;


      }
      return jumps;
    }
}