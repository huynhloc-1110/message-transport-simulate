package dataStructure;

/**
 * The ADT for a stack that follows LIFO method.
 *
 * @param <E> the class of the elements to be hold in the stack
 * @author Le Huynh Loc
 * @since June 2022
 */
public interface AbstractStack<E> {
	
	/**
	 * Pushes an element onto the top of the stack.
	 * This action will increase the size of the stack.
	 * 
	 * @param element the element to be pushed onto the stack
	 */
	void push(E element);
	
	/**
	 * Removes the element at the top of the stack
	 * and returns that element as the value of this function.
	 * If the stack is empty, return {@code null} instead.
	 * This action will decrease the size of the stack.
	 * 
	 * @return the element at the top of the stack, or {@code null} if the stack is empty
	 */
	E pop();
	
	/**
	 * Retrieves, but does not remove, the top of the stack,
	 * or returns {@code null} if the stack is empty.
	 * 
	 * @return the top of the stack, or {@code null} if the stack is empty
	 */
	E peek();
	
	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return the number of elements in the stack
	 */
	int size();
	
	/**
	 * Returns {@code true} if the stack contains no elements.
	 * 
	 * @return {@code true} if the stack contains no elements
	 */
	boolean isEmpty();
	
	/**
	 * Prints all the elements of the stack to the console,
	 * or "This stack is empty!" if the stack is empty.
	 * This action will remove all the elements from the stack.
	 */
	void printAllElements();
}
