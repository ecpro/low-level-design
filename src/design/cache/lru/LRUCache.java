package design.cache.lru;

import design.cache.Cache;
import design.cache.Record;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> implements Cache<K,V> {

    private final int capacity;
    private final Map<K, Record<K,V>> map;
    private final LinkedList<Record<K,V>> linkedList;

    private final Double LOAD_FACTOR;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.LOAD_FACTOR = 0.75;
        this.map = new ConcurrentHashMap<>(this.capacity);
        this.linkedList = new DoublyLinkedList<>();;
    }

    public LRUCache(int capacity, Double loadFactor) {
        if(loadFactor > 1.0 || loadFactor < 0.0) throw new IllegalArgumentException("Load factor must be between 0.0 and 1.0");

        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>(this.capacity);
        this.linkedList = new DoublyLinkedList<>();
        this.LOAD_FACTOR = loadFactor;
    }

    @Override
    public Optional<V> get(K key) {
        if(map.containsKey(key)) {
            Record<K, V> record = map.get(key);

            linkedList.remove(record);
            linkedList.addFirst(record);
            map.put(key, linkedList.getFirst());

            return Optional.of(record.getValue());
        }

        return Optional.empty();
    }

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Record<K, V> oldRecordNode = map.get(key);

            linkedList.remove(oldRecordNode);
            linkedList.addFirst(oldRecordNode);

            map.put(key, linkedList.getFirst());
        } else if(capacity * LOAD_FACTOR <= map.size()) {
            evict();
            Record<K, V> newRecord = new Record<>(key, value);
            map.put(key, newRecord);
            linkedList.addFirst(newRecord);
        } else {
            Record<K, V> newRecord = new Record<>(key, value);
            map.put(key, newRecord);
            linkedList.addFirst(newRecord);
        }
    }

    private void evict() {
        int numRecordsToRemove = (int) (0.25 * size());

        for(int i = 0; i < numRecordsToRemove; i++) {
            Record<K, V> lastRecord = linkedList.getLast();
            map.remove(lastRecord.getKey());
            linkedList.removeLast();
        }
    }

    @Override
    public V remove(K key) {
        if(map.containsKey(key)) {
            Record<K, V> oldRecord = map.get(key);

            map.remove(key);
            linkedList.remove(oldRecord);

            return oldRecord.getValue();
        }

        return null;
    }

    @Override
    public void clear() {
        this.map.clear();
        this.linkedList.clear();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public static void main(String[] args) {
        Cache<String, String> cache = new LRUCache<>(7);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");

        System.out.println(cache.toString());

        cache.get("1");

        System.out.println(cache.toString());

        cache.put("5", "5");
        cache.put("6", "6");
        cache.put("7", "7");

        System.out.println(cache.toString());

        cache.remove("4");

        System.out.println(cache.toString());

        cache.put("8", "8");
        cache.get("3");

        System.out.println(cache.toString());

    }
}
