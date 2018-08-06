import java.util.*;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val){
        this.val=val;
    }
    public  List<List<Integer>> finalList=new ArrayList<List<Integer>>();
    public  List<Integer> path=new ArrayList<Integer>();

}
