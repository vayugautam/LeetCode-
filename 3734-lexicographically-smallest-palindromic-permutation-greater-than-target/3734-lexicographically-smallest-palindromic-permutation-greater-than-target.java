class Solution {
    private String target;
    private int n,m;
    private char centerchar;
    private String ans ="";
    public String lexPalindromicPermutation(String s, String target) {
        this.target=target;
        this.n=s.length();
        this.m=n/2;
        int[] cnt = new int[26];
        for(char ch : s.toCharArray()) cnt[ch-'a']++;
        int odd = 0;
        for(int c =0;c<26;++c) if((cnt[c]&1)==1) odd++;
        if(odd>1) return "";
        int[] half=new int[26];
        for(int c = 0;c<26;++c) half[c]=cnt[c]/2;
        centerchar='\0';
        if((n&1)==1){
            for(int c = 0;c<26;++c) if((cnt[c]&1)==1){centerchar=(char)('a'+c);break;}
        }
        char[] halfarr=new char[m];
        boolean found = dfs(0,false,half,halfarr);
        return found ? ans : "";    
    }
    private String buildpalin(char[] halfarr) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < m; ++i) sb.append(halfarr[i]);
        if ((n & 1) == 1) sb.append(centerchar);
        for (int i = m - 1; i >= 0; --i) sb.append(halfarr[i]);
        return sb.toString();
    }
    private boolean dfs(int pos, boolean greater, int[] halfcnt, char[] halfarr) {
        if (pos == m) {
            String p = buildpalin(halfarr);
            if (p.compareTo(target) > 0) { ans = p; return true; }
            return false;
        }

        if (greater) {
            char[] temp = new char[m];
            System.arraycopy(halfarr, 0, temp, 0, pos);
            int[] hc = halfcnt.clone();
            int idx = pos;
            for (int c = 0; c < 26; ++c) {
                while (hc[c] > 0) {
                    temp[idx++] = (char) ('a' + c);
                    hc[c]--;
                }
            }
            String p = buildpalin(temp);
            if (p.compareTo(target) > 0) { ans = p; return true; }
            return false;
        } else {
            int tchar = target.charAt(pos) - 'a';
            if (tchar >= 0 && tchar < 26 && halfcnt[tchar] > 0) {
                halfcnt[tchar]--;
                halfarr[pos] = (char) ('a' + tchar);
                if (dfs(pos + 1, false, halfcnt, halfarr)) return true;
                halfcnt[tchar]++;
            }
            for (int c = tchar + 1; c < 26; ++c) {
                if (halfcnt[c] > 0) {
                    halfcnt[c]--;
                    halfarr[pos] = (char) ('a' + c);
                    char[] tmp = new char[m];
                    System.arraycopy(halfarr, 0, tmp, 0, pos + 1);
                    int[] hc = halfcnt.clone();
                    int idx = pos + 1;
                    for (int cc = 0; cc < 26; ++cc) {
                        while (hc[cc] > 0) {
                            tmp[idx++] = (char) ('a' + cc);
                            hc[cc]--;
                        }
                    }
                    String p = buildpalin(tmp);
                    halfcnt[c]++;
                    if (p.compareTo(target) > 0) { ans = p; return true; }
                }
            }
            return false;
        }
    }
}