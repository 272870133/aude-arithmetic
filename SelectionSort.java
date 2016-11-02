/**
 * Created by lrkin on 2016/10/27.
 * <p>
 * 选择排序
 */
public class SelectionSort {

    public void selectSort(int[] array) {

        int i, j, k = 0;

        for (i = 0; i < array.length - 1; i++) {

            k = i;

            for (j = i + 1; j < array.length; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = array[k];
                array[k] = array[i];
                array[i] = temp;
            }
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "-");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {4, 3, 12, 6, 8, 15, 10};
        selectionSort.print(array);
        selectionSort.selectSort(array);
        selectionSort.print(array);
    }

}
