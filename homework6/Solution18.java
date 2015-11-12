import java.util.*;

public class Solution18 {

public static List<List<Integer>> fourSum(int[] nums, int target) {

	Arrays.sort(nums);
	HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	List<List<Integer>> resu = new ArrayList<List<Integer>>();

	for (int i=0; i<nums.length; i++) {
		for (int j=i+1; j<nums.length; j++) {
			int start = j + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[j] + nums[start] + nums[end];
				if (sum > target) {
					end--;
				} else if (sum < target) {
					start++;
				} else if (sum == target) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					//Integer[] tempIng = {new Integer(nums[i]), new Integer(nums[j]), new Integer(nums[start]), new Integer(nums[end])};
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[start]);
					temp.add(nums[end]);
					//temp = ArrayList(tempIng);
					if (!set.contains(temp)) {
						set.add(temp);
						resu.add(temp);
					}
					start++;
					end--;
				}
			}
		}
	}

	return resu;
}
	static int[] nums = {-7,2,1,10,9,-10,-5,4,13,-9,-4,6,11,-12,-6,-9,-6,-9,-11,-4,10,10,-3,-1,-4,-7,-12,-15,11,5,14,11,-7,-8,6,9,-2,9,-10,-12,-15,2,10,4,5,11,10,6,-13,6,-13,12,-7,-9,-12,4,-9,13,-4,10,4,-12,6,4,-5,-10,-2,0,14,4,4,6,13,-9,-5,-5,-13,12,-14,11,3,10,8,11,-13,4,-8,-7,2,4,10,13,7,2,2,9,-1,8,-5,-10,-3,6,3,-5,12,6,-3,6,3,-2,2,14,-7,-13,10,-13,-2,-12,-4,8,-1,13,6,-9,0,-14,-15,6,9};
	
	public static void main(String[] args) {
		//Set<Integer> resu = fourSum(nums);
		List<List<Integer>> a = fourSum(nums, 2);
		//Object[] resu1 = resu.toArray();
		//String[] arr = (String[])resu.toArray(new String[resu.size()]);
		//Arrays.sort(nums);
		//int[] resuint = new int[200];
		//resu.toArray(resuint);
		//String resu1 = Arrays.toString(resuint);
		//ArrayList resu = new ArrayList(Arrays.asList(nums));
		//for(int i=0; i<a.size(); i++) System.out.println(a.get(i));
		//for (int v : resu) System.out.println(v);
		System.out.println(a);
		//System.out.println();
	}
}