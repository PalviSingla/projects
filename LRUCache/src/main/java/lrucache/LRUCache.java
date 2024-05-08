public class LRUCache {
    public static void main(String[] args)  {
        CacheOperations cache = new CacheOperations(3);
        cache.add(1, "One");
        cache.add(2, "Two");
        cache.add(3, "Three");


        System.out.println(cache.get(1));

        cache.add(4, "Four");
        cache.add(1, "Four");

        System.out.println(cache.get(2));

    }


}