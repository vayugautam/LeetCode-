class Solution {
    public int maxProduct(int n) {
        int maxd = -1;
        int secmaxd = -1;
        while (n > 0) {
            int rem = n % 10;
            if (rem >= maxd) {
                secmaxd = maxd;
                maxd = rem;
            } else if (rem > secmaxd) {
                secmaxd = rem;
            }
            n /= 10;
        }
        return maxd * secmaxd;
    }
}