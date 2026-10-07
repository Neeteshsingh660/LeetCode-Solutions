class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> h=new HashMap<>();
        int l=0;
        int r=0;
        int maxf=0;
        int maxlen=0;
        while(r<s.length())
        {
            h.put(s.charAt(r),h.getOrDefault(s.charAt(r),0)+1);
            maxf=Math.max(maxf,h.get(s.charAt(r)));
            if(r-l+1-maxf>k)
            {
                 h.put(s.charAt(l),h.getOrDefault(s.charAt(l),0)-1);
                 if(h.get(s.charAt(l))==0)
                 {
                    h.remove(s.charAt(l));
                 }
                 l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}