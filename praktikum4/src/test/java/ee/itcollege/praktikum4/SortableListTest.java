package ee.itcollege.praktikum4;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SortableListTest {

	@Test
	public void sortTestString() {
		UniqueSortableList<String> names = new UniqueSortableList<String>();
		names.add("Kati");
		names.add("Mati");
		names.sort(UniqueSortableList.SortDirection.ASCENDING);
		assertTrue(names.get(0) == "Kati");
		assertTrue(names.get(1) == "Mati");
		names.sort(UniqueSortableList.SortDirection.DESCENDING);
		assertTrue(names.get(0) == "Mati");
		assertTrue(names.get(1) == "Kati");
	}
	
	@Test
	public void sortTestInteger() {
		UniqueSortableList<Integer> numbers = new UniqueSortableList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(5);
		numbers.add(4);
		numbers.add(9);
		numbers.add(7);
		numbers.sort();
		assertTrue(numbers.get(0) == 1);
		assertTrue(numbers.get(numbers.size() - 1) == 9);
	}
}
