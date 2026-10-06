import java.util.*;

class Solution {

    HashMap<Integer, Integer> map;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        int index = map.get(rootValue);

        root.right = build(inorder, postorder, index + 1, right);

        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}