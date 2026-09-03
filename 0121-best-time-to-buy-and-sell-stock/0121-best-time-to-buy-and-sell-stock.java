class Solution {
    public int maxProfit(int[] pr) {
        int p=0;
        int take=pr[0];

        for(int i=0;i<pr.length;i++){
            p=Math.max(p,pr[i]-take);
            take=Math.min(take,pr[i]);
        }
        return p;
    }
}