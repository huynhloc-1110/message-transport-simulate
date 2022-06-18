package implementation;

import dataStructure.Stack;
import dataStructure.Queue;

/**
 * This Messager class simulates a machine to send and receive String messages.
 * 
 * It uses a queue to store out-coming messages
 * and a stack to store in-coming messages.
 * 2 Messager objects need to connect with each other first
 * before sending and receiving messages.
 * 
 * @author Le Huynh Loc
 * @since June 2022
 */
public class Messager {
	/**
	 * The messager's name.
	 */
	private String name;
	
	/**
	 * Acts as a connection between the messager and another.
	 */
	private Messager partner;
	
	/**
	 * The message queue to store the out-coming messagers
	 * (the messages that needs to be sent).
	 */
	private Queue<String> messageQueue;
	
	/**
	 * The message queue to store the in-coming messagers
	 * (the messages that needs to be received and processed).
	 */
	private Stack<String> messageStack;
	
	/**
	 * Creates a messager object with a name, an empty stack and an empty queue.
	 * The partner (acts as a connection) is initiated as null.
	 * 
	 * @param name the name of the messager
	 */
	public Messager(String name) {
		this.name = name;
		messageQueue = new Queue<>();
		messageStack = new Stack<>();
	}
	
	/**
	 * Creates a messager object named "Unamed" with an empty stack and an empty queue.
	 * The partner (acts as a connection) is initiated as null.
	 */
	public Messager() {
		this("Unamed");
	}
	
	/**
	 * Returns true if the messager is connected with another.
	 * 
	 * @return true if the messager is connected with another
	 */
	public boolean isConnected() {
		return this.partner != null;
	}
	
	/**
	 * Connects the messager with another.
	 * Connection fails if the other messager is null or the same as the current messager.
	 * 
	 * @param partner the other messager to be connected with
	 * @throws IllegalArgumentException if the other messager
	 * is null or the same as the current messager
	 */
	public void connect(Messager partner) throws IllegalArgumentException {
		if (partner == null || partner == this.partner)
			throw new IllegalArgumentException("Connection failed.");
		
		this.partner = partner;
		partner.partner = this;
	}
	
	/**
	 * Disconnects the messager with another.
	 * Sets a new empty queue to the message queue so that
	 * messages sending to one messager is not mixed with other messagers.
	 */
	public void disconnect() {
		messageQueue = new Queue<>();
		
		if (partner != null) {
			partner.partner = null;
		}
		partner = null;
	}
	
	/**
	 * Offers the message to the message queue of the messager if
	 * the messager is connected with another.
	 * 
	 * @param message the message needs to be sent
	 * @throws IllegalStateException if no partner is connected
	 * to the current one.
	 */
	public void sendMessage(String message) throws IllegalStateException {
		if (!isConnected())
			throw new IllegalStateException("No partner connected");
		
		messageQueue.offer(message);
	}
	
	/**
	 * Gets the message from the other messager's queue and put to its stack
	 * if the messager is connected with another.
	 * 
	 * @throws IllegalStateException if no partner is connected
	 * to the current one.
	 */
	public void getMessage() throws IllegalStateException{
		if (!isConnected())
			throw new IllegalStateException("No partner connected");
		
		while (!partner.messageQueue.isEmpty())
			messageStack.push(partner.messageQueue.poll());
	}
	
	/**
	 * Prints all the messages stored in the messager's stack to the console.
	 * or "This stack is empty!" if the message stack is empty.
	 * This action will remove all the messages from the stack.
	 */
	public void displayMessages() {
		System.out.print(name + "'s message stack: ");
		messageStack.printAllElements();
	}
}
