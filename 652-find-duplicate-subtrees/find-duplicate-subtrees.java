
import java.util.*;

class Solution {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {

        if (node == null) {
            return "#";
        }

        String left = serialize(node.left);
        String right = serialize(node.right);

        String key = node.val + "," + left + "," + right;

        int count = map.getOrDefault(key, 0);

        if (count == 1) {
            result.add(node);
        }

        map.put(key, count + 1);

        return key;
    }
}
