/*
 * From str to Tree with two Arrays: TreeNode[] ansList; int []epyCnt
 */

public class DeserializeUtil {

    public TreeNode toTree(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] nums = str.split(",");
        int len = nums.length;
        int[] epyCnt = new int[len];
        epyCnt[0] = 0;
        TreeNode[] ansList = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                epyCnt[i] = epyCnt[i - 1];
            }
            if ("null".equals(nums[i])) {
                ansList[i] = null;
                epyCnt[i]++;
            } else {
                ansList[i] = new TreeNode(Integer.parseInt(nums[i]));
            }
        }
        for (int i = 0; i < len; i++) {
            if (ansList[i] != null) {
                int leftChildIndex = 2 * (i - epyCnt[i]) + 1;
                int rightChildIndex = 2 * (i - epyCnt[i]) + 2;
                if (leftChildIndex < len) {
                    ansList[i].left = ansList[leftChildIndex];
                }
                if (rightChildIndex < len) {
                    ansList[i].right = ansList[rightChildIndex];
                }
            }
        }
        return ansList[0];
    }
}
