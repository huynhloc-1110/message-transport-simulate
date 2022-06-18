package testing;

import dataStructure.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.printAllElements();
		
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		
		stack.printAllElements();
	}
}
