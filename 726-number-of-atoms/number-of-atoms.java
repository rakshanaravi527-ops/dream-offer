
import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {

        Stack<Map<String, Integer>> stack = new Stack<>();

        stack.push(new HashMap<>());

        int i = 0;
        int n = formula.length();

        while (i < n) {

            char ch = formula.charAt(i);

            // Case 1: Opening parenthesis
            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            }

            // Case 2: Closing parenthesis
            else if (ch == ')') {

                Map<String, Integer> top = stack.pop();
                i++;

                int start = i;

                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }

                int multiplier = start == i ? 1 :
                    Integer.parseInt(formula.substring(start, i));

                for (String atom : top.keySet()) {

                    int count = top.get(atom) * multiplier;

                    stack.peek().put(
                        atom,
                        stack.peek().getOrDefault(atom, 0) + count
                    );
                }
            }

            // Case 3: Element name
            else {

                int start = i;
                i++;

                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }

                String atom = formula.substring(start, i);

                // Read element count
                start = i;

                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }

                int count = start == i ? 1 :
                    Integer.parseInt(formula.substring(start, i));

                stack.peek().put(
                    atom,
                    stack.peek().getOrDefault(atom, 0) + count
                );
            }
        }

        // Sort atoms alphabetically
        TreeMap<String, Integer> sorted = new TreeMap<>(stack.pop());

        // Build final answer
        StringBuilder result = new StringBuilder();

        for (String atom : sorted.keySet()) {

            result.append(atom);

            int count = sorted.get(atom);

            if (count > 1) {
                result.append(count);
            }
        }

        return result.toString();
    }
}
