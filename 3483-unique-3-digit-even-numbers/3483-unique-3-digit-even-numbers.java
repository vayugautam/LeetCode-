import java.util.*;

class Solution {

    void solve(int[] digits, boolean[] used, int num, int pos, Set<Integer> set) {

        // We have formed a 3-digit number
        if (pos == 3) {
            set.add(num);
            return;
        }

        for (int i = 0; i < digits.length; i++) {

            // This digit occurrence is already used
            if (used[i]) {
                continue;
            }

            // First digit cannot be 0
            if (pos == 0 && digits[i] == 0) {
                continue;
            }

            // Last digit must be even
            if (pos == 2 && digits[i] % 2 != 0) {
                continue;
            }

            // Choose
            used[i] = true;

            solve(
                digits,
                used,
                num * 10 + digits[i],
                pos + 1,
                set
            );

            // Backtrack
            used[i] = false;
        }
    }

    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        boolean[] used = new boolean[digits.length];

        solve(digits, used, 0, 0, set);

        return set.size();
    }
}