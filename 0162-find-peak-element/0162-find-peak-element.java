class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length-1;
        int start=1;
        int end=n-1;
        int mid=0;
        if(n==0) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n]>nums[n-1]) return n;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1])
            {
                return mid;
            }
            if(nums[mid-1]<nums[mid])
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
        
    }
}