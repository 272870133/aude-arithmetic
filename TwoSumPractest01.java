import java.util.Hashtable;

/**
 * Created by lrkin on 2016/10/28.
 */
public class TwoSumPractest01 {

    public void twoSum(int[] array, int key) {

        Hashtable<Integer, Integer> hashTable
                = new Hashtable<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            hashTable.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            int diff = key - array[i];
            if (hashTable.get(diff) != null) {
                int[] result = {array[i], array[hashTable.get(diff)] , i , hashTable.get(diff)};
                for (int j = 0; j < result.length; j++) {
                    System.out.print(result[j] + "-");
//                    break;
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        TwoSumPractest01 twoSumPractest01 = new TwoSumPractest01();
        int[] array = {6, 4,4,3, 3, 10,10, 8, 12};
        twoSumPractest01.twoSum(array, 13);
    }

}
