/**
 * Created by lrkin on 2016/10/24.
 *
 * 总结:
 * 对单向链表的各种操作,关键点是swap交换,用到临时变量
 */
public class LinkedList {

    private static class Node {
        private String key;
        private Node next;

        public Node(String key){
            this.key = key;
            this.next = null;
        }

        public Node(String key , Node next){
            this.key = key;
            this.next = next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public String getKey(){
            return key;
        }
    }

    private Node head = null;//头节点
    private Node tail = null;//尾节点(空节点)作为临时节点用来起替换作用

    /**
     * 初始化一个链表
     * @param node
     */
    public void initList(Node node){
        head = node;
        head.next = tail;
    }

    /**
     * 添加节点
     * @param node
     */
    public void addNode(Node node){
        if (head == null){
            initList(node);
        }else {
            //替换头部
            Node temp = head;
            head = node;
            node.next = temp;
        }
    }

    /**
     * 删除节点
     * @param node
     * @param myList
     */
    public void deleteNode(Node node , LinkedList myList){
        if (myList == null){
            return;
        }
        Node tmp = null;
        for (tmp = myList.head ; tmp != null ; tmp = tmp.next){
            if (tmp.next != null && node.getKey().equals(tmp.next.getKey())){
                if (tmp.next.next != null){
                    tmp.next = tmp.next.next;
                }else {
                    tmp.next = null;
                }
            }
        }
    }

    public Node getHead(){
        return head;
    }

    /**
     * 打印链表
     * @param myList
     */
    public void printList(LinkedList myList){
        Node tmp = null;
        for (tmp = myList.getHead(); tmp != null ; tmp = tmp.next){
            System.out.print(tmp.getKey()+"->");
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0 ; i < 8 ; i++){
            Node node = new Node(i+"");
            linkedList.addNode(node);
        }
        linkedList.printList(linkedList);
    }

}
