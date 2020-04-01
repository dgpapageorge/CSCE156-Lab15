package unl.cse.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinarySearchTreeTests {

    BinarySearchTree<Integer> testBST;

    private static final Comparator<Integer> INT_CMP = Integer::compareTo;

    @BeforeEach
    void bstSetup() {
        testBST = new BinarySearchTree<>(INT_CMP);
    }

    @Test
    void bstFindElementTest() {
        testBST.addElement(1);
        testBST.addElement(2);
        testBST.addElement(3);
        testBST.addElement(4);
        testBST.addElement(5);
        testBST.addElement(6);
        testBST.addElement(7);

        assertEquals(1, testBST.findElement(1));
        assertEquals(2, testBST.findElement(2));
        assertEquals(3, testBST.findElement(3));
        assertEquals(4, testBST.findElement(4));
        assertEquals(5, testBST.findElement(5));
        assertEquals(6, testBST.findElement(6));
        assertEquals(7, testBST.findElement(7));

        assertNull(testBST.findElement(0));
        assertNull(testBST.findElement(10));
        assertNull(testBST.findElement(-3));
    }

    @Test
    void bstGetNumberOfLeavesTest() {
        testBST.addElement(2);
        testBST.addElement(1);
        testBST.addElement(3);
        assertEquals(2, testBST.getNumLeaves());

        testBST = new BinarySearchTree<>(INT_CMP);
        testBST.addElement(1);
        testBST.addElement(2);
        testBST.addElement(3);
        assertEquals(1, testBST.getNumLeaves());

        testBST = new BinarySearchTree<>(INT_CMP);
        testBST.addElement(3);
        testBST.addElement(2);
        testBST.addElement(1);
        assertEquals(1, testBST.getNumLeaves());

        testBST = new BinarySearchTree<>(INT_CMP);
        testBST.addElement(7);
        testBST.addElement(3);
        testBST.addElement(11);
        testBST.addElement(1);
        testBST.addElement(5);
        testBST.addElement(9);
        testBST.addElement(13);
        testBST.addElement(0);
        testBST.addElement(2);
        testBST.addElement(4);
        testBST.addElement(6);
        testBST.addElement(8);
        testBST.addElement(10);
        testBST.addElement(12);
        testBST.addElement(14);
        assertEquals(8, testBST.getNumLeaves());
    }

    @Test
    void preOrderTraversalTest() {
        testBST.addElement(48);
        testBST.addElement(28);
        testBST.addElement(58);
        testBST.addElement(17);
        testBST.addElement(42);
        testBST.addElement(51);
        testBST.addElement(64);
        testBST.addElement(59);

        List<Integer> expectedOrder = new ArrayList<>(Arrays.asList(48, 28, 17, 42, 58, 51, 64, 59));

        assertEquals(expectedOrder, testBST.preOrderTraverse());
    }

    @Test
    void inOrderTraversalTest() {
        testBST.addElement(48);
        testBST.addElement(28);
        testBST.addElement(58);
        testBST.addElement(17);
        testBST.addElement(42);
        testBST.addElement(51);
        testBST.addElement(64);
        testBST.addElement(59);

        List<Integer> expectedOrder = new ArrayList<>(Arrays.asList(17, 28, 42, 48, 51, 58, 59, 64));

        assertEquals(expectedOrder, testBST.inOrderTraverse());
    }

    @Test
    void postOrderTraversalTest() {
        testBST.addElement(48);
        testBST.addElement(28);
        testBST.addElement(58);
        testBST.addElement(17);
        testBST.addElement(42);
        testBST.addElement(51);
        testBST.addElement(64);
        testBST.addElement(59);

        List<Integer> expectedOrder = new ArrayList<>(Arrays.asList(17, 42, 28, 51, 59, 64, 58, 48));

        assertEquals(expectedOrder, testBST.postOrderTraverse());
    }
}
