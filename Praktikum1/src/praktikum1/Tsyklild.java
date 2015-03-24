package praktikum1;

public class Tsyklild {
	public static void main(String[] args) {
		int suurus = 20;
		for (int i = 0; i < suurus; i++) {
			for (int j = 0; j < suurus; j++) {
				int rida = suurus - 1 - j;
				int veerg = suurus - 1 - i;
				
				int arv = Math.min(rida, veerg);
				
				System.out.format(" %3d", arv);
			}
			System.out.println();
		}
	}
}
