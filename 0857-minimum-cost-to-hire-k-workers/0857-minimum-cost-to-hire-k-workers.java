import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        // workers[i] = {quality, wage, wage/quality}
        double[][] workers = new double[n][3];

        for (int i = 0; i < n; i++) {
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
            workers[i][2] = (double) wage[i] / quality[i];
        }

        // Sort by wage/quality ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a[2], b[2]));

        // Max heap based on quality
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        double qualitySum = 0;
        double answer = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int q = (int) workers[i][0];
            double ratio = workers[i][2];

            qualitySum += q;
            pq.offer(q);

            // Keep exactly k workers with minimum total quality
            if (pq.size() > k) {
                qualitySum -= pq.poll();
            }

            // Current worker has the largest ratio in this group
            if (pq.size() == k) {
                answer = Math.min(answer, qualitySum * ratio);
            }
        }

        return answer;
    }
}