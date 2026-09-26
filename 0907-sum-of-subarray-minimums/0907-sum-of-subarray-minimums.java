class Solution {
    int mod=1000000007;
    public int sumSubarrayMins(int[] arr) {
    int nse[]=findnse(arr);
    int pse[]=findpse(arr);
    int sum=0;
    for(int i=0;i<arr.length;i++)
    {
        int n=nse[i]-i;
        int p=i-pse[i];
        long len = ((long)n * p * arr[i]) % mod;
        sum=(sum+(int)len)%mod;
    }
    return sum;
    }
    public int[] findpse(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int element[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
           while(!st.isEmpty()&&arr[st.peek()]>arr[i])
           {
                st.pop();
           }
           element[i]=st.isEmpty()?-1:st.peek();
           st.push(i);
        }
        return element;
    }

     public int[] findnse(int arr[])
     {
        Stack<Integer> st=new Stack<>();
        int nse[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
       return nse;
     }
}






// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int mini=Integer.MAX_VALUE;
//         int n=arr.length;
//         int sum=0;
//         for(int i=0;i<n;i++)
//         {
//             mini=arr[i];
//             for(int j=i;j<n;j++)
//             {
//                mini=Math.min(mini,arr[j]);
//                sum+=mini;
//             }
//         }
//         return sum;
//     }
// }