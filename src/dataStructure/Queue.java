package dataStructure;

/**
 * A data structure that implements the AbstractQueue ADT
 * It is implemented by setting a Node<E> as a head and link it to the next Node.
 * 
 * @author Le Huynh Loc
 * @since June 2022
 */
public class Queue<E> implements AbstractQueue<E> {
	
	/**
	 * A simple node structure with a body element and a next reference to the next node.
	 */
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E element) {
			this.element = element;
		}
	}
	
	/**
	 * The first element of the queue.
	 */
	private Node<E> head;
	
	/**
	 * The number of elements hold in the queue.
	 */
	private int size;
	
	public void offer(E element) {
		Node<E> newNode = new Node<>(element);
		if (head == null)
			head = newNode;
		else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}
	
	public E poll() {
		if (head == null)
			return null;
		
		E element = head.element;
		Node<E> temp = head;
		head = head.next;
		temp.next = null;
		size--;
		return element;
	}
	
	public E peek() {
		if (head == null)
			return null;
		
		return head.element;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void printAllElements() {
		if (this.isEmpty()) {
			System.out.println("This queue is empty!");
			return;
		}
		
		System.out.print("[ ");
		while (!this.isEmpty()) {
			System.out.print(this.poll() + " ");
		}
		System.out.println("]");
	}
}
