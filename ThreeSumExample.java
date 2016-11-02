import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lrkin on 2016/10/28.
 */
public class ThreeSumExample {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int begin = i + 1, end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    res.add(list);
                    begin++;
                    end--;
                    while (begin < end && nums[begin] == nums[begin - 1]) begin++;
                    while (begin < end && nums[end] == nums[end + 1]) end--;
                } else if (sum > 0) end--;
                else begin++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-1, -1, 0, 0, 0, 1, 2, -1, -4};
//        int[] array = {-1 ,-1 ,0 ,0 ,1 ,2, -1, -4};
//        int[] array = {-1 ,0, 1, 2, -1, -4};
        ThreeSumExample threeSum = new ThreeSumExample();
        int key = 0;
        List<List<Integer>> result = threeSum.threeSum(array);
        for (List<Integer> item : result) {
                for (Integer num : item){
                    System.out.print(num+"");
                }
                System.out.println("");
            }
            System.out.println("");
        }
}
