class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start=0;
        int end=0;
         for(int i=0;i<weights.length;i++)
         {
            end+=weights[i];
            start=Math.max(weights[i],start);
         }
         int mid=0;
         while(start<=end)
         {
            mid=start+(end-start)/2;
            if(isSafe(weights,mid,days)==true)
            { 
                 end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
         return start;
        
    }
    public boolean isSafe(int arr[],int mid,int days)
    {
        int weight=0;
        int day=1;
        for(int i=0;i<arr.length;i++)
        {
          
            if(weight+arr[i]<=mid)
            {
                weight+=arr[i];
            }
            else{
                day++;
                weight=arr[i];
            }
        }
        if(day<=days) return true;
        return false;
    }
}