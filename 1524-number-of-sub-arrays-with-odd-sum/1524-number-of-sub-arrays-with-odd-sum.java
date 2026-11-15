class Solution {
    public int numOfSubarrays(int[] arr) {
        int even = 1;
        int odd = 0;
        long ans = 0;
        int prefix = 0;
        int MOD = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];

            if (prefix % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
        }
        return (int)(ans % MOD);
    }
}