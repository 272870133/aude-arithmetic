import java.util.HashMap;
import java.util.Map;

/**
 * Created by lrkin on 2016/10/23.
 *
 *
 *
 * 题干:
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 *
 *
 * 给定一个整数数组，找到两个数，使得它们的和等于一个特定的目标数。
 函数twoSum应返回两个数的索引（index），使它们加起来等于目标，其中索引1必须小于索引2。注意返回的答案（包括索引1和索引2 ）不是从零开始的。
 可以假设每个输入有且仅有一个答案。
 输入：数字 = {2,7,11,15}，目标 = 9
 输出：索引1 = 1，索引2 = 2

 *
 * 思路:
 * 第一想法，拿到输入后，暴力搜索，时间复杂度为O(n*n)，很简单，但是会出现超时错误。
 显然，时间复杂度需要再降低才行。看过别人的题解后，使用了Java中的Map，利用HashMap，存储数组中的值和Index，由于HashMap中查询键值对的开销是固定的，因此在性能上可以得到很大的提升。
 对输入先构建HashMap，对于HashMap需要考虑，用什么做key，什么做value。题目中要求求两者的和，显然，用数组值做index来检索index是合理恰当的设置。遍历数组，构建这样的HashMap。
 第二遍遍历数组，对每个值value_i，在HashMap中查找是否存在对应的target-value_i，若存在，根据这个key找到对应的value值，即得到要找的两个index。由于数组遍历的顺序是由小到大，因此得到的map中的index2必然大于index1。
 需要注意的一个小细节是，在HashMap中进行查找时，要避免出现index1和index2相等的情况。

 * 总结:
 * 关键点是hashmap,不仅可以降低复杂度,还可以解题...即用数组值做key,数组索引值做value
 */
public class TwoSum {

    public int[] twoSum(int[] numbers , int target){
        int[] result = new int[2];

        Map map = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i] , i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int gap = target - numbers[i];
            if ((map.get(gap) != null) && ((int)map.get(gap) != i)){
                result[0] = i+1;
                result[1] = (int)map.get(gap)+1;
                break;
            }
        }
        return result;
    }

}
