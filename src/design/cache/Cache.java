package design.cache;

import java.util.Optional;

public interface Cache<K, V> {
    Optional<V> get(K key);

    void put(K key, V value);

    V remove(K key);

    void clear();

    int size();

    boolean isEmpty();
}
