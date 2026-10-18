class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
            {
                five++;
            }
            else if(five!=0&&bills[i]==10)
            {
                
                five--;
                ten++;

            }
            else if(five>2||five!=0&&ten!=0)
            {
                if(ten!=0){
                five--;
                ten--;
                }
                else{
                    five=five-3;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}