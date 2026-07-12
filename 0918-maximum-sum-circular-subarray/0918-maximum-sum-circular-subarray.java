class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxEnding = nums[0], minEnding = nums[0];
        int maxSum = nums[0], minSum = nums[0];
        int total=nums[0];
        for (int i=1;i<nums.length;i++) {
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);
            
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);

            total+=nums[i];
        }
        if (total == minSum) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}