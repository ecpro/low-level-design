package design.cache.lru;

public class DoublyLinkedListNode<T> {
    T data;

    DoublyLinkedListNode<T> prev;

    DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T data) {
        this.data = data;
    };

    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> prev, DoublyLinkedListNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }
}
