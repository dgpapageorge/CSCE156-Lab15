package unl.cse;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeapSort {

	public static final Comparator<Integer> INT_CMP = Integer::compareTo;

	/**
	 * Sorts the given {@link List} using the provided {@link Comparator} using a
	 * heap sort algorithm.
	 * 
	 * @param <T>
	 * @param list
	 * @param comp
	 */
	public static <T> void heapSort(List<T> list, Comparator<T> comp) {

		// TODO: implement this using

		return;
	}

	public static void main(String args[]) {

		List<Integer> input = Arrays.asList(9, 4, 6, 2, 7, 8, 1, 3, 5);
		HeapSort.heapSort(input, INT_CMP);
		System.out.println(input);
	}
}
