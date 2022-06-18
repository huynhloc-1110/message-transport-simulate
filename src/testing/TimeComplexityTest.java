package testing;

import implementation.Messager;

public class TimeComplexityTest {

	public static void main(String[] args) {
		Messager m1 = new Messager("M1");
		Messager m2 = new Messager("M2");
		
		long[] timeList = new long[20];
		
		try {
			m1.connect(m2);
			for (int i = 0; i < timeList.length; i++) {
				long startTime = System.currentTimeMillis();
				
				for (int j = 0; j < 100000; j++) {
					m1.sendMessage("randomString");
					m2.getMessage();
					m2.displayMessages();
				}
				
				long endTime = System.currentTimeMillis();
				long elapsed = endTime - startTime;
				timeList[i] = elapsed;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Time recorded:");
		long sum = 0;
		for (long num : timeList) {
			System.out.print(num + " ");
			sum += num;
		}
		
		System.out.println("\nAverage time: " + sum * 1.0 / timeList.length );
	}

}
