public class Solution {
    public void sortColors(int[] nums) {
        
        int pf = 0;					
        int pr = nums.length - 1;		
        int i = 0;					
        
	while(i <= pr){				
            if(nums[i] == 0){		
                int tmp = nums[pf];
                nums[pf] = nums[i];
                nums[i] = tmp;
                pf++;
                i++;
            }else if(nums[i] == 1){	
                i++;
            }else if(nums[i] == 2){
                int tmp = nums[pr];
                nums[pr] = nums[i];
                nums[i] = tmp;
                pr--;
            }
        }
    }
}