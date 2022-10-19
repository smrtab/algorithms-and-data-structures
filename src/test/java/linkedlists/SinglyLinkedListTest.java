package linkedlists;

import com.library.datastructures.linkedlists.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> singlyLinkedList;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        singlyLinkedList = new SinglyLinkedList<>();
        for (int i = 0; i < input.length; i++) {
            singlyLinkedList.append(i);
        }
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(singlyLinkedList.get(i), i);
        }
    }

    @Test
    void testSize() {
        assertEquals(singlyLinkedList.size(), 5);
    }

    @Test
    void testGetIndexOutOfBound3Times() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.get(5);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.get(15);
        });
    }

    @Test
    void testSetIndexOutOfBound3Times() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.set(-1, 0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.set(5, 0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.set(15, 0);
        });
    }

    @Test
    void testSetValues3Times() {
        singlyLinkedList.set(0, 100);
        singlyLinkedList.set(1, 200);
        singlyLinkedList.set(4, 400);
    }

    @Test
    void testAppend3Values() {
        singlyLinkedList.append(100);
        singlyLinkedList.append(200);
        singlyLinkedList.append(300);

        assertEquals(singlyLinkedList.size(), 8);
        assertEquals(singlyLinkedList.get(5), 100);
        assertEquals(singlyLinkedList.get(6), 200);
        assertEquals(singlyLinkedList.get(7), 300);
    }

    @Test
    void testPopFirst() {
        int value0 = singlyLinkedList.popFirst();
        assertEquals(value0, 0);
        int value1 = singlyLinkedList.popFirst();
        assertEquals(value1, 1);
        assertEquals(singlyLinkedList.size(), 3);
    }

    @Test
    void testEmptyListPopFirst() {
        SinglyLinkedList<Integer> emptySinglyLinkedList = new SinglyLinkedList<>();
        assertTrue(emptySinglyLinkedList.isEmpty());
        Exception exception = assertThrows(RuntimeException.class, emptySinglyLinkedList::popFirst);
        assertEquals("Empty list", exception.getMessage());
    }

    @Test
    void testInsert3Values() {
        singlyLinkedList.insert(0, -1);
        assertEquals(singlyLinkedList.get(0), -1);
        assertEquals(singlyLinkedList.get(1), 0);

        singlyLinkedList.insert(0, -2);
        assertEquals(singlyLinkedList.get(0), -2);
        assertEquals(singlyLinkedList.get(1), -1);

        singlyLinkedList.insert(0, -3);
        assertEquals(singlyLinkedList.get(0), -3);
        assertEquals(singlyLinkedList.get(1), -2);

        assertEquals(singlyLinkedList.size(), 8);
    }

    @Test
    void testRemove3Values() {
        singlyLinkedList.remove(0);
        assertEquals(singlyLinkedList.get(0), 1);

        singlyLinkedList.remove(2);
        assertEquals(singlyLinkedList.get(2), 4);

        assertEquals(singlyLinkedList.size(), 3);
    }

    @Test
    void testToArray() {
        int index = 0;
        for (Integer value : singlyLinkedList) {
            assertEquals(singlyLinkedList.get(index), value);
            index++;
        }
    }
}