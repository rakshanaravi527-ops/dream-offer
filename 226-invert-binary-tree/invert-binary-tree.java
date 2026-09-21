class Solution {
        public TreeNode invertTree(TreeNode root) {

                // Base case
                        if (root == null) {
                                    return null;
                                            }

                                                    // Swap left and right children
                                                            TreeNode temp = root.left;
                                                                    root.left = root.right;
                                                                            root.right = temp;

                                                                                    // Recursively invert left subtree
                                                                                            invertTree(root.left);

                                                                                                    // Recursively invert right subtree
                                                                                                            invertTree(root.right);

                                                                                                                    return root;
                                                                                                                        }
                                                                                                                        }
