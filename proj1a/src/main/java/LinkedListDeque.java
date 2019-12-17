public class LinkedListDeque<T> implements Deque<T> {
    private class LLDNode {
        LLDNode prev;
        T item;
        LLDNode next;

        public LLDNode(LLDNode front, T n, LLDNode back) {
            prev = front;
            item = n;
            next = back;
        }
    }

    private LLDNode sentinel;
    private int size;

    /**
     * create empty linked list deque
     */
    public LinkedListDeque() {
        sentinel = new LLDNode (null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * add item to front of the deque
     * @param item: item to add
     */
    @Override
    public synchronized void addFirst(T item) {
        LLDNode temp = new LLDNode(sentinel, item, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size = size + 1;
    }

    /**
     * add item to back of the deque
     * @param item: item to add
     */
    @Override
    public synchronized void addLast(T item) {
        LLDNode temp = new LLDNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size = size + 1;
    }

    /**
     * return if deque is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * number of items in the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * print items in the deque
     */
    @Override
    public void printDeque() {
        LLDNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * remove and return item at front of deque
     */
    @Override
    public synchronized T removeFirst() {
        //if no first item
        if (isEmpty()) {
            return null;
        }

        T result = sentinel.next.item;
        LLDNode target = sentinel.next.next;
        sentinel.next = target;
        target.prev = sentinel;
        size = size - 1;
        return result;
    }

    /**
     * remove and return the item at back of the deque
     */
    @Override
    public synchronized T removeLast() {
        //if no last item
        if (isEmpty()) {
            return null;
        }

        T result = sentinel.prev.item;
        LLDNode target = sentinel.prev.prev;
        sentinel.prev = target;
        target.next = sentinel;
        size = size - 1;
        return result;
    }

    /**
     * get item at given index with iteration
     * @param index: the index of item to get
     */
    @Override
    public T get(int index) {
        //if index item does not exist
        if (index > size - 1 || index < 0) {
            return null;
        }

        int num = 0;
        LLDNode p = sentinel.next;
        while (num != index) {
            p = p.next;
            num++;
        }
        return p.item;
    }

    /**
     * create a deep copy of other
     * @param other: the LinkedListDeque to copy
     */
    public LinkedListDeque (LinkedListDeque<T> other) {
        this();
        this.sentinel = other.sentinel;
        for (int i = 0; i < other.size() ; i++ ) {
            addLast(other.get(i));
        }
    }

    /**
     * get item at given index with recursion
     * @param index: the index of item to get
     */
    public T getRecursive(int index) {
        //if index item does not exist
        if (index > size - 1 || index < 0) {
            return null;
        }

        return getHelper(sentinel.next, index);
    }

    /**
     * helper program to get item
     * @param node: current node
     * @param index: index of the current node
     */
    public T getHelper(LLDNode node, int index) {
        if (index == 0) {
            return node.item;
        }

        return getHelper(node.next, index - 1);
    }
}
