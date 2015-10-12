public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                nums[len] = nums[i];//后面的数可以将前面的覆盖
                len++;
            }
        }
//        for(int i=0;i<nums.length;i++){
//			System.out.println(nums[i]);
//		}
        return len;
    }
}