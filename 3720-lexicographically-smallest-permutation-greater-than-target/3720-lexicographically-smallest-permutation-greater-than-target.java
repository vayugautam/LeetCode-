class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=n-1;i>=0;i--){
            int[] remaining=freq.clone();
            boolean possible=true;
            for(int j=0;j<i;j++){
                int c=target.charAt(j)-'a';
                if(remaining[c]==0){
                    possible=false;break;
                }
                remaining[c]--;
            }
            if(!possible) continue;
            int curr = target.charAt(i)-'a';
            for(int c = curr+1;c<26;c++){
                if(remaining[c]>0){
                    StringBuilder ans = new StringBuilder();
                    ans.append(target,0,i);
                    ans.append((char)('a'+c));
                    remaining[c]--;
                    for(int x=0;x<26;x++){
                        while(remaining[x]>0){
                            ans.append((char)('a'+x));
                            remaining[x]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
    }
}