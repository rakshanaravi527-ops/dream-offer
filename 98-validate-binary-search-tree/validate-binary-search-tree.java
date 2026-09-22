class Solution {
        public boolean isValidBST(TreeNode root) {
                return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
                    }

                        public boolean check(TreeNode root, long min, long max) {

                                if (root == null) {
                                            return true;
                                                    }

                                                            // Node must be strictly inside the range
                                                                    if (root.val <= min || root.val >= max) {
                                                                                return false;
                                                                                        }

                                                                                                // Left subtree: values must be smaller
                                                                                                        // Right subtree: values must be greater
                                                                                                                return check(root.left, min, root.val) &&
                                                                                                                               check(root.right, root.val, max);
                                                                                                                                   }
                                                                                                                                   }
