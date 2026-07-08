class Solution {
    static final long MOD = 1_000_000_007L;
    public int[] sumAndMultiply(String s, int[][] queries) {
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            int d = s.charAt(i)-'0';
            if(d!=0){
                digits.add(d);
                pos.add(i);
            }
        }
        int n = digits.size();
        long[] prefsum=new long[n+1];
        // Prefix concatenated number
        long[] prefnum=new long[n+1];
        // Powers of 10
        long[] pow10=new long[n+1];
        pow10[0]=1;
        for(int i=0;i<n;i++){
            prefsum[i+1]=prefsum[i]+digits.get(i);
            prefnum[i+1]=(prefnum[i]*10+digits.get(i))%MOD;
            pow10[i+1]=(pow10[i]*10)%MOD;
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int left = lowerbound(pos,l);
            int right = upperbound(pos,r)-1;
            if(left>right){
                ans[i]=0;continue;
            }
            long sum=prefsum[right+1]-prefsum[left];
            int len=right-left+1;
            long x= (prefnum[right+1]-(prefnum[left]*pow10[len])%MOD+MOD)%MOD;
            ans[i]=(int)((x*sum%MOD)%MOD);
        }
        return ans;
    }
    int lowerbound(ArrayList<Integer> arr,int target){
        int lo=0;
        int hi=arr.size();

        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(arr.get(mid)>=target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
    int upperbound(ArrayList<Integer> arr,int target){
        int lo=0;
        int hi=arr.size();

        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(arr.get(mid)>target){
                hi=mid;
            }else{
                lo=mid+1;
            }
            
        }
        return lo;
    } 
}