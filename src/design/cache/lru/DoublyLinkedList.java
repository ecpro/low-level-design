package design.cache.lru;

public class DoublyLinkedList<T> implements LinkedList<T> {

    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int size = 0;

    @Override
    public void add(T data) {
        if(isEmpty()) {
            this.head = new DoublyLinkedListNode<>(data);
            this.tail = this.head;
        } else {
            DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data);
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }
        size++;
    }

    @Override
    public void remove(T data) {
        if(!isEmpty()) {
            DoublyLinkedListNode<T> node = this.head;

            // find the node to be removed
            while(node != null && !node.getData().equals(data)) {
                node = node.getNext();
            }

            // if found, remove it
            if(node != null) {
                // if node is somewhere in the middle
                if(node.getPrev() != null && node.getNext() != null) {
                    DoublyLinkedListNode<T> prev = node.getPrev();
                    DoublyLinkedListNode<T> next = node.getNext();

                    prev.setNext(next);
                    next.setPrev(prev);
                    size--;
                }
                // if node is the only node
                else if (size == 1) {
                    this.clear();
                }
                else if (node == this.head) {
                    this.head = node.getNext();
                    this.head.setPrev(null);
                    size--;
                }
                else if (node == this.tail) {
                    this.tail = node.getPrev();
                    this.tail.setNext(null);
                    size--;
                }
            }
        }

    }

    @Override
    public void addFirst(T data) {
        if (isEmpty()) {
            this.head = new DoublyLinkedListNode<>(data);
            this.tail = head;
        } else {
            DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data);
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }
        size++;
    }

    @Override
    public void addLast(T data) {
        this.add(data);
    }

    @Override
    public void removeFirst() {
        if(!isEmpty()) {
            if(this.size() == 1) {
                this.clear();
            }
            else {
                DoublyLinkedListNode<T> next = this.head.getNext();

                next.setPrev(null);
                this.head = next;
                size--;
            }
        }
    }

    @Override
    public void removeLast() {
        if(!isEmpty()) {
            if(size() == 1) {
                this.clear();
            }
            else {
                DoublyLinkedListNode<T> penultimate = this.tail.getPrev();

                penultimate.setNext(null);
                this.tail = penultimate;
                size--;
            }
        }
    }

    @Override
    public T getFirst() {
        return this.size > 0 ? this.head.data : null;
    }

    @Override
    public T getLast() {
        return this.size > 0 ? this.tail.data : null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyLinkedListNode<T> node = this.head;

        while(node != null) {
            sb.append(node.getData());
            if(node.getNext() != null) {
                sb.append(" -> ");
            }
            node = node.getNext();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> singleElementList = new DoublyLinkedList<>();
        singleElementList.add(2);
        singleElementList.remove(2);
        singleElementList.addFirst(2);
        singleElementList.removeLast();
        singleElementList.addLast(2);
        singleElementList.removeFirst();

        singleElementList.addLast(23);
        System.out.println(singleElementList.toString());
        System.out.println(singleElementList.size() == 1);

        DoublyLinkedList<Integer> twoElementsList = new DoublyLinkedList<>();
        twoElementsList.add(1);
        twoElementsList.add(2);
        twoElementsList.remove(1);
        twoElementsList.add(1);
        System.out.println(twoElementsList.toString());
        System.out.println(twoElementsList.size() == 2);

        twoElementsList.removeFirst();
        twoElementsList.addLast(3);
        twoElementsList.removeLast();
        twoElementsList.addFirst(4);

        System.out.println(twoElementsList.toString());

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(1);
        list.add(2);
        list.addLast(3);
        list.addFirst(4);
        list.addLast(5);

        System.out.println(list.toString());

        list.removeFirst();
        list.removeLast();

        System.out.println(list.toString());

        list.removeFirst();
        list.removeLast();

        System.out.println(list.toString());





    }
}
