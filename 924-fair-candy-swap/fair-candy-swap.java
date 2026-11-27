
import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0;
        int sumB = 0;

        // Calculate Alice's total candies
        for (int x : aliceSizes) {
            sumA += x;
        }

        // Calculate Bob's total candies
        for (int x : bobSizes) {
            sumB += x;
        }

        // Calculate required difference
        int diff = (sumA - sumB) / 2;

        // Store Alice's boxes in HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int x : aliceSizes) {
            set.add(x);
        }

        // Find the matching pair
        for (int y : bobSizes) {

            int x = y + diff;

            if (set.contains(x)) {
                return new int[]{x, y};
            }
        }

        return new int[]{};
    }
}
