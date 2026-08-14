class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length-1;
        int start=1;
        int end=0;
        for(int i=0;i<=n;i++)
        {
            end=Math.max(end,nums[i]);

        }
        int mid=0;
        while(end>=start)
        {
            mid=start+(end-start)/2;
            if(isSafe(mid,nums,threshold)==true)
            {
                end=mid-1;
            }
            else{
              start=mid+1;
            }
        }
        return start;
        
        
    }
    public boolean isSafe(int mid,int arr[],int threshold)
    {
        int no=0;
        for(int i=0;i<arr.length;i++)
        {
            no+=Math.ceil((double)arr[i]/mid);
        }
        if(threshold>=no)
        {
            return true;
        }
        return false;
    }
}