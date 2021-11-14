package com.github.alexbabkin.javalang.lambdas.runnablecombiner;

public class RunnableCombiner {
    public static Runnable combine(Runnable[] runnables) {
        return () -> {
            for (Runnable r : runnables) {
                r.run();
            }
        };
    }
}
