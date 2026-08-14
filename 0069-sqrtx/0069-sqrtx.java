class Solution {
    public int mySqrt(int x) {
        int start=1;
        int end=x;
        int mid=0;

        while(start<=end)
        {
            
            mid=start+(end-start)/2;
            if((long)mid*mid<=x)
            {
              
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return end;
    }
}