import java.util.*;

/**
 * peek, just get, not delete 
 * pop, will delete the peek
 */
public class StackPopUp {

    public Boolean isStackPopUpOrder(int[] aNums, int[] bNums, int len) {
        Boolean defaultFlag = false;
        if (aNums == null || bNums == null || len == 0) {
            return defaultFlag;
        }
        Stack<Integer> sk = new Stack<Integer>();
        int a1 = 0;
        int b1 = 0;
        while (b1 < len) {
            if (sk.size() == 0) {
                sk.push(aNums[a1]);
                a1++;
            }
            while (a1 < len) {
                if (sk.peek() == bNums[b1]) {
                    break;
                } else {
                    sk.push(aNums[a1]);
                    a1++;
                }
            }
            if (sk.peek() != bNums[b1]) {
                return false;
            }
            sk.pop();
            b1++;

        }
        if (sk.isEmpty() && a1 == len && b1 == len) {
            return true;
        }
        return defaultFlag;
    }

    public static void main(String[] args) {
        System.out.println(new StackPopUp().isStackPopUpOrder(new int[] {1, 2, 3}, new int[] {3, 2, 1}, 3));
        System.out.println(new StackPopUp().isStackPopUpOrder(new int[] {1, 2, 3}, new int[] {3, 1, 2}, 3));
    }

}
