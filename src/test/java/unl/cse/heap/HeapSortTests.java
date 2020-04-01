package unl.cse.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class HeapSortTests {
	
	public static final Random r = new Random();
	
	public static final Comparator<Integer> INT_CMP = new Comparator<>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}		
	};

	/**
	 * Tests that the {@link HeapSort#heapSort(java.util.List, java.util.Comparator)} 
	 * method properly sorts by testing a small fixed list of integers.
	 * 
	 */
	@Test
	void heapSortFixedTest() {
		
		List<Integer> a = new ArrayList<>(Arrays.asList(1, 6, 2, 7, 3, 8, 4, 9, 5, 10));
		List<Integer> b = new ArrayList<>(a);
		HeapSort.heapSort(a, INT_CMP);
		Collections.sort(b, INT_CMP);
		Assertions.assertEquals(a, b, "Heapsort did not match the expected sort order for the given array");
	}
	
	/**
	 * Tests that the {@link HeapSort#heapSort(java.util.List, java.util.Comparator)} 
	 * method properly sorts by generating a random list of integers.
	 */
	@RepeatedTest(10)
	void heapSortRandomTest() {
		
		List<Integer> a = new ArrayList<>();
		for(int i=0; i<1000; i++) {
			a.add(r.nextInt());
		}
		List<Integer> b = new ArrayList<>(a);
		HeapSort.heapSort(a, INT_CMP);
		Collections.sort(b, INT_CMP);
		

		Assertions.assertEquals(a, b, "Heapsort did not match the expected sort order for the given array");
	}

}
