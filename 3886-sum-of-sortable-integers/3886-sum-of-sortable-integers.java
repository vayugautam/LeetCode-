class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] droppref = new int[n];
        int[] drop = new int[n];
        int currdrop=-1;
        int sum=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                droppref[i]=1;
                currdrop=i;
            } 
            drop[i]=currdrop;
        }
        for(int i=1;i<n;i++){
            droppref[i]+=droppref[i-1];
        }
        int ans=0;
        for(int k=1;k*k<=n;k++){
            if(n%k==0){
                if(is(nums,droppref,drop,k,n)){
                    ans+=k;
                }
                if(k*k!=n){
                    int o=n/k;
                    if(is(nums,droppref,drop,o,n)){
                        ans+=o;
                    }
                }
            }
        }
        return ans;
    }
    boolean is(int[] nums,int[] droppref,int[] drop,int k,int n){
        int prev=-1;
        for(int i=0;i<n;i+=k){
            int l =i,r=i+k-2;
            int drops=0;
            
            if(l<=r){
                if(l==0){
                    drops=droppref[r];
                }else{
                    drops=droppref[r]-droppref[l-1];
                }
            }
            if(drops>1) return false;
            int mn=Integer.MAX_VALUE,mx=0;
            if(drops==1){
                if(nums[i+k-1]>nums[i]){
                    return false;
                }
                int j= drop[r];
                mn=nums[j+1];
                mx=nums[j]; 
            }else{
                mn=nums[i];
                mx=nums[i+k-1];
            }
            if(prev>mn) return false;
            prev=mx;
        }
        return true;
    }
}