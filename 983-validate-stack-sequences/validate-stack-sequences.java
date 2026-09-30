import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for (int value : pushed) {

            // Push the value
            stack.push(value);

            // Pop whenever the top matches popped[j]
            while (!stack.isEmpty() &&
                   j < popped.length &&
                   stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}