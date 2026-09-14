class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }

        return upperCount == 0 ||
               upperCount == word.length() ||
               (upperCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}