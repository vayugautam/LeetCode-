class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> f = new HashMap<>();
        f.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += f.getOrDefault(sum - k, 0);
            f.put(sum, f.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}