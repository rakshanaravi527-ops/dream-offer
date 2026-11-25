
import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;

        // Store starting point and original index
        int[][] starts = new int[n][2];

        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // Sort by starting point
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];

        // Find the right interval for each interval
        for (int i = 0; i < n; i++) {

            int target = intervals[i][1];

            int left = 0;
            int right = n - 1;
            int answer = -1;

            // Binary search
            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (starts[mid][0] >= target) {
                    answer = starts[mid][1];
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            result[i] = answer;
        }

        return result;
    }
}
