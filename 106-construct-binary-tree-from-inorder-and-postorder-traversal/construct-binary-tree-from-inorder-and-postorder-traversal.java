import java.util.HashMap;

class Solution {

    private int postorderIndex;
        private HashMap<Integer, Integer> inorderMap;

            public TreeNode buildTree(int[] inorder, int[] postorder) {

                    inorderMap = new HashMap<>();

                            // Store inorder value -> index
                                    for (int i = 0; i < inorder.length; i++) {
                                                inorderMap.put(inorder[i], i);
                                                        }

                                                                // Start from the last element of postorder
                                                                        postorderIndex = postorder.length - 1;

                                                                                return build(postorder, 0, inorder.length - 1);
                                                                                    }

                                                                                        private TreeNode build(int[] postorder, int left, int right) {

                                                                                                // Base case
                                                                                                        if (left > right) {
                                                                                                                    return null;
                                                                                                                            }

                                                                                                                                    // Last element of postorder is the root
                                                                                                                                            int rootValue = postorder[postorderIndex--];

                                                                                                                                                    TreeNode root = new TreeNode(rootValue);

                                                                                                                                                            // Find root in inorder
                                                                                                                                                                    int rootIndex = inorderMap.get(rootValue);

                                                                                                                                                                            // IMPORTANT:
                                                                                                                                                                                    // Build right subtree first
                                                                                                                                                                                            root.right = build(postorder, rootIndex + 1, right);

                                                                                                                                                                                                    // Then build left subtree
                                                                                                                                                                                                            root.left = build(postorder, left, rootIndex - 1);

                                                                                                                                                                                                                    return root;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        }