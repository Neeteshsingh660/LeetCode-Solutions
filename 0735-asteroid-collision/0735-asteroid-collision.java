class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<0)
            {
                while(!st.isEmpty()&& st.peek() > 0&&st.peek()<-1*arr[i])
                {
                    st.pop();
                }
               if(!st.isEmpty() && st.peek() == -arr[i]) {
                    st.pop();
                }
              else if(st.isEmpty() || st.peek() < 0) {
                    st.push(arr[i]);
                }
            }
            else{
                 st.push(arr[i]);
            }
        
        }
        int nums[]=new int[st.size()];
        int i=0;
        while(!st.isEmpty())
        {
           nums[i]=st.peek();
           i++;
            st.pop();
        }
        n=nums.length;
        for(int j=0;j<nums.length/2;j++)
        {
            int temp=nums[j];
            nums[j]=nums[n-1-j];
            nums[n-1-j]=temp;
        }
        return nums;
    }
}
// class Solution {
//     public int[] asteroidCollision(int[] arr) {
//         Stack<Integer> st = new Stack<>();

//         int n = arr.length;

//         for(int i = 0; i < n; i++) {

//             if(arr[i] < 0) {

//                 while(!st.isEmpty() && st.peek() > 0 && st.peek() < -arr[i]) {
//                     st.pop();
//                 }

//                 if(!st.isEmpty() && st.peek() == -arr[i]) {
//                     st.pop();
//                 }
//                 else if(st.isEmpty() || st.peek() < 0) {
//                     st.push(arr[i]);
//                 }

//             }
//             else {
//                 st.push(arr[i]);
//             }
//         }

//         int nums[] = new int[st.size()];
//         int i = 0;

//         while(!st.isEmpty()) {
//             nums[i] = st.peek();
//             i++;
//             st.pop();
//         }

//         n = nums.length;

//         for(int j = 0; j < nums.length / 2; j++) {
//             int temp = nums[j];
//             nums[j] = nums[n - 1 - j];
//             nums[n - 1 - j] = temp;
//         }

//         return nums;
//     }
// }