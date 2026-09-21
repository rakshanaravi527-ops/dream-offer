class Solution {
        public double myPow(double x, int n) {

                // Handle negative exponent
                        if (n < 0) {
                                    x = 1 / x;
                                            }

                                                    // Convert to long to handle Integer.MIN_VALUE
                                                            long power = n;

                                                                    if (power < 0) {
                                                                                power = -power;
                                                                                        }

                                                                                                return powerHelper(x, power);
                                                                                                    }

                                                                                                        private double powerHelper(double x, long n) {

                                                                                                                // Base case
                                                                                                                        if (n == 0) {
                                                                                                                                    return 1.0;
                                                                                                                                            }

                                                                                                                                                    // Recursively calculate x^(n/2)
                                                                                                                                                            double half = powerHelper(x, n / 2);

                                                                                                                                                                    // Even exponent
                                                                                                                                                                            if (n % 2 == 0) {
                                                                                                                                                                                        return half * half;
                                                                                                                                                                                                }

                                                                                                                                                                                                        // Odd exponent
                                                                                                                                                                                                                return x * half * half;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    }
