public class TreeMirror {
    // dfs

    public static void doMirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            doMirror(root.left);
        }
        if (root.right != null) {
            doMirror(root.right);
        }
    }
