import org.junit.Test;
import static org.junit.Assert.*;

/**some basic test for array list deque*/
public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(10);
        ad1.addLast(5);
        Integer expected = null;
        Integer actual = ad1.get(-1);
        assertEquals(expected, actual);
    }

    /**
     * test for resize
     */
    @Test
    public void resizeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 1000; i++) {
            ad1.addLast(i);
        }
        int actual = ad1.size();
        int expect = 1000;
        assertEquals(actual, expect);
    }

    /**
     * test bug for resize
     */
    @Test
    public void resizeBugTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        assertNull(ad1.removeLast());
        assertEquals(null, ad1.removeFirst());
        assertTrue(ad1.isEmpty());
        for (int i = 0; i < 16; i++) {
            ad1.addFirst(i);
        }
        assertTrue(ad1.get(15).equals(0));
        assertFalse(ad1.isEmpty());
        ArrayDeque<Integer> ad2 = new ArrayDeque<>(ad1);
        for (int i = 0; i < 14; i++) {
            ad1.removeLast();
            ad2.removeFirst();
        }
        assertEquals(null, ad1.get(-5));
        assertEquals(null, ad1.get(8));
        ad1.printDeque();
        int actual = ad1.get(1);
        int expect = 14;
        assertEquals(actual, expect);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }

}
