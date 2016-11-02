/**
 * Created by lrkin on 2016/10/27.
 */
public class FirstCommonNodesInLists {

    /**
     * 方法一:
     *
     *
     * 伪代码:
     *
     * 遍历,压栈
     * public void transfer2Stack(root){
     *  Stack<Node> stackLong = new Stack<Node>;
     *  Stack<Node> stackShort = new Stack<Node>;
     *  while(rootLong.next){
     *      stackLong.push(rootLong);
     *      rootLong = rootLong.next;
     *  }
     *  while(rootShort.next){
     *      stackShort.push(root.short);
     *      rootShort = rootShort.next;
     *  }
     * }
     *
     * //查找
     * public Node find(node){
     * Node nodeLong = stackLong.pop();
     * Node nodeShort = stackShort.pop();
     * if(nodeLong.data == nodeShort.data){
     *      theNode = nodeLong;
     *      //递归
     *      find(theNode);
     * }else{
     *      return node;
     * }
     *}
     */



}
