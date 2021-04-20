package om.mycompany.javalang.interfacesandlambdas.sorter;

import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Sorter {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings);
        }
    }

    private static boolean isSorted(List<String> strings, Comparator<String> comp) {
        if (strings.isEmpty() || strings.size() == 1) {
            return true;
        }
    
        Iterator<String> iter = strings.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (comp.compare(previous, current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}