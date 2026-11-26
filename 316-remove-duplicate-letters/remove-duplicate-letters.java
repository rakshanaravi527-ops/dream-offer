
class Solution {
    public String removeDuplicateLetters(String s) {

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';

            // Decrease frequency
            freq[index]--;

            // Skip if already present
            if (visited[index]) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                char removed = stack.charAt(stack.length() - 1);

                visited[removed - 'a'] = false;

                stack.deleteCharAt(stack.length() - 1);
            }

            // Add current character
            stack.append(ch);
            visited[index] = true;
        }

        return stack.toString();
    }
}
