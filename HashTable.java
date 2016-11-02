import java.util.HashMap;
import java.util.Map;

/**
 * Created by lrkin on 2016/10/24.
 */
public class HashTable {

    private int capacity = 1000;
    private Map[] keys;//存放键值所对应的key-value对
    /**
     * 默认容量的构造函数,默认容量为1000
     */
    public HashTable(){
        keys = new Map[capacity];
        for (int i = 0; i < capacity ; i++) {
            keys[i] = null;
        }
    }
    /**
     * 带容量的构造函数
     */
    public HashTable(int cy){
        this.capacity = cy;
        keys = new Map[this.capacity];
        for (int i = 0; i < capacity ; i++) {
            keys[i] = null;
        }
    }

    public void put(Object key , Object value){
        int keyIndex = key.hashCode()%capacity;//得到此键对应的键值
        boolean isSameKey = false;
        Map map = new HashMap();
        

    }
}
