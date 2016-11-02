/**
 * Created by lrkin on 2016/10/23.
 * 二分查找
 * BinarySearch
 * <p>
 * 思路:
 * 将数组分为三部分，依次是中值（所谓的中值就是数组中间位置的那个值）前，中值，中值后；
 * 将要查找的值和数组的中值进行比较，若小于中值则在中值前面找，若大于中值则在中值后面找，等于中值时直接返回。
 * 然后依次是一个递归过程，将前半部分或者后半部分继续分解为三部分。可能描述得不是很清楚，若是不理解可以去网上找。
 * 从描述上就可以看出这个算法适合用递归来实现，可以用递归的都可以用循环来实现。
 * 所以我们的实现分为递归和循环两种，可以根据代码来理解算法
 *
 * 总结:
 * 刚开始写这个算法有点糊涂的地方是奇偶数的处理,但是后来发现,这个问题不是问题
 * 也就是说,不需要考虑数组的长度是奇还是偶,(start+end)/2得到的就是middle,前后分出的两个子数组的元素个数一不一样不重要
 * 只需要有middle这个概念就行了,然后无论递归还是循环,只需要middle+1或者middle-1构造新的子数组
 * 想明白这个问题(忽视奇偶数),对其他要用到二分法的算法很有帮助
 *
 */
public class BinarySearch {

    private int rCount = 0;
    private int lCount = 0;


    /**
     * 递归次数获取
     *
     * @return
     */
    public int getrCount() {
        return rCount;
    }

    /**
     * 循环次数获取
     *
     * @return
     */
    public int getlCount() {
        return lCount;
    }

    /**
     * 递归实现
     */


    /**
     * 执行递归二分查找，返回第一次出现该值的位置
     * @param sortedData    已排序的数组
     * @param start         开始位置
     * @param end           结束位置
     * @param findValue     需要找的值
     * @return              值在数组中的位置，从0开始。找不到返回-1
     */
    public int searchRecursive(int[] sortedData,int start,int end,int findValue)
    {
        rCount++;
        if(start<=end)
        {
            //中间位置
            int middle=(start+end)>>1;    //相当于(start+end)/2
            //中值
            int middleValue=sortedData[middle];

            if(findValue==middleValue)
            {
                //等于中值直接返回
                return middle;
            }
            else if(findValue<middleValue)
            {
                //小于中值时在中值前面找
                return searchRecursive(sortedData,start,middle-1,findValue);
            }
            else
            {
                //大于中值在中值后面找
                return searchRecursive(sortedData,middle+1,end,findValue);
            }
        }
        else
        {
            //找不到
            return -1;
        }
    }

    /**
     *
     * @param sortedData
     * @param findValue
     * @return 值在数组中第一次出现的位置
     */
    public int searchLoop(int[] sortedData , int findValue){
        int start = 0;
        int end = sortedData.length - 1;

        while (start <= end){

            lCount ++;

            int middle = (start + end)/2;

            int middleValue = sortedData[middle];

            if (findValue == middleValue){
                return middle;
            }else if(findValue < middleValue){
                end = middle - 1;
            }else if (findValue > middleValue){
                start = middle + 1;
            }
        }

        return -1;
    }


}
