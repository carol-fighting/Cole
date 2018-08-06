
import java.util.*;

/**
 * queue=LinkedList
 * 
 * From TreeNode to List<List<String>>
 */

public class SerializeUtil {

    public List<List> toListWithNull(TreeNode root) {
        List<List> fList = new ArrayList<>();
        if (root == null) {
            return null;
        }
        List<Integer> currList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nowCnt = 1;
        int nextCnt = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            Integer currInt = 0;
            if (curr != null) {
                currInt = curr.val;
                nextCnt++;
                queue.add(curr.left);
                nextCnt++;
                queue.add(curr.right);
            }
            currList.add(currInt);
            nowCnt--;
            if (nowCnt == 0) {
                nowCnt = nextCnt;
                nextCnt = 0;
                fList.add(new ArrayList(currList));
                currList.clear();
            }
        }
        return fList;
    }
}
