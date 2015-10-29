public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
          
        List<List<Integer>> list = new ArrayList<>();
         
        int i=0,j=nums.length-1,k;
         
        while(j>0&&nums[j]>=0){
            while(i<j&&nums[i]<=0){
                int sum=nums[i] + nums[j];
                 for(k=i+1;k<j;k++){
                    if(nums[k] + sum == 0){
                             list.add(Arrays.asList(new Integer[]{nums[i], nums[k] ,nums[j]}));
                             break;
                    }
                }
                int p=nums[i];
                while(i<j&&nums[i]==p) i++;
            }
            i=0;
            int q=nums[j];
            while(j>0&&nums[j]==q) j--;
        }
        return list;
    }
}