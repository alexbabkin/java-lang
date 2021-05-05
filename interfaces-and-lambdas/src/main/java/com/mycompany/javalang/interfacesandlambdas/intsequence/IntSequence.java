package com.mycompany.javalang.interfacesandlambdas.intsequence;

public interface IntSequence {
    boolean hasNext();
    int next();
    public static IntSequence of (int... values) {
        return new IntSequence() {
            private final int[] vals = values;
            private int curIdx = 0;

            @Override
            public boolean hasNext() {
                return curIdx < vals.length;
            }

            @Override
            public int next() {
                int res = vals[curIdx];
                curIdx += 1;
                return res;
            }
        };
    }
}