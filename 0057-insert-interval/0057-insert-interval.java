class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] res = new int[intervals.length + 1][2];

        int i = 0; // intervals pointer
        int j = 0; // result pointer
        boolean inserted = false;

        while (i < intervals.length) {

            if (!inserted && intervals[i][0] >= newInterval[0]) {
                res[j++] = newInterval;
                inserted = true;
            }

            res[j++] = intervals[i++];
        }

        // If newInterval belongs at the end
        if (!inserted) {
            res[j++] = newInterval;
        }
        return merge(res);
    }
    int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int[][] res = new int[n][2];

        int idx = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res[idx][0] = start;
                res[idx][1] = end;
                idx++;

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // Add the last merged interval
        res[idx][0] = start;
        res[idx][1] = end;
        idx++;
        return Arrays.copyOf(res, idx);
    }
}