public class Solution {
    public boolean isPowerOfTwo(int n) {
        int m=0,i=0;
        while(n>0){
            
            m+=(n&0x01);
            n=n/2;
           // m=n%2;
           // if(m==0)  i++;
            }
        //if(m>=1)  return true; 
    
        return m==1;
    }
}