class Solution {
    public int findKthPositive(int[] nums, int k) {
        int start=0;
        int end=nums.length-1;
        int mid=0;
        int missingNo=0;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            missingNo=nums[mid]-(mid+1);
            if(missingNo<k)
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
            
        }
       return end + k + 1;

    }
}