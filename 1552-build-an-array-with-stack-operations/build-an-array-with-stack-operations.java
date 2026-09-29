import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> result = new ArrayList<>();

        int index = 0;

        for (int num = 1; num <= n && index < target.length; num++) {

            // Every number from the stream must be pushed
            result.add("Push");

            // If this number is not needed, remove it
            if (num != target[index]) {
                result.add("Pop");
            } else {
                // This number belongs to target
                index++;
            }
        }

        return result;
    }
}