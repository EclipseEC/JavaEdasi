package praktikum1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {
    private static Scanner scanner;

    public static BigInteger fibo(int number, HashMap<Integer, BigInteger> memory) {
	if (number == 1) {
	    memory.put(number, BigInteger.ONE);
	    return memory.get(number);
	}
	if (number == 0) {
	    memory.put(number, BigInteger.ZERO);
	    return memory.get(number);
	}
	if (memory.containsKey(number)) {
	    return memory.get(number);
	}
	memory.put(number, fibo(number - 1, memory).add(fibo(number - 2, memory)));
	return memory.get(number);
    }

    public static void main(String[] args) {
	scanner = new Scanner(System.in);
	System.out.println(fibo(scanner.nextInt(), new HashMap<Integer, BigInteger>()));
    }
}