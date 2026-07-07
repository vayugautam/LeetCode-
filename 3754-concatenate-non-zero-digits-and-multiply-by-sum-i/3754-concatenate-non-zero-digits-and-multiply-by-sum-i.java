class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        long sum=0;
        long x=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='0') continue;
            sum+=ch-'0';
            x=x*10+(ch-'0');
        }
        return sum*x;
    }
}