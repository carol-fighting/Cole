/**
 * all elements's value art in [0,n-1]
 */

public class NumDuplicatedValue {
    public Boolean isDuplicated(int[] nums) {
        Boolean defaultFlag = false;
        if (nums == null || nums.length == 0) {
            return defaultFlag;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] != nums[nums[i]]) {
                    swapAtIndex(i, nums);
                } else {
                    return true;
                }
            }
        }
        return defaultFlag;
    }

    public void swapAtIndex(int i, int[] nums) {
        int m = nums[i];
        nums[i] = nums[nums[i]];
        nums[nums[i]] = m;
    }

    public static void main(String[] args) {
        System.out.println(new NumDuplicatedValue().isDuplicated(new int[] {0, 1, 2, 1}));
        System.out.println(new NumDuplicatedValue().isDuplicated(new int[] {0, 1, 2, 3}));

    }
}
