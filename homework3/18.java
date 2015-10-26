public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         Arrays.sort(nums);
          
        List<List<Integer>> list = new ArrayList<>();
         
        int i,j,p,q;
        /* 
        while(j>0&&nums[j]>=0){
            while(i<j&&nums[i]<=0){
                 int sum=nums[i] + nums[j];
                 for(p=i+1;p<j;p++){
                     for(q=j-1;q>p;q--){
                         if(nums[p] +nums[q]+ sum == target){
                             list.add(Arrays.asList(new Integer[]{nums[i], nums[p] ,nums[q],nums[j]}));
                             break;
                         }
                    }
                }
                int k=nums[i];
                while(i<j&&nums[i]==k) i++;
            }
            i=0;
            int k=nums[j];
            while(j>0&&nums[j]==k) j--;
        }*/
        for(i=0;i<nums.length-3;i++){
            if (i != 0 && nums[i] == nums[i-1])     continue;
            for(j=i+1;j<nums.length-2;j++){
                if (j != i + 1 && nums[j] == nums[j-1])   continue;
                p=j+1; q=nums.length-1;
                while(p<q){
                     if (p != j + 1 && nums[p] == nums[p-1]) {
                        p++;
                        continue;
                     }
                     if (q != nums.length - 1 && nums[q] == nums[q+1]) {
                        q--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target) {
                        list.add(Arrays.asList(new Integer[]{nums[i], nums[j] ,nums[p],nums[q]}));
                        p++;
                        q--;
                    } else if (sum < target) {
                                p++;
                          } else {
                                 q--;
                                 }
                }
             }
      }
    return list;
    }
}