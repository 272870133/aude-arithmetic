import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by lrkin on 2016/10/26.
 * 求二叉树的深度和广度
 */
public class BinaryTreeMaxDepthWidth {

    static class TreeNode {
        char val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(char val) {
            this.val = val;
        }

        public TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取最大深度
     * <p>
     * 记忆点:递归
     *
     * @param root
     * @return
     */
    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = getMaxDepth(root.left);
            int right = getMaxDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }

    /**
     * 获取最大宽度
     * <p>
     * <p>
     * 记忆点:采用队列这种数据结构,来记录每一层的宽度,遍历即可
     *
     * @param root
     * @return
     */
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;

        //获取队列
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        int maxWidth = 1;

        queue.add(root);

        //循环
        while (true) {
            int size = queue.size();
            if (size == 0) {
                break;
            }

            while (size > 0) {
                //不为零,那么一直poll完这一层的所有节点为止
                TreeNode node = queue.poll();
                size--;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            //每一层,都更新maxWidth;

//            maxWidth = Math.max(maxWidth, size);这样写错误,因为size递减
            maxWidth = Math.max(maxWidth, queue.size());

        }

        return maxWidth;
    }


    public static TreeNode initBinaryTree() {
        TreeNode J = new TreeNode('a', null, null);
        TreeNode H = new TreeNode('b', null, null);
        TreeNode G = new TreeNode('c', null, null);
        TreeNode F = new TreeNode('d', null, J);
        TreeNode E = new TreeNode('e', H, null);
        TreeNode D = new TreeNode('g', null, G);
        TreeNode C = new TreeNode('w', F, null);
        TreeNode B = new TreeNode('h', D, E);
        TreeNode A = new TreeNode('z', B, C);
        return A;   //返回根节点
//
//        Node J = new Node(8, null, null);
//        Node H = new Node(4, null, null);
//        Node G = new Node(2, null, null);
//        Node F = new Node(7, null, J);
//        Node E = new Node(5, H, null);
//        Node D = new Node(1, null, G);
//        Node C = new Node(9, F, null);
//        Node B = new Node(3, D, E);
//        Node A = new Node(6, B, C);
//        return A;   //返回根节点
    }

    public static void main(String[] args) {
        TreeNode root = initBinaryTree();
        System.out.println(getMaxDepth(root));
        System.out.println(getMaxWidth(root));
    }

}
