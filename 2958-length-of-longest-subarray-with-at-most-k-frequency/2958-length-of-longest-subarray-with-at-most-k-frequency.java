class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> mapp = new HashMap<>();
        int low=0;
        int maxi=0;
        for(int high=0;high<nums.length;high++){
            mapp.put(nums[high],mapp.getOrDefault(nums[high],0)+1);
            while(mapp.get(nums[high])>k){
                mapp.put(nums[low],mapp.get(nums[low])-1);
                low++;
            }
            maxi=Math.max(maxi,high-low+1);
        }
        return maxi;
    }
}