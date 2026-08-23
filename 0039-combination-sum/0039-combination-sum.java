class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        recursion(0,candidates,target,l,a);
        return l;
    }
    public void recursion(int j,int[] arr, int target, List<List<Integer>> l,List<Integer> a)
    {
        if(target==0)
        {
            l.add(new ArrayList<>(a));
            j++;
            return;
        }
        if(target<0)
        {
            j++;
            return;
        }
        for(int i=j;i<arr.length;i++)
        {
            a.add(arr[i]);
            recursion(i,arr,target-arr[i],l,a);
            a.remove(a.size()-1);

        }
    }
}