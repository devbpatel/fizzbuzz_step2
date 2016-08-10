package main.java.com.tf;

public class FizzBuzz {

	private static final String DELIMETER = " ";

	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		System.out.println(fizzBuzz.buildOutput(1, 20));
	}

	public String getOutput(int number) {
		String output = null;
		if (Integer.toString(number).contains("3")) {
			output = FizzBuzzEnum.lucky.toString();
		} else if (number % 15 == 0) {
			output = FizzBuzzEnum.fizzbuzz.toString();
		} else if (number % 3 == 0) {
			output = FizzBuzzEnum.fizz.toString();
		} else if (number % 5 == 0) {
			output = FizzBuzzEnum.buzz.toString();
		} else {
			output = Integer.toString(number);
		}
		return output;
	}

	public String buildOutput(int from, int to) {
		validateRange(from, to);
		StringBuilder result = new StringBuilder();
		for (int i = from; i <= to; i++) {
			result.append(getOutput(i));

			if (i < to) {
				result.append(DELIMETER);
			}
		}
		return result.toString();
	}

	private void validateRange(int from, int to) {
		// TODO: Confirm with product team about Zero and Negatives
		if (from <= 0 || to <= 0) {
			throw new IllegalArgumentException(
					"Range cannot have zero or negative number");
		} else if (from >= to) {
			throw new IllegalArgumentException(
					"from range must be less than to range");
		}
	}
}
