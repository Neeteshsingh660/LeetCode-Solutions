class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i=0;
        int j=cardPoints.length-1;
        int sum=0;
        for(int l=0;l<k;l++)
        {
            sum+=cardPoints[l];
        }
        i=k-1;
        int max=sum;
        while(i>=0)
        {
         
            sum=sum-cardPoints[i];
            sum+=cardPoints[j];
            max=Math.max(max,sum);
            i--;
            j--;

        }
       
        return max;
    }
}