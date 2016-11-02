/**
 * Created by lrkin on 2016/10/27.
 *
 * 插入排序
 */
public class InsertionSort {

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"-");
        }
    }

    public void insertSort(int[] array) {

        int temp , i ,j;

        for (i = 1; i < array.length; i++) {

            temp = array[i];

            for (j = i - 1; j >= 0 && array[j] > temp ; j--) {
                array[j+1] = array[j];
            }

            array[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {3,12,4,53,33,22};
        insertionSort.print(array);
        insertionSort.insertSort(array);
        System.out.println("");
        insertionSort.print(array);
    }
}
