import java.util.*;

class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > capacity) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            it.next();
            it.remove();
        }
    }
}
