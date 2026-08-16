class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int j = i;
            int count = 0;
            while(!hs.contains(nums[j])){
                hs.add(nums[j]);
                j = nums[j];
                count++;
            }
            ans = Math.max(ans , count);
        }
        return ans;
    }
}