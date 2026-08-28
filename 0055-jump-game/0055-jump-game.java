class Solution {
    public boolean canJump(int[] nums) {
        int reach=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(reach<i){
                return false;
            }
            reach=Math.max(reach,i+nums[i]);
            if(reach>=n-1) return true;
        }
        return true;
    }
}