package exception;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Item70 {

	public static void main(String[] args) {
		CheckCard checkCard = new CheckCard(999);

		try {
			checkCard.buySomething(1_000);
		} catch (LowBalanceException e) {
			log.warn("CheckCard can't buy something because balance is not enough {} won", e.getInsufficientAmount());

			showWarningMessageToCustomer(e.getInsufficientAmount());
		}
	}

	private static void showWarningMessageToCustomer(double insufficientAmount) {
		System.out.println(insufficientAmount);
	}

	static class CheckCard {

		private double balance;

		public CheckCard(double balance) {
			Preconditions.checkArgument(0 <= balance, "This is not minus card!");

			this.balance = balance;
		}

		public void buySomething(double somethingPrice) throws LowBalanceException {
			if (isLowBalance(somethingPrice)) {
				throw new LowBalanceException("", 1d);
			}

			balance -= somethingPrice;
		}

		private boolean isLowBalance(double somethingPrice) {
			return balance - somethingPrice < 0;
		}
	}

	static class LowBalanceException extends Exception {
		private double insufficientAmount;

		public LowBalanceException(String message, double insufficientAmount) {
			super(message);

			this.insufficientAmount = insufficientAmount;
		}

		public double getInsufficientAmount() {
			return insufficientAmount;
		}
	}
}
