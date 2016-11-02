import java.util.HashMap;

/**
 * Created by lrkin on 2016/11/1.
 */
public class LRUCacheImpl<K, V> implements LRUCache<K, V> {

    static class Entry<K, V> {
        public Entry prev;
        public Entry next;
        public K key;
        public V value;

        public Entry(Entry prev, Entry next, K key, V value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public Entry(V value) {
            this.prev = null;
            this.next = null;
            this.key = null;
            this.value = value;
        }
    }

    public HashMap<K, V> entries;
    public Entry<K, V> head;
    public Entry<K, V> end;
    public int MAX_SIZE;

    public LRUCacheImpl(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.head = new Entry<K, V>(null);
        this.end = new Entry<K, V>(null);
    }

    /**
     * 添加到缓存中
     * <p>
     * 需要先判断缓存是否已满
     * 然后加到头部
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        if (MAX_SIZE == entries.size()) {
            entries.remove(end.key);
            removeLastEntry();
        }

        entries.put(key, value);
        Entry<K, V> entry = new Entry<>(null);
        entry.key = key;
        entry.value = value;

        moveToHead(key);

    }

    private void removeLastEntry() {
        end.prev.next = null;
        end = end.prev;
    }

    private void removeHead() {
        head.next.prev = null;
        head = head.next;
    }

    @Override
    public void remove(K key) {

        entries.remove(key);
        Entry<K, V> theNode = new Entry<K, V>(null);
        Entry<K, V> headCopy = head;
        //先找到,再删除
        while (headCopy.next != null) {
            if (headCopy.key == key)
                theNode = headCopy;
            else
                headCopy = headCopy.next;
        }

        if (theNode.prev == null) {
            removeHead();
        } else if (theNode.next == null) {
            removeLastEntry();
        } else {
            theNode.next.prev = theNode.prev;
            theNode.prev.next = theNode.next;
        }
    }

    public void moveToHead(K key) {
        Entry<K, V> theNode = new Entry<K, V>(null);
        Entry<K, V> headCopy = head;
        while (headCopy.next != null) {
            if (headCopy.key == key)
                theNode = headCopy;
            else
                headCopy = headCopy.next;
        }
        //先找到,再移动
        if (theNode.prev == null) {
            return;
        } else if (theNode.next == null) {
            theNode.prev.next = null;
            head.prev = theNode;
            theNode.next = head;
            theNode.prev = null;
        } else {
            theNode.next.prev = theNode.prev;
            theNode.prev.next = theNode.next;
            head.prev = theNode;
            theNode.next = head;
            theNode.prev = null;
        }
        if (end == null)
            end = head;
    }

    /**
     * 获取
     * 每一次获取,都移至头部
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        V value = entries.get(key);
        moveToHead(key);
        return value == null ? null : value;
    }

    public void print() {
        System.out.print("");
    }

    public static void main(String[] args) {
        LRUCacheImpl<String, Integer> stringIntegerLRUCache = new LRUCacheImpl<>(10);
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "U", "L", "Z"};
        for (int i = 0; i < 10; i++) {
            stringIntegerLRUCache.add(strings[i], i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(stringIntegerLRUCache.get(strings[i]) + " ");
        }
    }
}
