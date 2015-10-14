public class Solution {
    public int addDigits(int num) {
       /* ³¬Ê±
       int nums=0;
        if(num<10) return num;
        
        while(num/10>=1){
            nums=add(num);
        }
        
        return nums;
    }
    
    public int add(int n){
        int a=n/10;
        int b=n%10;
        int c=a+b;
        return c;
    }*/
    
    return num - (num - 1) / 9 * 9;
   /*num<10) n=num;
    else{
         a=num/10;
         b=num-a*10;
         c1=a+b;
         if(c1<10) n=c1;
         else{
             a=num/10;
             b=num-a*10;
             c2=a+b;
             if(c2<10) n=c2;
             else{
                 a=num/10;
                 b=num-a*10;
                 c3=a+b;
                 n=c3;
             }
         }
    }
    return n;*/
    }
}