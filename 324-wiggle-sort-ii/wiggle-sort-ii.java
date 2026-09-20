import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {

            int n = nums.length;

                    // Make a copy and sort it
                            int[] sorted = nums.clone();
                                    Arrays.sort(sorted);

                                            // Middle of the array
                                                    int mid = (n - 1) / 2;

                                                            // Last element of the array
                                                                    int high = n - 1;

                                                                            // Fill odd indices with larger elements
                                                                                    // Fill even indices with smaller elements
                                                                                            for (int i = 0; i < n; i++) {

                                                                                                        if (i % 2 == 0) {
                                                                                                                        nums[i] = sorted[mid--];
                                                                                                                                    } else {
                                                                                                                                                    nums[i] = sorted[high--];
                                                                                                                                                                }
                                                                                                                                                                        }
                                                                                                                                                                            }
                                                                                                                                                                            }