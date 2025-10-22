// Solution for 31. Next Permutation
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int i = nums.size() - 2;
        
        // Find the first decreasing element from right to left
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            // Find the smallest element on right side that is greater than nums[i]
            int j = nums.size() - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap the found characters
            swap(nums[i], nums[j]);
        }
        
        // Reverse the suffix starting at nums[i+1]
        reverse(nums.begin() + i + 1, nums.end());
    }
};