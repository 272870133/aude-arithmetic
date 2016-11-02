/**
 * Created by lrkin on 2016/10/23.
 */
public class BinearySearchTest {


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] sortedData = {1,2,3,4,5,6,7,8,9,10};

        int findValue = 8;

        int position01 = binarySearch.searchRecursive(sortedData , 0 , sortedData.length -1 ,findValue);
        System.out.println("Recursice:"+findValue+" found in pos "+position01+";count:"+binarySearch.getrCount());
        int position02 = binarySearch.searchLoop(sortedData , findValue);
        System.out.println("Loop:"+findValue+" found in pos "+position02+";count:"+binarySearch.getlCount());

    }

}
