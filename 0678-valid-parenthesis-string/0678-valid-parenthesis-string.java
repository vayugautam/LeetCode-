class Solution {
    public boolean checkValidString(String s) {
        int mini=0;
        int maxi=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                mini=mini+1;maxi=maxi+1;
            }else if(s.charAt(i)==')'){
                mini=mini-1;maxi=maxi-1;
            }else{
                mini=mini-1;maxi=maxi+1;
            }
            if(mini<0) mini=0;
            if(maxi<0) return false;
        }
        return (mini==0);
    }
}