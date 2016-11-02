/**
 * Created by lrkin on 2016/10/23.
 */
public class TestTwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] result = twoSum.twoSum(numbers,target);
        System.out.println(result[0]+","+result[1]);
    }
}
