package exception;

/**
 * 예외 상황을 이용하여 Program 이 정상적으로 동작한 경우 아래와 같은 문제점들이 존재한다.
 *
 * 1. 로직 내에 동일한 Exception 이 발생하는 로직이 들어간 경우, 어떤 부분에 의한 문제인지를 파악하기가 쉽지 않다.
 *
 * 2. Exception 이 어떠한 역할을 하기를 기대하는지를 Logic 과 같이 확인을 해야한다. 이는 Bug 가 발생하고 유지보수하기 쉽지 않다.
 *
 */
public class Item69 {

	static int[] orderNumbers = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args) {
		// Bad pattern
		printTheOrderNumberUsingException();

		// Good pattern
		printTheOrderNumberUsingForeach();
	}

	/**
	 * Iteration 을 돌면서 Exception 이 발생할때까지 orderNumber 를 출력하는 Function
	 */
	private static void printTheOrderNumberUsingException() {
		try {
			int i = 0;

			while (true) {
				System.out.println(orderNumbers[i++]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	/**
	 * Foreach 문을 통하여 orderNumber 를 출력하는 Function
	 */
	private static void printTheOrderNumberUsingForeach() {
		for (int orderNumber : orderNumbers) {
			System.out.println(orderNumber);
		}
	}
}
