class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int ele = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 :st.peek();

                maxi = Math.max(maxi,arr[ele]*( nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int ele = st.peek();
            st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxi = Math.max(maxi,arr[ele] *(nse - pse - 1));
        }

        return maxi;
    }
}