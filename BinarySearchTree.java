import java.util.Comparator;
import java.util.jar.Pack200;

/**
 * Created by lrkin on 2016/10/25.
 *
 * 二叉查找树的遍历,查找,删除和插入
 *
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    /**
     * 节点数据结构
     */
    static class BinaryNode<T> {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T data) {
            this(data, null, null);
        }

        public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public BinaryNode() {
            data = null;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<T> rootTree;

    /**
     * 构造一颗空的二叉查找树
     */
    public BinarySearchTree() {
        rootTree = null;
    }

    /**
     * 清空二叉查找树
     */
    public void clear() {
        rootTree = null;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return rootTree == null;
    }

    /**
     * 查找指定的元素,默认从根节点开始查询
     */
    public boolean contains(T t) {
        return contains(t, rootTree);
    }

    /**
     * 从某个节点开始查找元素
     *
     * @param t
     * @param node
     * @return
     */
    public boolean contains(T t, BinaryNode<T> node) {
        if (node == null)
            return false;
        int result = t.compareTo(node.data);
        if (result > 0) {
            return contains(t, node.right);
        } else if (result < 0) {
            return contains(t, node.left);
        } else {
            return true;
        }
    }

    /**
     * 查找二叉搜索树中的最小值
     *
     * @return
     */
    public T findMin() {
        if (isEmpty()) {
            System.out.println("二叉树为空");
            return null;
        } else {
            return findMin(rootTree).data;
        }
    }

    /**
     * 查找二叉搜索树中的最大值
     *
     * @return
     */
    public T findMax() {
        if (isEmpty()) {
            System.out.println("二叉树为空");
            return null;
        } else {
            return findMax(rootTree).data;
        }
    }

    /**
     * 插入元素
     *
     * @param t
     */
    public void insert(T t) {
        rootTree = insert(t, rootTree);
    }

    public void remove(T t) {

        rootTree = remove(t, rootTree);

    }

    /**
     * 删除元素,3种情况讨论(实际上是两种):
     * 1)此元素为叶子节点,直接删除即可(也同2),只不过是null
     * 2)此元素只有左子树或者右子树,那么˙直接删除该节点,该节点的左(或右)节点设置为其父节点的左(或右)节点(取决于它是本身是父节点的左还是右节点)
     * 3)此元素的左右节点都不空,删除策略是用它左子树的最小的节点来替换它(因为右子树的最小节点不可能有左孩子,同2),很好二次删除)
     * <p>
     * 在这个方法中,先递归找到t对应的node
     * 再分两种情况处理
     *
     * @param t
     * @param node
     * @return
     */
    public BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null) {
            return node;
        }
        int result = t.compareTo(node.data);
        if (result > 0) {
            node.right = remove(t, node.right);
        } else if (result < 0) {
            node.left = remove(t, node.left);
        } else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = remove(node.data, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    /**
     * 插入BinarySearchTree,也是递归,但要注意方法返回的是这一层正在用的node
     *
     * @param t
     * @param node
     * @return
     */
    public BinaryNode<T> insert(T t, BinaryNode<T> node) {

        if (node == null) {
            //
            return new BinaryNode<T>(t, null, null);
        } else {
            int result = t.compareTo(node.data);
            if (result > 0) {
                node.right = insert(t, node.right);
            } else if (result < 0) {
                node.left = insert(t, node.left);
            } else {
                //do notion
            }
        }

        return node;
    }


    public BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }


    public BinaryNode<T> findMax(BinaryNode<T> node) {

        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }
    //打印
    public void print(BinaryNode<T> node){
        if (node != null){
            System.out.print(node.data+"---");
            print(node.left);
            print(node.right);
        }
    }

    public BinaryNode<Integer> init()
    {
        BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> node1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> node4 = new BinaryNode<Integer>(4,node3,null);
        BinaryNode<Integer> node2 = new BinaryNode<Integer>(2,node1,node4);
        BinaryNode<Integer> node8 = new BinaryNode<Integer>(8);
        BinaryNode<Integer> root = new BinaryNode<Integer>(6,node2,node8);
        return root;
    }
    public void preOrder(BinaryNode node) {
        if (node != null) {
            System.out.print(node.data+"---");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    /*简单测试*/
    public static void main(String[] args) {
        BinarySearchTree  searchTree = new BinarySearchTree<>();
        BinaryNode<Integer> node= searchTree.init();
        searchTree.rootTree=node;
        searchTree.preOrder(searchTree.rootTree);
        System.out.println("");

        searchTree.print(searchTree.rootTree);
        System.out.println("");
        searchTree.remove(4);
        searchTree.preOrder(searchTree.rootTree);
        System.out.println("");
        searchTree.print(searchTree.rootTree);

    }


}
