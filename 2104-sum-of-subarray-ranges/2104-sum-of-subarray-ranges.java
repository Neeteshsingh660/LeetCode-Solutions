class Solution {
    public long subArrayRanges(int[] arr) {
     int nse[]=findnse(arr);
    int pse[]=findpse(arr);
    long smallersum=0;
    for(int i=0;i<arr.length;i++)
    {
        int n = nse[i] - i;
        int p = i - pse[i];
        long len = ((long)n * p * arr[i]);
        smallersum=(smallersum+len);
    }

    int nge[]=findnge(arr);
    int pge[]=findpge(arr);
    long largersum=0;
     for(int i=0;i<arr.length;i++)
    {
        int n=nge[i]-i;
        int p=i-pge[i];
        long len = ((long)n * p * arr[i]);
        largersum=(largersum+len);
    }
    return largersum-smallersum;
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
    public int[] findnge(int arr[])
     {
        Stack<Integer> st=new Stack<>();
        int nse[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
       return nse;

     }
      public int[] findpge(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int element[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
           while(!st.isEmpty()&&arr[st.peek()]<arr[i])
           {
                st.pop();
           }
           element[i]=st.isEmpty()?-1:st.peek();
           st.push(i);
        }
        return element;
    }
}