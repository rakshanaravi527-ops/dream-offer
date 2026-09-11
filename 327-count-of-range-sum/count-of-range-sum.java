
         class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, n + 1, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right,
                          int lower, int upper) {

        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        count += mergeSort(prefix, left, mid, lower, upper);
        count += mergeSort(prefix, mid, right, lower, upper);

        int low = mid;
        int high = mid;

        for (int i = left; i < mid; i++) {

            while (low < right &&
                   prefix[low] - prefix[i] < lower) {
                low++;
            }

            while (high < right &&
                   prefix[high] - prefix[i] <= upper) {
                high++;
            }

            count += high - low;
        }

        long[] temp = new long[right - left];

        int i = left;
        int j = mid;
        int index = 0;

        while (i < mid && j < right) {

            if (prefix[i] <= prefix[j]) {
                temp[index++] = prefix[i++];
            } else {
                temp[index++] = prefix[j++];
            }
        }

        while (i < mid) {
            temp[index++] = prefix[i++];
        }

        while (j < right) {
            temp[index++] = prefix[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            prefix[left + k] = temp[k];
        }

        return count;
    }
}
   