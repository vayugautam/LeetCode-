class Solution {
    public boolean checkDivisibility(int n) {
        int orig = n;
        int digsum = 0;
        int digpro=1;
        int temp =n;
        while(temp>0){
            int dig = temp%10;
            digsum+=dig;
            digpro*=dig;
            temp/=10;
        }
        return orig%(digsum+digpro)==0;
    }
}