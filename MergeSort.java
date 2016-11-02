/**
 * Created by lrkin on 2016/10/28.
 * <p>
 * <p>
 * 归并排序
 */
public class MergeSort {

    public void mergeSort(int[] array, int start, int end) {
        int middle = (start + end) / 2;
        if (start < end) {
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public void merge(int[] array, int start, int middle, int end) {
        int length = end - start;
        int[] temp = new int[length + 1];
        int i = start;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= end) {
            if (array[i] > array[j]) {
                temp[k++] = array[j++];
            }

            else  {
                temp[k++] = array[i++];
            }
        }
//        temp[length-1] = (i == middle) ? array[middle] : array[end];
        while (i <= middle) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            array[l + start] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 4, 2, 8, 6, 10, 15, 6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "-");

        }
    }
}
