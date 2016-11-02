public interface MyStack<T> {

    /**
     * 判断栈是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 清空栈
     */
    void clear();

    /**
     * 栈的长度
     *
     * @return
     */
    int length();

    /**
     * 入栈
     *
     * @param data
     * @return
     */
    boolean push(T data);

    /**
     * 出栈
     *
     * @return
     */
    T pop();

    /**
     * 遍历
     */
    void print();
}