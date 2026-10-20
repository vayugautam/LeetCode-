class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

    }
    
    public int sumRange(int l, int r) {
        if(l>0){
            return prefix[r]-prefix[l-1];
        }else{
            return prefix[r];
        }
    }
}
