import java.util.*;

class Solution {
    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> values = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int n = values.size();
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   values.get(i) > values.get(stack.peek())) {

                int index = stack.pop();
                answer[index] = values.get(i);
            }

            stack.push(i);
        }

        return answer;
    }
}