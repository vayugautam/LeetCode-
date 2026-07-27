class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans=0;
        int sum=0;
        Map<Integer,Integer> mapp = new HashMap<>();
        mapp.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0) rem+=k;
            ans += mapp.getOrDefault(rem, 0);
            mapp.put(rem,mapp.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}