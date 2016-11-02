/**
 * Created by lrkin on 2016/10/27.
 */
public class WhileBlock {

    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        while (n > 1){
            System.out.println("while当前是"+n);
            Thread.sleep(1500);
            n--;
        }

        System.out.println("while循环是线程阻塞的!");
    }
}
