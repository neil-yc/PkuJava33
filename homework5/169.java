public class Solution {
    public int majorityElement(int[] nums) {
		
		//快速排序
		Arrays.sort(nums);
		//所要的数 一定为排好序的数组的中位数
		return nums[nums.length/2];

	}

}