class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        StringBuilder s=new StringBuilder("");
        for(int i=0;i<num.length();i++)
        {
            if(k==0)
            {
               
                st.push(num.charAt(i)-'0');
            }
            else{
            while(!st.isEmpty()&&k!=0&&st.peek()>num.charAt(i)-'0')
            {
                st.pop();
                k--;
            }
          
           st.push(num.charAt(i)-'0');
        }

        }
       while(k > 0)
        {
            st.pop();
            k--;
        }

        while(!st.isEmpty())
        {
            s.append(st.peek());
            st.pop();
        }

        s.reverse();

        while(s.length() > 1 && s.charAt(0) == '0')
        {
            s.deleteCharAt(0);
        }

        if(s.length() == 0)
            return "0";

        return s.toString();
        
    }
}