# Solution for 31. Next Permutation
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 2
        
        # Find the first decreasing element from right to left
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        
        if i >= 0:
            # Find the smallest element on right side that is greater than nums[i]
            j = len(nums) - 1
            while nums[j] <= nums[i]:
                j -= 1
            # Swap the found characters
            nums[i], nums[j] = nums[j], nums[i]
        
        # Reverse the suffix starting at nums[i+1]
        nums[i + 1:] = reversed(nums[i + 1:])