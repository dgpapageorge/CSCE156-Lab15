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
		boolean cont = true;
		while(cont == true)
		{
			cont = false;
			for (int i = 0; i< list.size()-1;i++)
			{
				if (comp.compare(list.get(i),list.get(i+1))> 0)
				{
					T temp = list.get(i+1);
					list.set(i+1, list.get(i));
					list.set(i, temp);
					cont = true;
				}
			}
		}
		return;
	}

	public static void main(String args[]) {

		List<Integer> input = Arrays.asList(9, 4, 6, 2, 7, 8, 1, 3, 5);
		HeapSort.heapSort(input, INT_CMP);
		System.out.println(input);
	}
}
