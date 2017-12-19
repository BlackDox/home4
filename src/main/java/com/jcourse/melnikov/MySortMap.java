package com.jcourse.melnikov;

import java.util.*;

/**
 * Created by BlackDox on 18.12.2017.
 */
public class MySortMap {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map ) {
        System.out.println("Начат процесс сортировки...");

        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Отсортированный словарик заполнен:");
        return result;
    }
}
