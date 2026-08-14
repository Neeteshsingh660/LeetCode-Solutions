class Solution {
    public int minEatingSpeed(int[] arr, int h) {
       int max=0;
        for(int i=0;i<arr.length;i++)
        {
          max=Math.max(max,arr[i]);
        }
        int start=1;
        int end=max;
        int mid=0;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(ban(mid,arr)<=h)
            {
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return start;
    }
    public int ban(int mid,int arr[])
    {
        int no=0;
        for(int i=0;i<arr.length;i++)
        {
            
           
          no += Math.ceil((double)arr[i] / mid);
        }
        return no;

    }
}