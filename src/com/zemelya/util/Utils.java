package com.zemelya.util;

import java.util.Collection;
import java.util.Iterator;

public class Utils {

    public static <T extends Collection> void printCollection(T collection) {

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
