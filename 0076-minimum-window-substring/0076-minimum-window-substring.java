class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[256];
        int[] window = new int[256];
        int required=0;
        for(char ch : t.toCharArray()){
            if(need[ch]==0) required++;
            need[ch]++;
        }
        int left=0;
        int formed=0;
        int minlen=Integer.MAX_VALUE;
        int start=0;
        for(int right=0;right<s.length();right++){
            char ch =s.charAt(right);
            window[ch]++;
            if(window[ch]==need[ch]) formed++;

            while(formed == required){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }
                char remove=s.charAt(left);
                window[remove]--;
                if(window[remove]<need[remove]){
                    formed--;
                }
                left++;
            }
        }
        return minlen==Integer.MAX_VALUE ? "" : s.substring(start,start+minlen);

    }
}