package com.github.alexbabkin.javalang.lambdas.intsequence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class IntSequenceTest {
    @Test
    public void of_SeveralElements() {
        IntSequence seq = IntSequence.of(1, 2, 3, 4, 5);
        assertEquals(1, seq.next());
        assertEquals(2, seq.next());
        assertEquals(3, seq.next());
        assertEquals(4, seq.next());
        assertEquals(5, seq.next());
        assertFalse(seq.hasNext());
    }

    @Test
    public void of_NoElements() {
        IntSequence seq = IntSequence.of();
        assertFalse(seq.hasNext());
    }
}
