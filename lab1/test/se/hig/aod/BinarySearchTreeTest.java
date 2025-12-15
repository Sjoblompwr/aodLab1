import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.hig.aod.lab1.BinarySearchTree;
public class BinarySearchTreeTest {



    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<Integer>();
    }

    @Test
    void testEmptyTreeSize() {
        assertTrue(bst.size() == 0);
    }

    @Test
    void testAddSingleElement() {
        bst.addElement(1);
        assertTrue(bst.size() == 1);
    }

    @Test
    void testAddMultipleElements() {
        bst.addElement(1);
        bst.addElement(2);
        bst.addElement(3);
        bst.addElement(5);
        bst.addElement(4);
        assertTrue(bst.size() == 5);
    }

@Test
void testAddNullElement() {
    assertThrows(IllegalArgumentException.class, () -> {
        bst.addElement(null);
    });
}


    @Test
    void testSearchExistingElement() {
        bst.addElement(1);
        bst.addElement(2);
        bst.addElement(3);
        bst.addElement(5);
        bst.addElement(4);
        assertTrue(bst.searchElement(1).equals(1));
        assertTrue(bst.searchElement(2).equals(2));
        assertTrue(bst.searchElement(3).equals(3));
        assertTrue(bst.searchElement(4).equals(4));
        assertTrue(bst.searchElement(5).equals(5));
    }

    @Test
    void testSearchNonExistingElement() {
        bst.addElement(1);
        bst.addElement(2);
        assertTrue(bst.searchElement(5) == null);
    }

    @Test
    void testToStringInOrder() {
        bst.addElement(1);
        bst.addElement(2);
        bst.addElement(3);
        bst.addElement(5);
        bst.addElement(4);

        assertTrue(bst.toString().equals("12345"));

    }

    @Test
    void testDuplicateIgnored() {
        bst.addElement(1);
        bst.addElement(2);
        bst.addElement(3);
        bst.addElement(5);
        bst.addElement(4);
        bst.addElement(1);
        bst.addElement(2);
        bst.addElement(3);
        bst.addElement(5);
        bst.addElement(4);

        assertTrue(bst.size() == 5);
        assertTrue(bst.toString().equals("12345"));
        
    }
}

