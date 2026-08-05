class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int[][] res = new int[a.length + b.length][2];
        int i =0;
        int j =0;
        int idx=0;
        while(i<a.length && j<b.length){
            int start1 = a[i][0];
            int end1 = a[i][1];
            int start2 = b[j][0];
            int end2 = b[j][1];
            if(start1<=start2){
                if(end1>=start2){
                    int s=Math.max(start1,start2);
                    int e = Math.min(end1,end2);
                    res[idx][0]=s;
                    res[idx][1]=e;
                    idx++;
                }
            }else{
                if(end2>=start1){
                    int s=Math.max(start1,start2);
                    int e = Math.min(end1,end2);
                    res[idx][0]=s;
                    res[idx][1]=e;
                    idx++;
                }
            }
            if(end1>=end2){
                j++;
            }else{
                i++;
            }
        }
        return Arrays.copyOf(res,idx);
    }
}