class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task-'A']++;
        }
        int maxfreq=0;
        for(int f : freq){
            maxfreq=Math.max(maxfreq,f);
        }
        int countmax=0;
        for(int f : freq){
            if(f==maxfreq) countmax++;
        }
        int ans = (maxfreq-1)*(n+1)+countmax;
        return Math.max(tasks.length,ans);
    }
}