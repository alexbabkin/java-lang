package com.mycompany.javalang.interfacesandlambdas.runnablecombiner;

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