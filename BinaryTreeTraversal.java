/**
 * Created by lrkin on 2016/10/26.
 *
 * 二叉树的前序,中序,后序遍历
 */
public class BinaryTreeTraversal {
    static class Node{
        private int data;
        private Node leftNode;
        private Node rightNode;
        public Node(int data, Node leftNode, Node rightNode){
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getLeftNode() {
            return leftNode;
        }
        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }
        public Node getRightNode() {
            return rightNode;
        }
        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    public Node init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
    }

    /**
     * 先序遍历,就是最普通的遍历
     * @param root
     */
    public void theFirstTraversal(Node root){
        if (root != null){
            System.out.print(root.getData());
            theFirstTraversal(root.getLeftNode());
            theFirstTraversal(root.getRightNode());
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void theInOrderTraversal(Node root){
        if (root != null){
            theInOrderTraversal(root.getLeftNode());
            System.out.print(root.getData());
            theInOrderTraversal(root.getRightNode());
        }
    }

    public void thePostOrderTraversal(Node root){
        if (root != null){
            thePostOrderTraversal(root.getLeftNode());
            thePostOrderTraversal(root.getRightNode());
            System.out.print(root.getData());
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        Node root = tree.init();
        System.out.print("先序遍历");
        tree.theFirstTraversal(root);
        System.out.print("");
        System.out.print("中序遍历");
        tree.theInOrderTraversal(root);
        System.out.print("");
        System.out.print("后序遍历");
        tree.thePostOrderTraversal(root);
        System.out.print("");
    }

}

//先序遍历631254978中序遍历123456789后序遍历214538796