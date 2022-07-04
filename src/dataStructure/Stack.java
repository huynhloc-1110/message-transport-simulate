package dataStructure;

/**
 * A data structure that implements the AbstractStack ADT
 * It is implemented by setting a Node<E> as a top and link it to the previous Node.
 * 
 * @author Le Huynh Loc
 * @since June 2022
 */
public class Stack<E> implements AbstractStack<E> {
	
	/**
	 * A simple node structure with a body element and a previous reference
	 * to the previous node.
	 */
	private static class Node<E> {
		private E element;
		private Node<E> previous;
		
		public Node(E element) {
			this.element = element;
		}
	}
	
	/**
	 * The first (top) element of the stack.
	 */
	private Node<E> top;
	
	/**
	 * The number of elements hold in the stack.
	 */
	private int size;
	
	public void push(E element) {
		Node<E> newNode = new Node<>(element);
		newNode.previous = top;
		top = newNode;
		size++;
	}
	
	public E pop() {
		if (top == null) return null;
		
		E element = top.element;
		Node<E> temp = top.previous;
		top.previous = null;
		top = temp;
		size--;
		return element;
	}
	
	public E peek() {
		if (top == null) return null;
		
		return top.element;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public void printAllElements() {
		if (this.isEmpty()) {
			System.out.println("This stack is empty!");
			return;
		}
		
		System.out.print("[ ");
		while (!this.isEmpty()) {
			System.out.print(this.pop() + " ");
		}
		System.out.println("]");
	}
}
