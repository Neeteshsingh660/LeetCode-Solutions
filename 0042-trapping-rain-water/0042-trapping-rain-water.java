class Solution {
    public int trap(int[] arr) {
        int lmax=0;
        int rmax=0;
        int l=0;
        int r=arr.length-1;
        int total=0;
        while(l<r)
        {
            lmax=Math.max(lmax,arr[l]);
            rmax=Math.max(rmax,arr[r]);
            if(lmax<rmax)
            {
                total+=lmax-arr[l];
                l++;
            }
            else{
                total+=rmax-arr[r];
                r--;
            }
        }
      return total;
        
    }
}