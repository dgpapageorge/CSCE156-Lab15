package unl.cse.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

public class BinarySearchTreeTests {

	BinarySearchTree<Integer> testBST;

	private static final Comparator<Integer> INT_CMP = new Comparator<>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}		
	};
	
    @BeforeEach
    void bstSetup() {
    	testBST = new BinarySearchTree<>(INT_CMP);
    }

    @Test
    void bstTest() {
    	//TODO
    }
}
