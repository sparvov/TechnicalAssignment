package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringLengthAggregator {

    private static Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) {
    }

    public Map<Integer, Integer> aggregate(List<String> strings) {
        result = new HashMap<>();
        doAggregate(strings,0);
        return result;
    }

    private void doAggregate(List<String> strings, int i) {
        if (i < strings.size()) {
            doAggregate(strings, i + 1);
            constructResult(strings.get(i));
        }
     }

    private void constructResult(String str) {
        Integer key = str.length();
        Integer value = result.get(key);
        if (value == null) {
            value = 1;
            result.put(key, value);
        } else {
            result.put(key, ++value);
        }
    }

}
