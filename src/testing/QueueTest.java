package testing;

import dataStructure.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		queue.printAllElements();
		
		queue.offer("Loc");
		queue.offer("Huy");
		queue.offer("Khoa");
		queue.offer("Khanh");

		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		
		queue.printAllElements();
	}

}
