
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int difference = gas[i] - cost[i];

            totalGas += difference;
            currentGas += difference;

            // Current starting point is not possible
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        // Check whether completing the circuit is possible
        if (totalGas < 0) {
            return -1;
        }

        return start;
    }
}
