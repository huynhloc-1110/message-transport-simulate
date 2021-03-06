package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import dataStructure.Queue;

class QueueTest {

	private Queue<Integer> queue;
	private Random random;
	
	@BeforeEach
	void init() {
		queue = new Queue<>();
		random = new Random();
	}
	
	@Test
	void testOfferAndPoll() {
		/*
		 * Offer numbers sequentially to queue.
		 */
		for (int i = 1; i <= 10; i++) {
			queue.offer(i);
		}
		
		/*
		 * Poll numbers sequentially and check each time.
		 */
		for (int i = 1; i <= 10; i++) {
			assertEquals(i, queue.poll());
		}
	}
	
	@Test
	void testPeek() {
		/*
		 * Offer a random number to queue.
		 * Check if the peek is that number.
		 */
		int r1 = random.nextInt(9);
		queue.offer(r1);
		assertEquals(r1, queue.peek());
		
		/*
		 * Offer another random number to queue.
		 * Check if the peek is the first number.
		 */
		int r2 = random.nextInt(9);
		queue.offer(r2);
		assertEquals(r1, queue.peek());
	}
	
	@Test
	void testSize() {
		/*
		 * Offer a random amount of numbers to the the queue.
		 * Check the size of the queue.
		 */
		int length = random.nextInt(1, 20);
		for (int i = 1; i <= length; i++) {
			queue.offer(i);
		}
		assertEquals(length, queue.size());
	}
	
	@Test
	void testIsEmpty() {
		/*
		 * Check if the initial queue is empty.
		 */
		assertTrue(queue.isEmpty());

		/*
		 * Offer a random amount of numbers to the the queue.
		 * Check if the queue is not empty.
		 */
		Random random = new Random();
		int length = random.nextInt(1, 20);
		for (int i = 1; i <= length; i++) {
			queue.offer(i);
		}
		assertFalse(queue.isEmpty());
	}
	
	@Test
	void testPrintAllElements() {
		/*
		 * Change output from console to the printsream.
		 */
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
		
		/*
		 * Offer a random amount of elements to the queue.
		 * Print all elements in the queue.
		 */
		int length = random.nextInt(1, 20);
		for (int i = 1; i <= length; i++) {
			queue.offer(i);
		}
		queue.printAllElements();
		
		/*
		 * Generate expected outcome.
		 */
		String expected = "[ ";
		for (int i = 1; i <= length; i++) {
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
