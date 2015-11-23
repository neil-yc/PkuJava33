public class Solution {
    public boolean containsDuplicate(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //顺序进行对比
		for(int i = 0; i < nums.length-1; i++){
			if(nums[i]==nums[i+1]){
				return true;
			}else{
				continue;
			}
		}
		return false;
    }
}