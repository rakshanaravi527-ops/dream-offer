
import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }

            deque.addFirst(deck[i]);
        }

        int[] result = new int[deck.length];

        for (int i = 0; i < deck.length; i++) {
            result[i] = deque.removeFirst();
        }

        return result;
    }
}

