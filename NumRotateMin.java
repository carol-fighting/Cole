/**
 * 2,3,4,5,6,7 to 5,6,7,2,3,4 
 * then we find that 2 is the fist Not Incrementing Element
 */
public class NumRotateMin {

    public int getMinInRotateNum(int[] nums) {
        int m = 0;
        int a1 = 0;
        int a2 = nums.length - 1;
        while (nums[a1] >= nums[a2]) {
            m = (a1 + a2) / 2;
            if (a2 - a1 == 1) {
                m = a2;
                break;
            }
            if (nums[a1] == nums[m] && nums[m] == nums[a2]) {
                return getMinISeqNum(nums, a1, a2);
            }
            if (nums[m] >= nums[a1]) {
                a1 = m;
                continue;
            }
            if (nums[m] <= nums[a2]) {
                a2 = m;
            }
        }
        return nums[m];
    }

    private int getMinISeqNum(int []nums,int a1,int a2){
        int minValue=Integer.MAX_VALUE;
        for (int i=a1;i<a2;i++){
            if (nums[i]<minValue){
                minValue=nums[i];
            }
        }
        return minValue;
    }

    public static void main(String []args){
        System.out.println(new NumRotateMin().getMinInRotateNum(new int[]{5, 6, 7, 2, 3, 4}));
    }

}
