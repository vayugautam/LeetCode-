class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnding = 0, minEnding = 0;
        int maxSum = 0, minSum = 0;

        for (int x : nums) {
            maxEnding = Math.max(x, maxEnding + x);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(x, minEnding + x);
            minSum = Math.min(minSum, minEnding);
        }
        return Math.max(maxSum, -minSum);
    }
}