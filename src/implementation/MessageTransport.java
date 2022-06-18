package implementation;

import java.util.Random;

public class MessageTransport {

	public static void main(String[] args) {
		/* 
		 * generates a random generator and 2 messagers
		 */
		Random randGenerator = new Random();
		Messager m1 = new Messager("M1");
		Messager m2 = new Messager("M2");
		
		/* connect the 2 messagers
		 * random a number
		 * if the number is even, m1 send a messager
		 * else m2 send a message
		 * lastly, the 2 messagers retrieve all in-coming messages
		 */
		try {
			m1.connect(m2);
			for (int i = 0; i < 20; i++) {
				int random = randGenerator.nextInt(9);
				if (random % 2 == 0)
					m1.sendMessage(String.valueOf(i));
				else
					m2.sendMessage(String.valueOf(i));
			}
			
			m1.getMessage();
			m2.getMessage();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		/*
		 * display all messages of the 2 messagers
		 */
		m1.displayMessages();
		m2.displayMessages();
	}

}
