class Solution {
        public int findPeakElement(int[] nums) {
                int left = 0;
                        int right = nums.length - 1;

                                while (left < right) {
                                            int mid = left + (right - left) / 2;

                                                        if (nums[mid] > nums[mid + 1]) {
                                                                        // We are on the decreasing side.
                                                                                        // mid could be a peak.
                                                                                                        right = mid;
                                                                                                                    } else {
                                                                                                                                    // We are on the increasing side.
                                                                                                                                                    // A peak must exist to the right.
                                                                                                                                                                    left = mid + 1;
                                                                                                                                                                                }
                                                                                                                                                                                        }

                                                                                                                                                                                                return left;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    }
