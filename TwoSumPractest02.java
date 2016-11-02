import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lrkin on 2016/10/28.
 * <p>
 * 题目:
 * <p>
 * {-2,0,4,4,3,3,9,8,12}
 * <p>
 * key = 7
 * <p>
 * 输出:
 * <p>
 * (-2 , 9)
 * (3,4)
 */
public class TwoSumPractest02 {

    public ArrayList<int[]> twoSum(int[] array, int key) {

        ArrayList<int[]> result = new ArrayList<int[]>();

        for (int i = 0; i < array.length; i++) {
            if ((i + 1) <= array.length - 1 && array[i] == array[i + 1]) {
                continue;
            }
            for (int k = i; k < array.length; k++) {
                if ((k + 1) <= array.length - 1 && array[k] == array[k + 1]) {
                    continue;
                }
                if ((array[i] + array[k]) == key) {
                    int[] arr = {array[i], array[k]};
                    result.add(arr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumPractest02 twoSumPractest02 = new TwoSumPractest02();
        int[] array = {-2, 0, 4, 4, 3, 3, 9, 8, 12};
        int key = 7;
        ArrayList<int[]> result = twoSumPractest02.twoSum(array, key);
        for (int[] item : result) {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + "-");
            }
            System.out.println("");
        }
    }

}
