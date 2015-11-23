public class Solution {
    public int removeDuplicates(int[] nums) {
        
       if (nums.length == 1) {
			return 1;
		}
		int count = 1;
		// int temp = 0;
		int index = 0;// 记录数组重复开始的位置
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] == nums[i]) {
				do {
					i++;
					if (i >= nums.length) {
						return count;
					}
				} while (nums[index] == nums[i]);
			}
            //将第一个不一样的数字和index后面的数字交换
			nums[index + 1] = nums[i];
			index = index + 1;
			//每交换一次说明有一个不重复的数字
			count++;

			// while((nums[index] == nums[i]) && i < nums.length-1){
			// i++;
			//
			// }
			// if(i>1&&(i == nums.length-1)){
			// return count;
			// }

		}

		return count;
    }
}