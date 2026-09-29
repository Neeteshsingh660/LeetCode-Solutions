class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(1,k,n,l,list);
        return l;
    }
    public void helper(int ind,int k,int n, List<List<Integer>> li, List<Integer> l)
    {
        if(l.size()==k&&n==0) 
        {
           li.add(new ArrayList<>(l));
           return;
        }
        if(l.size()==k) return;
        if(n==0) return;
       
        for(int j=ind;j<=9;j++)
        {
            l.add(j);
            helper(j+1,k,n-j,li,l);
            l.remove(l.size()-1);
        }
       
    }
}