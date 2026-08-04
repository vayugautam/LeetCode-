class Solution {
    public int[][] merge(int[][] intervals) {

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