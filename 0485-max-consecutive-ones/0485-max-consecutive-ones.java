class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr =0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) curr=0;
            else{
                curr++;
                ans=Math.max(curr,ans);
            }
        }
        return ans;
    }
}