class Solution {
        public boolean isPerfectSquare(int num) {
                int left = 1;
                        int right = num;

                                while (left <= right) {
                                            int mid = left + (right - left) / 2;

                                                        // Avoid integer overflow
                                                                    if (mid == num / mid && num % mid == 0) {
                                                                                    return true;
                                                                                                }

                                                                                                            if (mid < num / mid) {
                                                                                                                            // mid * mid < num
                                                                                                                                            left = mid + 1;
                                                                                                                                                        } else {
                                                                                                                                                                        // mid * mid > num
                                                                                                                                                                                        right = mid - 1;
                                                                                                                                                                                                    }
                                                                                                                                                                                                            }

                                                                                                                                                                                                                    return false;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        }
