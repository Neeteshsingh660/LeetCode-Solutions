class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> l=new ArrayList<>();
        List<String> list=new ArrayList<>();
        par(s,0,l,list);
        return l;
    }
    public void par(String s,int i, List<List<String>> l,List<String> list)
    {
        if(i==s.length())
        { 
            l.add(new ArrayList<>(list));
            return;
        }
        for(int ind=i;ind<s.length();ind++)
        {
            if(isvalid(i,ind,s))
            {
                list.add(s.substring(i,ind+1));
                par(s,ind+1,l,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isvalid(int i,int ind,String s)
    {
        while(i<ind)
        {
            if(s.charAt(i++)!=s.charAt(ind--))
            {
                return false;
            }
        }
        return true;
        }
    
}