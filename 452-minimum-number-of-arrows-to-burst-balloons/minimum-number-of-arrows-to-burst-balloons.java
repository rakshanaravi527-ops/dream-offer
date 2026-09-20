import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {

            // Sort by ending position
                    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

                            int arrows = 1;

                                    // Position of the first arrow
                                            int arrowPosition = points[0][1];

                                                    for (int i = 1; i < points.length; i++) {

                                                                // Current balloon cannot be burst
                                                                            // by the previous arrow
                                                                                        if (points[i][0] > arrowPosition) {

                                                                                                        arrows++;

                                                                                                                        // Shoot a new arrow at the end
                                                                                                                                        // of the current balloon
                                                                                                                                                        arrowPosition = points[i][1];
                                                                                                                                                                    }
                                                                                                                                                                            }

                                                                                                                                                                                    return arrows;
                                                                                                                                                                                        }
                                                                                                                                                                                        }