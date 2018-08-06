import java.util.*;

public class TreePath {
    // dfs with List<String>path

    public static void findPath(TreeNode root, int target, List onePath, List<List> allPath) {
        if (root == null) {
            return;
        }

        onePath.add(root.val);
        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null) {
            allPath.add(new ArrayList<Integer>(onePath));
        }

        if (root.left != null) {
            findPath(root.left, target, onePath, allPath);
        }
        if (root.right != null) {
            findPath(root.right, target, onePath, allPath);
        }

        onePath.remove(onePath.size() - 1);
    }
}
