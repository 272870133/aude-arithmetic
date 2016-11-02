/**
 * Created by lrkin on 2016/10/26.
 * 栈的数组实现
 * @param <T>
 */
public class MyArrayStack<T> implements MyStack<T> {

    //创建数组
    private Object[] objs = new Object[16];
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        //将数组中的数据置为Null,方便GC进行回收
        for (int i = 0; i < size; i++) {
            objs[i] = null;
        }
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(T data) {
        //判读是否需要扩容
        if (size == objs.length) {
            resize();
        } else {
            objs[size++] = data;
        }

        return true;
    }

    private void resize() {

        Object[] temp = new Object[objs.length * 3 / 2 + 1];
        for (int i = 0; i < objs.length; i++) {
            temp[i] = objs[i];
        }

        objs = temp;
    }

    @Override
    public T pop() {
        if (size > 0) {
            return (T) objs[size--];
        } else {
            return null;
        }

    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(objs[i] + "-");
        }
        System.out.println("");
        for (int i = 0; i < objs.length; i++) {
            System.out.print(objs[i] + "-");
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyArrayStack<>();

        for (int i = 0; i < 35; i++) {
            stack.push(i);
        }

        stack.print();
        System.out.println("");

        for (int i = 0; i < 10 ; i++) {
            stack.pop();
        }
        stack.print();
        System.out.println("");

        for (int i = 0; i < 10 ; i++) {
            stack.push(i+45);
        }
        stack.print();
    }
}
