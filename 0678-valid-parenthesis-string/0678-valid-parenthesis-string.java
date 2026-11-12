class Solution {
    public boolean checkValidString(String s) {
        int min=0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                min++;
                max++;
            }
            else if(s.charAt(i)==')')
            {
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(max==-1)return false;
            if(min==-1) min=0;
        }
        return min==0?true:false;
        
    }
}