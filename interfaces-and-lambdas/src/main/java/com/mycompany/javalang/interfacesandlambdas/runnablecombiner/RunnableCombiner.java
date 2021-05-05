package com.mycompany.javalang.interfacesandlambdas.runnablecombiner;

public class RunnableCombiner {
    public static Runnable combine(Runnable[] runnables) {
        return () -> {
            for (Runnable r : runnables) {
                r.run();
            }
        };
    }
}
