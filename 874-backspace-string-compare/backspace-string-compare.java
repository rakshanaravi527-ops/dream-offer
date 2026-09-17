class Solution {
    public boolean backspaceCompare(String s, String t) {
        String a = buildString(s);
        String b = buildString(t);

        return a.equals(b);
    }

    private String buildString(String s) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '#') {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}