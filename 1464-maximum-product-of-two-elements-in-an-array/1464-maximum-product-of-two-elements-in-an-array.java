class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxi=0;
        int secmaxi=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=maxi){
                secmaxi=maxi;
                maxi=nums[i];
            }else if(nums[i]<=maxi && nums[i]>=secmaxi){
                secmaxi=nums[i];
            }
        }
        return (maxi-1)*(secmaxi-1);
    }
}