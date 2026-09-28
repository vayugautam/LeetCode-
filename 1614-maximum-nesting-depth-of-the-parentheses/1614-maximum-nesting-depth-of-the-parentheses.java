class Solution {
    public int maxDepth(String s) {
        int maxi=0;
        int open=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
                maxi=Math.max(maxi,open);
            }
            else if(s.charAt(i)==')') open--;
        }
        return maxi;
    }
}