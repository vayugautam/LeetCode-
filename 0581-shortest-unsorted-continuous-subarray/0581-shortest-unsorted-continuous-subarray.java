class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        if (n <= 1)
            return 0;

        int minidx = -1;
        int maxidx = -1;

        // Find right boundary
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] > nums[i]) {
                maxidx = i;
                break;
            }
        }

        // Find left boundary
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                minidx = i;
                break;
            }
        }

        // Already sorted
        if (minidx == -1)
            return 0;

        int min = nums[minidx];
        int max = nums[minidx];

        // Find min and max in the unsorted portion
        for (int i = minidx; i <= maxidx; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Expand left
        while (minidx > 0 && nums[minidx - 1] > min) {
            minidx--;
        }

        // Expand right
        while (maxidx < n - 1 && nums[maxidx + 1] < max) {
            maxidx++;
        }

        return maxidx - minidx + 1;
    }
}