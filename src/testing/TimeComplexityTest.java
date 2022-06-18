package testing;

import implementation.Messager;

public class TimeComplexityTest {

	public static void main(String[] args) {
		Messager m1 = new Messager("M1");
		Messager m2 = new Messager("M2");
		int testTime = 1_000_000;
		long testResult = 0;
		
		try {
			m1.connect(m2);
			long startTime = System.currentTimeMillis();
			
			for (int i = 0; i < testTime; i++) {
				m1.sendMessage("randomString");
				m2.getMessage();
				m2.displayMessages();
			}
			
			long endTime = System.currentTimeMillis();
			long elapsed = endTime - startTime;
			testResult = elapsed;
			m1.disconnect();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("\nAverage time: " + testResult * 1.0 / testTime );
	}

}
