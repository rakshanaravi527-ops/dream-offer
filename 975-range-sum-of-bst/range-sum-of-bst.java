class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {

                if (root == null) {
                            return 0;
                                    }

                                            // Root is smaller than the range
                                                    // So only search the right subtree
                                                            if (root.val < low) {
                                                                        return rangeSumBST(root.right, low, high);
                                                                                }

                                                                                        // Root is larger than the range
                                                                                                // So only search the left subtree
                                                                                                        if (root.val > high) {
                                                                                                                    return rangeSumBST(root.left, low, high);
                                                                                                                            }

                                                                                                                                    // Root is inside the range
                                                                                                                                            return root.val
                                                                                                                                                            + rangeSumBST(root.left, low, high)
                                                                                                                                                                            + rangeSumBST(root.right, low, high);
                                                                                                                                                                                }
                                                                                                                                                                                }
