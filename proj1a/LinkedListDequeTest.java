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

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

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

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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
	/**
	 * test the case of removing item from empty list
	 */
	public void removeEmptyTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		Integer actual = lld1.removeFirst();
		Integer expected = null;
		assertEquals(actual, expected);
	}

	@Test
	/**
	 * test add last method
	 */
	public void addRemoveLastTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		lld1.addLast(10);
		int actual = lld1.removeLast();
		int expected = 10;
		assertEquals(actual, expected);
	}

	@Test
	/**
	 * test get method
	 */
	public void getTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		lld1.addLast(10);
		lld1.addFirst(20);
		int actual = lld1.get(0);
		int expected = 20;
		assertEquals(actual, expected);
	}

	@Test
	/**
	 * test bug for remove
	 */
	public void removeBugTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		lld1.addFirst(1);
		lld1.addLast(2);
		lld1.removeFirst();
		lld1.removeLast();
		lld1.addFirst(3);
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
