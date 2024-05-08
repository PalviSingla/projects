package lrucache;

import java.util.*;

public class CacheOperations {
    private final Queue<Integer> queue;
    private final HashMap<Integer,String> map;

    private final int cache_limit;

    public CacheOperations(int capacity){
        queue = new LinkedList<>();
        map = new HashMap<>();
        cache_limit = capacity;
    }
    public void add(Integer key, String value){
        map.put(key, value);
        if(queue.size()>=cache_limit) {
            Integer ele = queue.poll();
            map.remove(ele);
        }
        queue.add(key);

    }

    public String get(Integer key){
        if(map.containsKey(key)){
            if(queue.contains(key)) {
                queue.remove(key);
                queue.add(key);
            }
            return map.get(key);
        }
        return "NA";
    }

}
