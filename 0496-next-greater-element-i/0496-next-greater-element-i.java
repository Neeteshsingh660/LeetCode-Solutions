class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     int arr[]=new int[10000+1];
     Stack<Integer> s=new Stack<>();
     for(int i=nums2.length-1;i>=0;i--)
     { if(!s.isEmpty())
        {
        System.out.print(s.peek()+"  ");
         }

        if(s.isEmpty())
        {
            s.push(nums2[i]);
            arr[nums2[i]]=-1;
        }
        else
        {
            if(!s.isEmpty())
            {
                  while(!s.isEmpty()&&s.peek()<nums2[i])
                  {
                    s.pop();
                  }
                  if(s.isEmpty())
                  {
                    arr[nums2[i]]=-1;
                  }
                  else{
                   arr[nums2[i]]=s.peek();
                  }
                  s.push(nums2[i]);
                  
            }
        }
      
     }
       int a[]=new int[nums1.length];
        for(int j=0;j<nums1.length;j++)
        {
            a[j]=arr[nums1[j]];
        }
   return a;
    }
}