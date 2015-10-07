public class Solution {
    public void rotate(int[] nums, int k) {
       k = k % nums.length; 
       change(nums, 0, nums.length-k-1);                      
       change(nums, nums.length-k, nums.length-1);
       change(nums, 0, nums.length-1);
    }
    
     public void change(int[] a, int m, int n) {	
        while (m < n) {
            int t = a[m];
            a[m] = a[n];
            a[n] = t;
            m++;
            n--;
        }
     }
}