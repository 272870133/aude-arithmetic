/**
 * Created by lrkin on 2016/10/26.
 * <p>
 * 快速排序
 */
public class QuickSort {

    public static void quick_sort(int[] array) {

        int length = array.length;

        _quick_sort(array, 0, length - 1);
    }

    public static void _quick_sort(int[] array, int start, int end) {
        if(start>=end){
            return;
        }
        int key = array[start];
        int i = start;
        int j = end;
        boolean flag = false;
        while (i != j) {
            //flag为true,则移动左边(左边和右边比较,key在右边)
            if (flag) {
                if (key < array[i]) {
                    swap(array, i, j);
                    flag = false;
                } else {
                    i++;
                }
            } else {
                //flag为false,则移动右边(右边和左边比较,key在左边)
                if (key > array[j]) {
                    swap(array, i, j);
                    flag = true;
                } else {
                    j--;
                }
            }
        }
        //打印
        snp(array);
        System.out.println("");
        //递归
        _quick_sort(array, start, j - 1);
        _quick_sort(array, i + 1, end);

    }

    private static void snp(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"-");
        }
    }

    private static void swap(int[] arrays, int i, int j) {
        int temp;
        temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args) {

        int[] array = {23, 12, 56, 3, 5, 44, 78};

        quick_sort(array);
    }
}
