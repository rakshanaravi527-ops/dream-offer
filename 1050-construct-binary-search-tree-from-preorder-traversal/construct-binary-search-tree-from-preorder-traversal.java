class Solution {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {

        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        int value = preorder[index++];

        TreeNode root = new TreeNode(value);

        root.left = build(preorder, value);

        root.right = build(preorder, bound);

        return root;
    }
}