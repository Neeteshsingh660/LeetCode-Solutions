class Solution {
    public int[] nextGreaterElements(int[] nums) {
     Stack<Integer> s=new Stack<>();
     
     int n=nums.length;
     int arr[]=new int[n];
     for(int i=n+n-1;i>=0;i--)
     {
        while(!s.isEmpty()&&s.peek()<=nums[i%n])
        {
            s.pop();
        }
      
        if(i<n)
        {
            if(s.isEmpty()) arr[i]=-1;
            else
            arr[i]=s.peek();
        }
         s.push(nums[i%n]);
       
     }
  return arr;
    }
}