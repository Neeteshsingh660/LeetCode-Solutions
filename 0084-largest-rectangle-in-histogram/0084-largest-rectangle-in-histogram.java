class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
            {
                int ele=st.peek();
                st.pop();
                 int ind;
                if (st.isEmpty()) {
                    ind = i;
                } else {
                    ind = i - st.peek() - 1;
                }
                int area=arr[ele]*ind;
                maxi=Math.max(maxi,area);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            int ele=st.peek();
            st.pop();
             int ind;
                if (st.isEmpty()) {
                    ind = n;
                } else {
                    ind = n- st.peek() - 1;
                }
            int area=arr[ele]*ind;
            maxi=Math.max(maxi,area);
        }

        return maxi;
    }
}