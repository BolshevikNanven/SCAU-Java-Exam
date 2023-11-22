package org.ex405.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class ArrayUtil {
    public static <T> T[] removeDuplicates(T[] array) {
        LinkedHashSet<T> set = new LinkedHashSet<>();
        for (T a:array){
            if(a!=null){
                set.add(a);
            }
        }
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), set.size());
        set.toArray(newArray);

        return newArray;
    }

    public static <T> T max(T[] array) {
        T[] a = (T[]) Arrays.stream(array).sorted().toArray();

        return a[a.length - 1];
    }

    public static <T> T min(T[] array) {
        T[] a = (T[]) Arrays.stream(array).sorted().toArray();

        return a[0];
    }
}
