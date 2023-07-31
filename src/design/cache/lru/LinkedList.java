package design.cache.lru;

public interface LinkedList<T> {

    void add(T data);

    void remove(T data);

    void addFirst(T data);

    void addLast(T data);

    void removeFirst();

    void removeLast();

    T getFirst();

    T getLast();

    int size();

    boolean isEmpty();

    void clear();
}
