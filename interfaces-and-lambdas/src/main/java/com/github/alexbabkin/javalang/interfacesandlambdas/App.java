package com.github.alexbabkin.javalang.interfacesandlambdas;

import com.github.alexbabkin.javalang.interfacesandlambdas.runnablecombiner.RunnableCombiner;

public class App {
    public static void main(String[] args) {
        Runnable[] runnables = {
            () -> System.out.println("Runnable 1"),
            () -> System.out.println("Runnable 2"),
            () -> System.out.println("Runnable 3"),
            () -> System.out.println("Runnable 4"),
            () -> System.out.println("Runnable 5"),
        };
        Runnable result = RunnableCombiner.combine(runnables);
        result.run();
    }
}
