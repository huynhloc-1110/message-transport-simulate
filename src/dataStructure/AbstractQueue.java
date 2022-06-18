package dataStructure;

/**
 * The ADT for a queue that follows FIFO method.
 *
 * @param <E> the class of the elements to be hold in the queue
 * @author Le Huynh Loc
 * @since June 2022
 */
public interface AbstractQueue<E> {
	/**
	 * Puts the element at the tail (last position) of the queue.
	 * This action will increase the size of the queue.
	 * 
	 * @param element the element that you want to put onto the queue
	 */
	void offer(E element);
	
	/**
	 * Retrieves and removes the head of the queue,
	 * or returns null if the queue is empty.
	 * This action will decrease the size of the queue.
	 * 
	 * @return the head of the queue, or null if the queue is empty
	 */
	E poll();
	
	/**
	 * Retrieves, but does not remove, the head of the queue,
	 * or returns null if the queue is empty.
	 * 
	 * @return the head of the queue, or null if the queue is empty
	 */
	E peek();
	
	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return the number of elements in the queue
	 */
	int size();
	
	/**
	 * Returns true if the queue contains no elements.
	 * 
	 * @return true if the queue contains no elements
	 */
	boolean isEmpty();
	
	/**
	 * Prints all the elements of the queue to the console,
	 * or "This queue is empty!" if the queue is empty.
	 * This action will remove all the elements from the queue.
	 */
	void printAllElements();
}
