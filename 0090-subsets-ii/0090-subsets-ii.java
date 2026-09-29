class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
          List<List<Integer>> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,list,l,0);
        return list;

        
    }
  
    void helper(int[] nums, List<List<Integer>> list, List<Integer> l, int i) {
        // Add the current subset
       

        if (i == nums.length) {
             list.add(new ArrayList<>(l));
            
             return;
        }

      
        l.add(nums[i]);
       
        helper(nums, list, l, i + 1);

       
        l.remove(l.size() - 1);
        
         int next=i+1;
         while(next<nums.length&&nums[next]==nums[i])
         {
            next++;
         }
        helper(nums, list, l, next);
    
       
    }
}