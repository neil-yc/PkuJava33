public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //要找到一个数据结构方便存储和查询
		//hashmap
		
		HashMap<Integer, Integer> numMap = new HashMap<>();
		for(int i = 0;i < nums.length;i++){
			numMap.put(nums[i], i+1);
		}
//		int p1,p2;
		int[] result = new int[2];
		for(int i = 0;i<numMap.size();i++){
			if(numMap.containsKey(target - nums[i])){
				int p1 = i+1;
				int p2 = numMap.get(target - nums[i]);
				if(p1 != p2){
					result[0] = p1;
					result[1] = p2;
					return result;
				}
			}
		}
		
		return result;
    }
}