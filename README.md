# Message Transport Simulation
## Description
A simple java application to simulate how messages are transported and processed between two machines using Queue and Stack data structures.
This is a part of my assignment in the course Data Structure and Algorithms while studying at Greenwich University.

## Project structure
The `src` folder includes 3 packages: `dataStructure`, `implementation` and `testing`.
- `dataStructure` contains the ADTs and implementation for Queue and Stack.
- `implementation` contains the `Messager` class, which simulates a message transfer machine, and `MessageTransport` class, which
includes a `main` method to simulate the process of sending and receiving messages between 2 messagers.
- `testing` contains JUnit test cases for Queue, Stack and `Messager` class. Time complexity test is also placed here.

## Download and Run
1. Import this project to your workspace with your favorite java IDE.
2. Run `MessageTransport` to see the message transfering process.
3. Run `QueueTest`, `StackTest` and `MessagerTest` with JUnit to see the test cases result.
4. Run `TimeComplexityTest` to see the average time taken to transfer and process a message.
