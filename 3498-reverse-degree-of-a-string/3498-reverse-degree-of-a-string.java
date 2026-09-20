class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        int i=1;
        for(char c : s.toCharArray()){
            int curr = ('z'-c+1)*i;
            i++;
            ans+=curr;
        }
        return ans;
    }
}