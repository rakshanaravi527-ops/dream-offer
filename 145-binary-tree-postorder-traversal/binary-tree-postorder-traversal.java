class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {

                List<Integer> result = new ArrayList<>();

                        postorder(root, result);

                                return result;
                                    }

                                        public void postorder(TreeNode root, List<Integer> result) {

                                                if (root == null) {
                                                            return;
                                                                    }

                                                                            // Visit left subtree
                                                                                    postorder(root.left, result);

                                                                                            // Visit right subtree
                                                                                                    postorder(root.right, result);

                                                                                                            // Visit root
                                                                                                                    result.add(root.val);
                                                                                                                        }
                                                                                                                        }
