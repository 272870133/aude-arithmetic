/**
 * Created by lrkin on 2016/10/30.
 * <p>
 * 题目
 * <p>
 * 输入一个单向链表，输出该链表中倒数第 k  个结点。链表的倒数第 0  个结点为链表的尾指针。
 * <p>
 * 思路
 * <p>
 * 算是比较简单的题目了。
 * <p>
 * 解法一：
 * <p>
 * 可以先遍历一遍统计链表个数，然后找到倒数第k个的下标再遍历，这样时间复杂富比较高
 * <p>
 * 解法二：
 * <p>
 * 双指针联动，一个指针先跑K个节点，然后两个指针一起跑，一个指针跑到尾节点时另一个指针恰好是倒数第K个节点。
 */
public class LastK {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //初始化链表
    public Node initLinkedList() {

        Node head = createHead();
        Node realHead = head;

        for (int i = 1; i < 8; i++) {
            //反转链表需要前中后三个Node,其他一般只需要两个
            Node node = new Node(i, null);
            head.next = node;
            head = node;
        }

        return realHead;
    }

    //遍历链表
    public void print(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(head.data + "-");

        while (head.next != null) {
            head = head.next;
            System.out.print(head.data + "-");
        }

    }

    //得到链表节点数目
    public int getCount(Node head) {
        int num = 1;
        if (head == null) {
            return 0;
        }
        while (head.next != null) {
            head = head.next;
            num++;
        }
        return num;
    }

    public Node createHead() {
        Node node = new Node(0);
        node.next = null;
        return node;
    }

    public Node lastK(Node head, int k) {
        Node headCopy = head;
        int length = getCount(head);

        while (k != 0) {
            headCopy = headCopy.next;
            k--;
        }

        while (headCopy.next != null) {
            headCopy = headCopy.next;
            head = head.next;
        }

        return head;

    }

    public static void main(String[] args) {
        LastK lastK = new LastK();
        Node head = lastK.initLinkedList();
        lastK.print(head);
        System.out.println("");
        System.out.println(lastK.getCount(head));

        Node theNode = lastK.lastK(head, 2);
        System.out.println(theNode.data);
    }

}
