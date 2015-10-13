public class Solution1 {
	public static int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		int a,b,c;
		a=b=c=0;
		int[] ai = new int[len];
		int[] bi = new int[len];
		int[] ci = new int[len];
		int[] result = {0,0};

		for (int i=0; i<len; i++) {
			if (nums[i]<=target && nums[i]>=0) {
				ai[a] = nums[i];
				a++;
			}
			else if (nums[i]<0) {
				bi[b] = nums[i];
				b++;
			}
			else {
				ci[c] = nums[i];
				c++;
			}
		}

		if (b>0 && c>0) {
			for (int i=0; i<b; i++) {
				for (int j=0; j<c; j++){
					if (bi[i]+ci[j] == target) {
						result[0] = i+1;
						result[1] = j+1;
						break;
					}
				}
			}
		}

		if (a>1) {
			for (int i=0; i<a-1; i++){
				for (int j=i+1; j<a; j++){
					if (ai[i]+ai[j] == target) {
						result[0] = i+1;
						result[1] = j+1;
						break;
					}
				}
			}
		}
		return result;
	}
	
	static int[] nums = {0,4,3,0};
	static int[] a = twoSum(nums,0);
	public static void main(String[] args){
		for (int i=0; i<2; i++) System.out.println(a[i]);
	}
}