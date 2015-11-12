import java.util.*;

public class Solution15 {
/*	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resu = new ArrayList<List<Integer>>();
		
		if (nums.length < 3) return resu;
		
		else {
			Set set = new HashSet();
			int zeroCount = 0; //yinwei , 0+0+0 = 0!!!
			for (int i=0; i<nums.length; i++) {
				if (nums[i]==0) zeroCount++;
				set.add(nums[i]);
			}
			if (zeroCount>2) {
				Integer[] zero = {new Integer(0),new Integer(0),new Integer(0)};
				resu.add(Arrays.asList(zero));
			}

			List<Integer> lis = new ArrayList<Integer>(set);
			Collections.sort(lis);

			//ArrayList<Integer> temp = new ArrayList<Integer>();
			if (lis.size() < 3) return resu;
			else {
				for (int i=0; i<lis.size()-2; i++) {
					if ( lis.get(i)>0 ) break;
					for (int j=i+1; j<lis.size()-1; j++) {
						if ( lis.get(j) > -lis.get(i) ) break;
						for (int k=j+1; k<lis.size(); k++) {
							if ( lis.get(i) + lis.get(j) + lis.get(k) == 0 ) {
								/*temp.clear();
								temp.add(lis.get(i));
								temp.add(lis.get(j));
								temp.add(lis.get(k));
								Integer[] temp = {lis.get(i),lis.get(j),lis.get(k)};
								resu.add( Arrays.asList(temp) );
								break;
							}
						}
					}
				}
			}
			return resu;
		}
	}
*/

public static List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	int len=nums.length;
	if(len<3)return res;
	Arrays.sort(nums);
	for(int i=0;i<len;i++){
		if(nums[i]>0)break;
		if(i>0 && nums[i]==nums[i-1])continue;
		int begin=i+1,end=len-1;
		while(begin<end){
			int sum=nums[i]+nums[begin]+nums[end];
			if(sum==0){
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[i]);list.add(nums[begin]);list.add(nums[end]);
				res.add(list);
				begin++;end--;
				while(begin<end && nums[begin]==nums[begin-1])begin++;
				while(begin<end && nums[end]==nums[end+1])end--;
                		}
                		else if(sum>0)end--;
                		else begin++;
		}
	}
	return res;
}
/*
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resu = new ArrayList<List<Integer>>();
		Set<List<Integer>> resuset = new HashSet<List<Integer>>();
		
		if (nums.length < 3) return resu;
		
		else {
			/*Set set = new HashSet();
			int zeroCount = 0; //yinwei , 0+0+0 = 0!!!
			for (int i=0; i<nums.length; i++) {
				if (nums[i]==0) zeroCount++;
				set.add(nums[i]);
			}
			if (zeroCount>2) {
				Integer[] zero = {new Integer(0),new Integer(0),new Integer(0)};
				resu.add(Arrays.asList(zero));
			}

			//Integer[] numsIng = (Integer[])nums;
			ArrayList<Integer> lis = new ArrayList<Integer>(nums.length);
			for (int i=0; i<nums.length; i++) lis.add(new Integer(nums[i]));
			Collections.sort(lis);

			//ArrayList<Integer> temp = new ArrayList<Integer>();
			if (lis.size() < 3) return resu;
			else {
				for (int i=0; i<lis.size()-2; i++) {
					if ( lis.get(i)>0 ) break;
					for (int j=i+1; j<lis.size()-1; j++) {
						if ( lis.get(j) > -lis.get(i) ) break;
						for (int k=j+1; k<lis.size(); k++) {
							if ( lis.get(i) + lis.get(j) + lis.get(k) == 0 ) {
								Integer[] temp = {lis.get(i),lis.get(j),lis.get(k)};
								//Set<Integer> tempset = new HashSet<Integer>(Arrays.asList(temp));
								//resu.add( Arrays.asList(temp) );
								resuset.add( Arrays.asList(temp) );
								break;
							}
						}
					}
				}
			}
			resu.addAll(resuset);
			return resu;
		}
	}
*/

	/*
	public static Set<Integer> threeSum(int[] nums) {
		Set<Integer> test = new HashSet<Integer>();
		for (int i=0; i<nums.length; i++) test.add(nums[i]);
		//Arrays.asList(nums);
		//ArrayList<Integer> lis = new ArrayList<Integer>(Arrays.asList(nums));
		//List lis = Arrays.asList(nums);
		//List<Integer> lis = new Arrays.asList(nums);
		//ArrayList lis = new ArrayList();
		//test.addAll(Arrays.asList(nums));
		//lis.clear();
		//lis.addAll(test);
		return test;
	}*/

/*	public static String threeSum(int[] nums) {
		Set set = new HashSet();
		for (int i=0; i<nums.length; i++) set.add(nums[i]);
		List<Integer> lis = new ArrayList<Integer>(set);
		Collections.sort(lis);
		Integer a = 0;
		for (int i=0; i<lis.size(); i++) {System.out.println(lis.get(i));
			System.out.println(lis.get(i)>a);
			//a = (Integer)lis.get(i);
		}
		//String a = Arrays.toString(lis.toArray());
		return "asd";
	}
*/
	//static int[] nums = {-7,2,1,10,9,-10,-5,4,13,-9,-4,6,11,-12,-6,-9,-6,-9,-11,-4,10,10,-3,-1,-4,-7,-12,-15,11,5,14,11,-7,-8,6,9,-2,9,-10,-12,-15,2,10,4,5,11,10,6,-13,6,-13,12,-7,-9,-12,4,-9,13,-4,10,4,-12,6,4,-5,-10,-2,0,14,4,4,6,13,-9,-5,-5,-13,12,-14,11,3,10,8,11,-13,4,-8,-7,2,4,10,13,7,2,2,9,-1,8,-5,-10,-3,6,3,-5,12,6,-3,6,3,-2,2,14,-7,-13,10,-13,-2,-12,-4,8,-1,13,6,-9,0,-14,-15,6,9};
	static int[] nums = {13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13};
	//ArrayList resu = new ArrayList(Arrays.asList(nums));



	public static void main(String[] args) {
		//Set<Integer> resu = threeSum(nums);
		List<List<Integer>> a = threeSum(nums);
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
	}
}