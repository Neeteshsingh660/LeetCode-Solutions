class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        set(nums,0,l,list);
        return l;
    }
    public void set(int []arr,int i,List<List<Integer>> ans, List<Integer> list)
    {
        if(i==arr.length)
        {
          ans.add(new ArrayList<>(list));
          return;
        }
        list.add(arr[i]);
        set(arr,i+1,ans,list);
        list.remove(list.size()-1);
        set(arr,i+1,ans,list);
    }
}