public class Solution27 {
	public int removeElement(int[] nums, int val) {
		if (nums == null) return 0;
		else {
			int a = 0;
			for (int i=0; i<nums.length; i++) {
				if (nums[i]!=val) {
					nums[a] = nums[i];
					a++;
				}
			}
			return a;
		}
	}
	
	public static void main(String[] args) {
		Solution27 t = new Solution27();
		int[] nums = {1,2,3,1};
		int a = t.removeElement(nums,2);
		for (int i=0;i<a; i++) System.out.println(nums[i]);
		System.out.println(a);
		System.out.println(nums==null);
	}
}