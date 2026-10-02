class StockSpanner {
     
     ArrayList<Integer> ans;
      Stack<Integer> st;
    public StockSpanner() {
        ans=new ArrayList<>();
         st=new Stack<>();
    }
    
    public int next(int price) {
        ans.add(price);
       int i=0;
        i=ans.size()-1;
       
        int pge=(findpge(price,i));
        return Math.abs(pge-i);
    }
    public int findpge(int price,int i)
    {
       
       
            while(!st.isEmpty()&&ans.get(st.peek())<=ans.get(i))
            {
                st.pop();
            }
            int ele=st.isEmpty()?-1:st.peek();
           
            st.push(i);
     
         return ele;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */