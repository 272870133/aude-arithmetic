/**
 * Created by lrkin on 2016/10/27.
 */
public class QuickSortPractest {

    public void quickSort(int[] array) {
        _quickSort(array, 0, array.length - 1);
    }

    public void _quickSort(int[] array, int start, int end) {
        if (array == null) {
            return;
        }

        if(start>=end){
            return;
        }

        boolean flag = false;
        int key = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            if (flag) {
                if (array[i] > key) {
                    swap(array, i, j);
                    flag = false;
                } else {
                    i++;
                }
            } else {
                if (array[j] < key) {
                    swap(array, i, j);
                    flag = true;
                } else {
                    j--;
                }
            }
        }

        _quickSort(array, start, j - 1);
        _quickSort(array, i + 1, end);

    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {

        int[] array = {14, 2, 5, 25, 33, 6};
        QuickSortPractest practest = new QuickSortPractest();
        practest.quickSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "-");
        }

    }


}
