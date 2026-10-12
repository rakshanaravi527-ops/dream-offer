
import java.util.*;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        int total = 0;

        for (int pile : piles) {
            maxHeap.offer(pile);
            total += pile;
        }

        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll();

            int removed = largest / 2;
            int remaining = largest - removed;

            total -= removed;
            maxHeap.offer(remaining);
        }

        return total;
    }
}
