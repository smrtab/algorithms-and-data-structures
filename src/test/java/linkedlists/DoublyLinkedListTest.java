package linkedlists;

import com.library.datastructures.linkedlists.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> doublyLinkedList;
    private final int[] input = new int[5];

    @BeforeEach
    void setUp() {
        doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < input.length; i++) {
            doublyLinkedList.append(i);
        }
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(doublyLinkedList.get(i), i);
        }
    }

    @Test
    void testSize() {
        assertEquals(doublyLinkedList.size(), 5);
    }

    @Test
    void testGetIndexOutOfBound3Times() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.get(5);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.get(15);
        });
    }

    @Test
    void testSetIndexOutOfBound3Times() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.set(-1, 0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.set(5, 0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.set(15, 0);
        });
    }

    @Test
    void testSetValues3Times() {
        doublyLinkedList.set(0, 100);
        doublyLinkedList.set(1, 200);
        doublyLinkedList.set(4, 400);
    }

    @Test
    void testAppend3Values() {
        doublyLinkedList.append(100);
        doublyLinkedList.append(200);
        doublyLinkedList.append(300);

        assertEquals(doublyLinkedList.size(), 8);
        assertEquals(doublyLinkedList.get(5), 100);
        assertEquals(doublyLinkedList.get(6), 200);
        assertEquals(doublyLinkedList.get(7), 300);
    }

    @Test
    void testPopFirst() {
        int value0 = doublyLinkedList.popFirst();
        assertEquals(value0, 0);
        int value1 = doublyLinkedList.popFirst();
        assertEquals(value1, 1);
        assertEquals(doublyLinkedList.size(), 3);
    }

    @Test
    void testEmptyListPopFirst() {
        DoublyLinkedList<Integer> emptyDoublyLinkedList = new DoublyLinkedList<>();
        assertTrue(emptyDoublyLinkedList.isEmpty());
        Exception exception = assertThrows(RuntimeException.class, emptyDoublyLinkedList::popFirst);
        assertEquals("Empty list", exception.getMessage());
    }

    @Test
    void testInsert3Values() {
        doublyLinkedList.insert(0, -1);
        assertEquals(doublyLinkedList.get(0), -1);
        assertEquals(doublyLinkedList.get(1), 0);

        doublyLinkedList.insert(0, -2);
        assertEquals(doublyLinkedList.get(0), -2);
        assertEquals(doublyLinkedList.get(1), -1);

        doublyLinkedList.insert(0, -3);
        assertEquals(doublyLinkedList.get(0), -3);
        assertEquals(doublyLinkedList.get(1), -2);

        assertEquals(doublyLinkedList.size(), 8);
    }

    @Test
    void testRemove3Values() {
        doublyLinkedList.remove(0);
        assertEquals(doublyLinkedList.get(0), 1);

        doublyLinkedList.remove(2);
        assertEquals(doublyLinkedList.get(2), 4);

        assertEquals(doublyLinkedList.size(), 3);
    }

    @Test
    void testToArray() {
        int index = 0;
        for (Integer value : doublyLinkedList) {
            assertEquals(doublyLinkedList.get(index), value);
            index++;
        }
    }
}