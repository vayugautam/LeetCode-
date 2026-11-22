class Solution {
    public boolean checkString(String s) {
        boolean yes = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                yes=false;
            }
            if(s.charAt(i)=='a' && yes==false){
                return false;
            }
        }
        return true;
    }
}