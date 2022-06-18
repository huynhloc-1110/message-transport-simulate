package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import dataStructure.Stack;

class StackTest {

	private Stack<Integer> stack;
	private Random random;
	
	@BeforeEach
	void init() {
		stack = new Stack<>();
		random = new Random();
	}
	
	@Test
	void testPushAndPop() {
		/*
		 * Push numbers sequentially to queue.
		 */
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		
		/*
		 * Pop numbers sequentially and check each time.
		 */
		for (int i = 10; i >= 1; i--) {
			assertEquals(i, stack.pop());
		}
	}
	
	@Test
	void testPeek() {
		/*
		 * Push a random number to stack.
		 * Check if the peek is that number.
		 */
		int r1 = random.nextInt(9);
		stack.push(r1);
		assertEquals(r1, stack.peek());
		
		/*
		 * Push another random number to queue.
		 * Check if the peek is the last number.
		 */
		int r2 = random.nextInt(9);
		stack.push(r2);
		assertEquals(r2, stack.peek());
	}
	
	@Test
	void testSize() {
		/*
		 * Push a random amount of numbers to the the stack.
		 * Check the size of the queue.
		 */
		int length = random.nextInt(1, 20);
		for (int i = 1; i <= length; i++) {
			stack.push(i);
		}
		assertEquals(length, stack.size());
	}
	
	@Test
	void testIsEmpty() {
		/*
		 * Check if the initial stack is empty.
		 */
		assertTrue(stack.isEmpty());

		/*
		 * Push a random amount of numbers to the the stack.
		 * Check if the stack is not empty.
		 */
		Random random = new Random();
		int length = random.nextInt(1, 20);
		for (int i = 1; i <= length; i++) {
			stack.push(i);
		}
		assertFalse(stack.isEmpty());
	}
	
	@Test
	void testPrintAllElements() {
		/*
		 * Change output from console to the printsream.
		 */
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
		
		/*
		 * Push a random amount of elements to the stack.
		 * Print all elements in the stack.
		 */
		int length = random.nextInt(1, 20);
		for (int i = 1; i <= length; i++) {
			stack.push(i);
		}
		stack.printAllElements();
		
		/*
		 * Generate expected outcome
		 */
		String expected = "[ ";
		for (int i = length; i >= 1; i--) {
			expected += i + " ";
		}
		expected += "]";
		
		/*
		 * Check.
		 */
		assertEquals(expected, outputStreamCaptor.toString().trim());
		
		/*
		 * Change the output stream back to console.
		 */
		System.setOut(System.out);
	}
}
