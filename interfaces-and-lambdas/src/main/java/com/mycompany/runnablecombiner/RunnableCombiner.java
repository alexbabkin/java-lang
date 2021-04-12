package com.mycompany.runnablecombiner;

import java.lang.Runnable;

public class RunnableCombiner {
    public static Runnable combine(Runnable[] runnables) {
        return () -> {
            for(Runnable r : runnables) {
                r.run();
            }
        };
    }
}