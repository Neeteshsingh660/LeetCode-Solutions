class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int mid=0;
        int low=Integer.MAX_VALUE;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[start]<=nums[mid])
            {
                low=Math.min(nums[start],low);
                start=mid+1;
            }
            else{
                low=Math.min(nums[mid],low);
                end=mid-1;

            }
        }
        return low;
    }
}