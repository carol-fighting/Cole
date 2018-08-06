/**
 * root left right a1,a2
 * left root right b1,b2
 * 
 * root left =a1+1 (a1+1)+(m-1-b1)
 * left root =(b1,m-1)
 * 
 * root right=a2-(b2-m-1),a2
 * root right=(m+1,b2)
 */

public class TreeBuild {

    private int findIndex(int rootValue, int[] bNum, int b1, int b2) {
        for (int i = b1; i <= b2; i++) {
            if (rootValue == bNum[i]) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode reBuild(int a1, int a2, int b1, int b2, int[] aNum, int[] bNum) {
        int rootVal = aNum[a1];
        TreeNode root = new TreeNode(rootVal);
        if (a1 == a2 && b1 == b2) {
            return root;
        }
        int m = findIndex(rootVal, bNum, b1, b2);
        root.left = reBuild(a1 + 1, (a1 + 1) + (m - 1 - b1), b1, m - 1, aNum, bNum);
        root.right = reBuild(a2 - (b2 - m - 1), a2, m + 1, b2, aNum, bNum);
        return root;
    }

    public static void main(String []args){
        TreeNode tree=new TreeBuild().reBuild(0, 6, 0, 6, new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7});
        System.out.println(new SerializeUtil().toListWithNull(tree));
    }

}
