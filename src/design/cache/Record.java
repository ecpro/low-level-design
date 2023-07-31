package design.cache;

public class Record<K, V> {
    private final K key;
    private V value;

    public Record(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if(!(obj instanceof Record)) {
            return false;
        }

        return key.equals(((Record<K,V>) obj).key);
    }


    @Override
    public String toString() {
        return "Record{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
