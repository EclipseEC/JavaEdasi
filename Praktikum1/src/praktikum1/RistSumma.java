package praktikum1;

import java.util.Scanner;

public class RistSumma {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();
		String numberString = Integer.toString(number);
		int sum = 0;
		for (int i = 0; i < numberString.length(); i++) {
			int num = Integer.parseInt(String.valueOf(numberString.charAt(i)));
			sum += num;
		}
		System.out.println(sum);
	}
}
