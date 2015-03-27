package ee.itcollege.praktikum4;

import java.util.ArrayList;
import java.util.Collections;

public class UniqueSortableList<T extends Comparable<T>> extends ArrayList<T> {

	public static enum SortDirection {
		ASCENDING, DESCENDING
	}

	@Override
	public boolean add(T e) {
		if (contains(e)) {
			return false;
		}
		return super.add(e);
	}

	/**
	 * Sorts this list ascending
	 */
	public void sort() {
		Collections.sort(this);
	}

	public void sort(SortDirection direction) {
		if (SortDirection.ASCENDING.equals(direction)) {
			sort();
		}

		Collections.sort(this, Collections.<T> reverseOrder());
	}

}
