package com.library.datastructures.hashtables;

import com.library.datastructures.hashtables.HashTableSeparateChaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HashTableSeparateChainingTest {

    private HashTableSeparateChaining<String, Integer> hashTableSeparateChaining;
    private final String[] letters = new String[] {"a", "b", "c", "d", "e", "f", "j", "h", "i", "g"};

    @BeforeEach
    void setUp() {
        hashTableSeparateChaining = new HashTableSeparateChaining<>();
        for (int i = 0; i < letters.length; i++) {
            hashTableSeparateChaining.add(letters[i], i);
        }
    }

    @Test
    void testAllValuesAreAdded() {
        for (int i = 0; i < letters.length; i++) {
            assertEquals(hashTableSeparateChaining.get(letters[i]), i);
        }
    }

    @Test
    void testSize() {
        assertEquals(hashTableSeparateChaining.size(), 10);
    }

    @Test
    void testHasKeyMethod3TimesTrue() {
        assertTrue(hashTableSeparateChaining.hasKey("a"));
        assertTrue(hashTableSeparateChaining.hasKey("f"));
        assertTrue(hashTableSeparateChaining.hasKey("j"));
    }

    @Test
    void testHasKeyMethod3TimesFalse() {
        assertFalse(hashTableSeparateChaining.hasKey("k"));
        assertFalse(hashTableSeparateChaining.hasKey("q"));
        assertFalse(hashTableSeparateChaining.hasKey("z"));
    }

    @Test
    void testRemove3Entities() {
        assertFalse(hashTableSeparateChaining.hasKey("k"));
        assertFalse(hashTableSeparateChaining.hasKey("q"));
        assertFalse(hashTableSeparateChaining.hasKey("z"));
    }
}
