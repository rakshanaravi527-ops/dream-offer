class Solution {
    public String removeOccurrences(String s, String part) {

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            stack.append(ch);

            if (stack.length() >= part.length()) {

                int start = stack.length() - part.length();

                if (stack.substring(start).equals(part)) {
                    stack.delete(start, stack.length());
                }
            }
        }

        return stack.toString();
    }
}