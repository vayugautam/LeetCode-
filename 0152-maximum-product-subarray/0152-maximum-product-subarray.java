class Solution {
    public int maxProduct(int[] a) {
        int n = a.length;
        int minending=a[0];
        int maxending=a[0];
        int res=a[0];
        for(int i=1;i<n;i++){
            int v1 = a[i];
            int v2 = minending*a[i];
            int v3 = maxending*a[i];
            minending = Math.min(v1,Math.min(v2,v3));
            maxending = Math.max(v1,Math.max(v2,v3));
            res = Math.max(res,Math.max(minending,maxending));
        }
        return res;
    }
}