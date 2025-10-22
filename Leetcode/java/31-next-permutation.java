// Solution for 31. Next Permutation
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // Find the first decreasing element from right to left
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            // Find the smallest element on right side of above character that is greater than nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap the found characters
            swap(nums, i, j);
        }
        
        // Reverse the suffix starting at nums[i+1]
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}