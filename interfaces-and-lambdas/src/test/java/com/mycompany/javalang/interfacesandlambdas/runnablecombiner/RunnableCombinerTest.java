package com.mycompany.javalang.interfacesandlambdas.runnablecombiner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.lang.Runnable;

public class RunnableCombinerTest {
    @Test
    public void combineTest() {
        int[] arg = {1};
        Runnable[] runnables = {
            () -> arg[0]++,
            () -> arg[0]++,
            () -> arg[0]++,
            () -> arg[0]++,
            () -> arg[0]++
        };
        Runnable result = RunnableCombiner.combine(runnables);
        result.run();
        assertEquals(6, arg[0]);
    }
}