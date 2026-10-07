class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int presum=0;
        int sum=0;
        h.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            presum+=nums[i];
            int rem=presum-k;
            if(h.containsKey(rem))
            {
                sum+=h.get(rem);
            }
            h.put(presum,h.getOrDefault(presum,0)+1);
        }
        System.out.print(h);
        return sum;
    }
}