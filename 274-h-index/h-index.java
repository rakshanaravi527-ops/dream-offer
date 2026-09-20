import java.util.*;

class Solution {
    public int hIndex(int[] citations) {

            Arrays.sort(citations);

                    int n = citations.length;

                            for (int i = 0; i < n; i++) {

                                        // Number of papers from i to n-1
                                                    int papers = n - i;

                                                                // Check if these papers have at least 'papers' citations
                                                                            if (citations[i] >= papers) {
                                                                                            return papers;
                                                                                                        }
                                                                                                                }

                                                                                                                        return 0;
                                                                                                                            }
                                                                                                                            }