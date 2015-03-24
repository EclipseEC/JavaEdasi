package praktikum1;

import java.util.Comparator;

public class NameComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int result = Integer.compare(o1.length(), o2.length());
		
		if (0 == result) {
			return o1.compareTo(o2);
		} else {
			return result;
		}
	}
}
