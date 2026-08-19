class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max=0;
        int k=0;
        int j=0;
        for(int i=0;i<mat.length;i++)
        {
            int d=lowerBound(mat[i]);
            if(d>max)
            {
                k=i;
                j=d;
                max=d;
            }
            
        }
        return new int[]{k,j};

    }
    public int lowerBound(int arr[])
    {
        int start=0;
        int end=arr.length-1;
        int mid=0;
        Arrays.sort(arr);
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(arr[mid]>=1)
            {
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return arr.length-start;
    }
}