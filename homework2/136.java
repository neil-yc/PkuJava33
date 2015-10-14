public class Solution {
    public int singleNumber(int[] nums) {
        int n=nums[0];
        for(int i=1;i<nums.length;i++){
            /*for(int j=i;j<nums.length;j++){
                if(nums[i]!=nums[j]&&j==nums.length-1)
                {
                    n=nums[i];
                    break;
                }
                else continue; //超时
            
            int j=i;
            if(nums[i]==nums[j]) continue;
            else{
                n=nums[j];
                break;}    //Wrong Answer
         
           int j=i;
           if(nums[i]^nums[j]==0) continue;  //做亦或运算;运算符的操作数类型不好 
           else{
               n=nums[j];
               break;
           }  */
           
           n=n^nums[i];  //异或运算可交换，即 a ^ b = b ^ a; 0 ^ a = a
        }
        return n;
    }
}