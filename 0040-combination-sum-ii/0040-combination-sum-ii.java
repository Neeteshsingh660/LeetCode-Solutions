class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        Arrays.sort(candidates);
        rec(0, candidates, target, l, a);
        return l;
    }

    public void rec(int i, int[] arr, int sum, List<List<Integer>> l, List<Integer> a) {
        if (sum == 0) {
           
            l.add(new ArrayList<>(a));
            return;
        }
        if (i == arr.length) {
            return;
        }
        if (arr[i] <= sum) {
            a.add(arr[i]);

            rec(i+1, arr, sum - arr[i], l, a);

            a.remove(a.size() - 1);
        }
        int next = i + 1;

        while (next < arr.length && arr[next] == arr[i]) {
            next++;
        }      
        
        rec(next, arr, sum, l, a);
        
       
    }
}