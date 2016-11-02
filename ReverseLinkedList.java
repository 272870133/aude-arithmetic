import java.util.List;

/**
 * Created by lrkin on 2016/10/24.
 * <p>
 * 题目描述：
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class ReverseLinkedList {

    static class ListNode {
        int key;
        ListNode next;
    }

    public static ListNode reverse(ListNode pHead) {
        ListNode reverseHead = pHead;//最后要返回的已经反转了的head
        ListNode node = pHead;//当前正在处理的node
        ListNode preNode = null;//当前正在处理的node的前面一个node

        while (node != null) {
            //当前正在处理的node的后面一个node
            ListNode next = node.next;
            //如果正在处理的node的next为空,那么就可以返回了,否则就一直循环
            if (next == null) {
                reverseHead = node;
            }
            //翻转
            node.next = preNode;
            //循环
            preNode = node;
            node = next;
        }

        return reverseHead;

    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.key+"--->");
            head = head.next;
        }
    }


    public static void main(String[] args) {

        ListNode head = new ListNode();
        head.key = 0;
        ListNode tmp = head;
        for (int i = 1; i < 10; i++) {
            ListNode listNode = new ListNode();
            listNode.key = i;
            listNode.next = null;
            tmp.next = listNode;
            tmp = listNode;
        }

        printList(head);

        ListNode rHead = reverse(head);

        System.out.println("");

        printList(rHead);


    }

}
