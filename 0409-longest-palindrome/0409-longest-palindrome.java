class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int ans=0;boolean hasodd=false;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int freq : map.values()){
            ans+=(freq/2)*2;
            if(freq%2==1){
                hasodd=true;
            }
        }
        if(hasodd) ans++;
        return ans;
    }
}