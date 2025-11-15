import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        int[][] numWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            numWithIndex[i][0] = nums[i];
            numWithIndex[i][1] = i;
        }
        
        Arrays.sort(numWithIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int sum = numWithIndex[left][0] + numWithIndex[right][0];
            
            if (sum == target) {
                return new int[] { numWithIndex[left][1], numWithIndex[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}



/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists. */
