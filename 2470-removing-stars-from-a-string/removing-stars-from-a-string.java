import java.util.*;

class Solution {
    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '*') {
                // Remove the closest character on the left
                stack.pop();
            } else {
                // Add normal character
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}