public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int REFACTOR = 2; //resize factor

    /**
     * create empty array deque
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /**
     * calculate nextFirst
     * @param i: current position
     */
    private int nextF(int i) {
        return i == 0? items.length - 1 : i -1;
    }

    /**
     * calculate nextLast
     * @param i: current position
     */
    private int nextL(int i) {
        /*
        int next;
        if (i == items.length - 1) {
            next = 0;
        } else {
            next = i + 1;
        }*/
        return i == items.length - 1? 0 : i + 1;
    }

    /**
     * resize array, create a larger one
     * @param capacity: new size for the array
     */
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int old_size = size;
        int first = nextF(nextFirst);

        for (int i = 0; i < old_size ; i++ ) {
            temp[i] = items[first];
            first = nextF(first);
        }
        nextFirst = capacity - 1;
        nextLast = size;
        items = temp;
    }

    /**
     * add item to the front of the deque
     * @param item: item to add
     */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * REFACTOR);
        }
        items[nextFirst] = item;
        size = size + 1;

        nextFirst = nextF(nextFirst);
    }

    /**
     * add item to the back of deque
     * @param item: item to add
     */
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * REFACTOR);
        }
        items[nextLast] = item;
        size = size + 1;

        nextLast = nextL(nextLast);
    }

    /**
     * if deque is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * number of items in deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * print item in the deque from first to last
     */
    @Override
    public void printDeque() {
        int pos = nextL(nextFirst);
        while (pos != nextLast) {
            System.out.print(items[pos] + " ");
            pos = nextL(pos);
        }
        System.out.println();
    }

    /**
     * remove and return the item at front of deque
     */
    @Override
    public T removeFirst() {
        /**if first item does not exist*/
        if (size == 0) {
            return null;
        }

        //R: array usage
        double R;
        R = size / items.length;
        if (R < 0.25) {
            resize(items.length / 2);
        }

        int pos = nextL(nextFirst);
        T result = items[pos];
        items[pos] = null;
        size =  size - 1;
        nextFirst = pos;
        return result;
    }

    /**
     * remove and return the item at back of the deque
     */
    @Override
    public T removeLast() {
        /**if last item does not exist*/
        if (size == 0) {
            return null;
        }

        //R: array usage
        double R;
        R = size / items.length;
        if (R < 0.25) {
            resize(items.length / 2);
        }

        int pos = nextF(nextLast);
        T result = items[pos];
        items[pos] = null;
        size =  size - 1;
        nextLast = pos;
        return result;
    }

    /**
     * get item at given index
     * @param index: index of the item to get
     */
    @Override
    public T get(int index) {
        /**if the index does not exist*/
        if (index >= size || index < 0) {
            return null;
        }

        int pos = nextFirst;

        pos = nextL(pos) + index;

        if (pos >= items.length ) {
            pos = pos - items.length;
        }
        return items[pos];
    }

    /**
     * create a deep copy
     * @param other: the ArrayDeque to copy
     */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        size = 0;
        nextFirst = 4;
        nextLast = 5;

        for (int i = 0; i < other.size ; i++ ) {
             addFirst((T) other.get(i));
        }
    }
}
