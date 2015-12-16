public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		//如果nums1为空，则直接将nums2的内容考到nums1中
		if(m == 0){
		    for(int i = 0; i < n; i++){
		        nums1[i] = nums2[i];
		    }    
		}
		
		int max = m+n-1;
		int m1 = m-1;
		
		//将nums2 和 nums1 从后向前进行比较，将较大的放在nums1的最后 m+n 的位置
		s:for(int i = n-1; i >= 0 ; i--){
			for(int j = m1; j >= 0; j--){
				if(nums2[i] > nums1[j]){
					nums1[max] = nums2[i];
					//下次仍是m
//					j++;
					max --;
					break;
				}else{
					nums1[max] = nums1[j];
//					i++;
					max --;
					m1 --;
					if(j == 0){
						for(int a=i;a>=0;a--){
							nums1[max] = nums2[a];
							max --;
						}
						break s;
					}
					continue;
				}
			}
			
		}
		
	}
}