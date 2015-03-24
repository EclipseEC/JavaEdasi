package praktikum1;

public class Astendamine {
	public static double aste(double number, int power) {
		if (power == 0) {
			return 1;
		} else if (power == 1) {
				return number;
		} else if (power < 0) {
			return aste(number, power + 1) / number;
		} else {
		return number * aste(number, power - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(aste(5, -2));
	}
}