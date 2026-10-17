class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        int c=0;
        while(l < g.length &&r<s.length)
        {
            if(s[r]>=g[l])
            {
                c++;
                l++;
            }
                r++;
        
        }

       return c;
    }
}