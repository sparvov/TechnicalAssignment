package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class StringLengthAggregatorTest {

    private static final int TEST_ITERATIONS_NUMBER = 50;
    private static final int MIN_STRING_LENGTH = 1;
    private static final int MAX_STRING_LENGTH = 50;
    private static final int STRINGS_NUMBER = 50;

    @Test
    public void mergeSort() {
        StringLengthAggregator aggregator = new StringLengthAggregator();

        for (int i = 0; i < TEST_ITERATIONS_NUMBER; i++) {
            List<String> listOfStrings = createListOfStrings();
            System.out.println(listOfStrings);

            Map<Integer, Integer> expectedResult = getExpectedResult(listOfStrings);
            System.out.println("Expected result:");
            System.out.println(expectedResult.toString());

            Map<Integer, Integer> actualResult = aggregator.aggregate(listOfStrings);
            System.out.println("Actual result:");
            System.out.println(actualResult.toString());
            System.out.println();

            assertResult(expectedResult, actualResult);
        }
    }

    private void assertResult(Map<Integer, Integer> expectedResult, Map<Integer, Integer> actualResult) {
        Assert.assertEquals(expectedResult.size(), actualResult.size());
        expectedResult.forEach((k, v) -> Assert.assertEquals(v, actualResult.get(k)));
    }

    private List<String> createListOfStrings() {
        return IntStream.range(0, STRINGS_NUMBER)
                .mapToObj(this::createStringWithRandomLength)
                .collect(Collectors.toList());
    }

    private String createStringWithRandomLength(int i) {
        int randomInt = getRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < randomInt; j++) {
            stringBuilder.append("a");
        }
        return stringBuilder.toString();
    }

    private Integer getRandom() {
        return MIN_STRING_LENGTH + (int)(Math.random() * (MAX_STRING_LENGTH - MIN_STRING_LENGTH));
    }

    private Map<Integer, Integer> getExpectedResult(List<String> strings) {
        Map<Integer, Integer> expectedResult = new HashMap<>();
        strings.forEach(str -> {
            Integer key = str.length();
            Integer value = expectedResult.get(key);
            if (value == null) {
                value = 1;
                expectedResult.put(key, value);
            } else {
                expectedResult.put(key, ++value);
            }
        });
        return expectedResult;
    }

}
