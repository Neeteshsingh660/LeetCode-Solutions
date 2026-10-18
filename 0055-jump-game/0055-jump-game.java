class Solution {
    public boolean canJump(int[] nums) {
        int j=0;
        if(nums.length==1)
        {
            return true;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]+i>j)
            {
                j=nums[i]+i;
            }
            else if(j!=nums.length-1&&nums[i]==0&&j==i)
            {
                return false;
            }
            System.out.print(j+" ");
           
        }
        if(j<nums.length-1) return false;
        return true;
    }
}