import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lrkin on 2016/10/23.
 * <p>
 * 题目:
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 ,-1 ,0 ,0 ,1 ,2, -1, -4},
 * <p>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum {

    public ArrayList<int[]> threeSum(int[] array, int key) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {

            if ((i + 2) <= array.length && (i-1) >=0 && array[i] == array[i-1]) {
                continue;
            }

            int diff = key - array[i];
            ArrayList<int[]> oneResult = twoSum(array, i+1, array.length, diff);
            if (oneResult.size() != 0) {
                for (int[] item : oneResult) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    private ArrayList<int[]> twoSum(int[] array, int start, int end, int diff) {
        ArrayList<int[]> result = new ArrayList<>();
        if (start <= end) {
            for (int j = start; j < end; j++) {
                if ((j + 1) <= end - 1 && (j-1) >= 0 && array[j] == array[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < end; k++) {
                    if ((k + 1) <= end - 1 && (k-1) >=0 && array[k] == array[k + 1]) {
                        continue;
                    }
                    if ((array[j] + array[k]) == diff) {
                        int[] arr = {array[start], array[j], array[k]};
                        result.add(arr);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1, -1, 0, 0, 0, 1, 2, -1, -4};
//        int[] array = {-1 ,-1 ,0 ,0 ,1 ,2, -1, -4};
//        int[] array = {-1 ,0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        int key = 0;
        ArrayList<int[]> result = threeSum.threeSum(array, key);
        for (int[] item : result) {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + " ");
            }
            System.out.println("");
        }
    }
}
