public class TreeSub {

    private Boolean isSame(TreeNode rootA, TreeNode rootB) {
        Boolean defaultFlag = false;
        if (rootA == null && rootB == null) {
            return true;
        }
        if (rootA == null || rootB == null || rootA.val != rootB.val) {
            return defaultFlag;
        }
        return isSame(rootA.left, rootB.left) && isSame(rootA.right, rootB.right);
    }

    public Boolean isSub(TreeNode rootA, TreeNode rootB) {
        Boolean defaultFlag = false;
        if (rootA == null || rootB == null) {
            return defaultFlag;
        }
        if (rootA.val == rootB.val) {
            defaultFlag = isSame(rootA, rootB);
        }
        if (!defaultFlag) {
            defaultFlag = isSub(rootA.left, rootB);
        }
        if (!defaultFlag) {
            defaultFlag = isSub(rootA.right, rootB);
        }
        return defaultFlag;
    }

    public static void main(String[] args) {
        System.out.println(new TreeSub().isSub(new DeserializeUtil().toTree("1,2,3,4,5,6,7"),
            new DeserializeUtil().toTree("2,4,5")));
        System.out.println(new TreeSub().isSub(new DeserializeUtil().toTree("1,2,3,4,5,6,7"),
            new DeserializeUtil().toTree("3,6,7")));
        System.out.println(new TreeSub().isSub(new DeserializeUtil().toTree("1,2,3,4,5,6,7"),
            new DeserializeUtil().toTree("3,4,5")));
        System.out.println(new TreeSub().isSub(new DeserializeUtil().toTree("1,2,3,4,5,6,7"),
            new DeserializeUtil().toTree("1,2,3")));
    }

}
