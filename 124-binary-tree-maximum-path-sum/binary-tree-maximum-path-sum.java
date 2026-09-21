class Solution {

        int maxSum = Integer.MIN_VALUE;

            public int maxPathSum(TreeNode root) {
                    maxGain(root);
                            return maxSum;
                                }

                                    private int maxGain(TreeNode node) {

                                            // Base case
                                                    if (node == null) {
                                                                return 0;
                                                                        }

                                                                                // Maximum gain from left subtree
                                                                                        int leftGain = Math.max(0, maxGain(node.left));

                                                                                                // Maximum gain from right subtree
                                                                                                        int rightGain = Math.max(0, maxGain(node.right));

                                                                                                                // Path passing through current node
                                                                                                                        int currentPath = node.val + leftGain + rightGain;

                                                                                                                                // Update global maximum
                                                                                                                                        maxSum = Math.max(maxSum, currentPath);

                                                                                                                                                // Return the maximum one-side path
                                                                                                                                                        return node.val + Math.max(leftGain, rightGain);
                                                                                                                                                            }
                                                                                                                                                            }
