package org.thealphalab.education.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByTest {

    @Test
    public void testGroupingBy(){
        List<String> list = Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        map.forEach((x, y) -> System.out.println(x + "\t" + y));
    }

}
