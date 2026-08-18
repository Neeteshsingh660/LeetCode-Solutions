class Solution {
    public int splitArray(int[] arr, int k) {

             int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++)
        {
            end+=arr[i];
            start=Math.max(start,arr[i]);
        }
        int mid=0;
        while(start<=end)
        {
            mid=start+(end-start)/2;
             if(sum(arr,mid,k)==true)
             {
                 end=mid-1;
             }
             else{
                 start=mid+1;
             }
            
        }
        return start;
    }
    public boolean sum(int arr[],int mid,int k)
    {
        int ind=0;
        int largest=1;
        for(int i=0;i<arr.length;i++)
        {
         if(arr[i]+ind<=mid)
         {
          ind=arr[i]+ind;   
         }
         else{
             ind=arr[i];
             largest++;
         }
       
        }
        if(largest<=k) return true;
         return false;
    }
    
}