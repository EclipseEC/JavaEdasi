package praktikum1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortNames {
	private static Scanner scanner;
	
	public static void main(String [] args) {
		scanner = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		int size = 5;
		System.out.printf("Sisesta %d nime\n", size);
		for (int i = 0; i < size; i++) {
			names.add(scanner.next());
		}
		scanner.close();
		Collections.sort(names, new NameComparator());
//		Collections.sort(names);
		for (String name : names) {
			System.out.println(name);
		}
	}
}
