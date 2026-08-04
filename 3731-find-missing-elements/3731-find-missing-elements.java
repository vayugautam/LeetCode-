class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> missing = new ArrayList<>();
        int s = nums[0];
        int e = nums[nums.length-1];
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int i=s;i<=e;i++){
            if(!set.contains(i)){
                missing.add(i);
            }
        }
        return missing;
    }
}