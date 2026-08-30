class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minidx = 0;
        int maxidx = 0;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[minidx]){
                minidx=i;
            }
            if(nums[i]>nums[maxidx]){
                maxidx=i;
            }
        }
        int i=Math.min(maxidx,minidx);
        int j = Math.max(maxidx,minidx);
        int fromfront=j+1;
        int fromback=n-i;
        int bothsides=(i+1)+(n-j);
        return Math.min(fromfront,Math.min(fromback,bothsides));
    }
}