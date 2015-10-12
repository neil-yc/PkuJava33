public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int x = nums[0];
        for(int i=1;i<n;i++){
			//ÓÃÒìÓò
            x ^= nums[i];
        }
        return x;
    }
}