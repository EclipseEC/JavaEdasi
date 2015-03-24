package praktikum1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tulpdiagramm {
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		boolean condition = true;
		while (condition) {
			int enteredNumber = scanner.nextInt();
			if (enteredNumber < 1) {
				condition = false;
			} else {
				numbers.add(enteredNumber);
			}
		}
		scanner.close();
		
		int max = Collections.max(numbers);
		int size = numbers.size();
		int maxWidth = String.valueOf(max).length() + 1;
		System.out.println("Max element: " + max);
		System.out.println("Array size: " + size);
		System.out.println("Array: " + numbers);
		
		//Iksid
		for (int i = 0; i < max; i++) {
			for (Integer number: numbers) {
				String iks = number >= max - i ? "X" : " ";
				System.out.format("%" + maxWidth + "s", iks);
			}
			System.out.println();
		}
		
		//Joon
		int lines = maxWidth * numbers.size();
		String line = String
				.format("%" + lines + "s", "")
				.replace(' ', '-');
		System.out.println(line);
		
		//Numbers
		for (Integer number: numbers) {
			System.out.format("%" + maxWidth + "d", number);
		}
	}
}
