/**
 * Created by lrkin on 2016/10/26.
 */
class QueueTest {

    static class Queue {

        private int maxSize; //队列长度，由构造函数初始化
        private long[] queArray; // 队列
        private int front; //队头
        private int rear; //队尾
        private int nItems;  //元素的个数

        public Queue(int s)           // 构造函数
        {
            maxSize = s;
            queArray = new long[maxSize];
            front = 0;
            rear = -1;
            nItems = 0;
        }

        public void insert(long data){
            //循环的处理
            if ((rear+1) == maxSize)
                rear = -1;
            queArray[++rear] = data;
            nItems++;
        }

        public long remove(){
            //循环的处理
            if (front == maxSize){
                front = 0;
            }
            long tmp = queArray[front++];
            nItems--;
            return tmp;
        }

        public boolean isEmpty(){
            return nItems==0;
        }
    }

    public static void main(String[] args) {

        Queue theQueue = new Queue(5);   // 队列有5个元素

        theQueue.insert(10);             // 添加4个元素
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();               // 移除3个元素
        theQueue.remove();               // (10, 20, 30)
        theQueue.remove();

        theQueue.insert(50);             // 添加4个元素
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
//
//        while( !theQueue.isEmpty() )     // 遍历队列并移除所有元素
//        {
//            long n = theQueue.remove();   // (40, 50, 60, 70, 80)
//            System.out.print(n);
//            System.out.print(" ");
//        }

        System.out.println("");

        for (int i = 0 ; i < 5 ; i++) {
            System.out.print(theQueue.queArray[i]);
        }
    }
}
