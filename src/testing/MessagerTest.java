package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import implementation.Messager;

class MessagerTest {

	private Messager m1;
	private Messager m2;
	private Random random;
	
	@BeforeEach
	void init() {
		m1 = new Messager("M1");
		m2 = new Messager("M2");
		random = new Random();
	}
	
	@Test
	void testConnect() {
		assertFalse(m1.isConnected());
		
		m1.connect(m2);
		assertTrue(m1.isConnected());
		
		m1.disconnect();
		assertFalse(m1.isConnected());
		assertFalse(m2.isConnected());
	}
	
	@Test
	void testSendGetDisplayMessage() {
		/*
		 * Change output from console to the printsream.
		 */
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
		
		/*
		 * M1 connects with M2 and sends random message.
		 * M2 gets message and display it.
		 */
		m1.connect(m2);
		String message = "test-" + random.nextInt(1,100);
		m1.sendMessage(message);
		m2.getMessage();
		m2.displayMessages();
		
		/*
		 * Check the display message.
		 */
		String expected = "M2's message stack: [ " + message + " ]";
		assertEquals(expected, outputStreamCaptor.toString().trim());
		
		/*
		 * Change the output stream back to console.
		 */
		System.setOut(System.out);
	}
	
	@Test
	void testSendGetDisplayManyMessages() {
		/*
		 * Change output from console to the printsream.
		 */
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
		
		/*
		 * M1 connects with M2 and sends multiple random messages.
		 * Store the messages in a variable for testing
		 * M2 gets message and display it.
		 */
		m1.connect(m2);
		String[] messagesArray = new String[10];
		for (int i = 0; i < 10; i++) {
			String message = "test-" + random.nextInt(1,100);
			m1.sendMessage(message);
			messagesArray[i] = message;
		}
		m2.getMessage();
		m2.displayMessages();
		
		/*
		 * Generate expected result.
		 * Check the display message.
		 */
		String messages = "";
		for (int i = messagesArray.length - 1; i >= 0; i--) {
			messages += messagesArray[i] + " ";
		}
		
		String expected = "M2's message stack: [ " + messages + "]";
		assertEquals(expected, outputStreamCaptor.toString().trim());
		
		/*
		 * Change the output stream back to console.
		 */
		System.setOut(System.out);
	}
	
}
