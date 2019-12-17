import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

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

		LinkedListDeque<String> lld1 = new LinkedListDeque<>();

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

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
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

	/**
	 * test the case of removing item from empty list
	 */
	@Test
	public void removeEmptyTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		Integer actual = lld1.removeFirst();
		Integer expected = null;
		assertEquals(actual, expected);
	}

	/**
	 * test add last method
	 */
	@Test
	public void addRemoveLastTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		assertEquals(null, lld1.removeLast());
		assertEquals(0, lld1.size());
		lld1.addLast(10);
		int actual = lld1.removeLast();
		int expected = 10;
		assertEquals(actual, expected);
	}

	/**
	 * test get method
	 */
	@Test
	public void getTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		lld1.addLast(10);
		lld1.addFirst(20);
		assertTrue(lld1.get(1).equals(10));
		assertTrue(lld1.getRecursive(1).equals(10));
		assertEquals(null, lld1.get(-1));
		assertEquals(null, lld1.get(20));
		assertEquals(null, lld1.getRecursive(-1));
		assertEquals(null, lld1.getRecursive(20));
		LinkedListDeque<Integer> lld2 = new LinkedListDeque<>(lld1);
		int actual = lld2.get(0);
		int expected = 20;
		assertEquals(actual, expected);
	}

	/**
	 * test bug for remove
	 */
	@Test
	public void removeBugTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		lld1.addFirst(1);
		lld1.addLast(2);
		lld1.removeFirst();
		lld1.removeLast();
		lld1.addFirst(3);
		lld1.printDeque();
		int expected = lld1.get(0);
		int actual = lld1.removeLast();
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
}
