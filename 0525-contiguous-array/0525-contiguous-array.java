class Solution {
    public int findMaxLength(int[] nums) {
        int zero=0;
        int one=0;
        int diff=0;
        int n = nums.length;
        int res=0;
        Map<Integer,Integer> mapp = new HashMap<>();
        mapp.put(0, -1);
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                one++;
            }else{
                zero++;
            }
            diff=one-zero;
            if(!mapp.containsKey(diff)){
                mapp.put(diff, i);
            }else{
                res=Math.max(res,i-mapp.get(diff));
            }
            if(diff==0){
                res=Math.max(res,i+1);
            }
        }
        return res;
    }
}