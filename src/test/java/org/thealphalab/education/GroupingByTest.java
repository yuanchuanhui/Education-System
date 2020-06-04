package org.thealphalab.education;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByTest {

    public static void main(String[] args) {
        int[][] data = {
                {1,2,3,4},
                {1,2,3,5},
                {1,2,3,6},
                {1,2,3,7},
                {1,2,4,4},
                {1,2,4,5},
                {1,2,4,6},
                {1,3,4,6},
                {1,3,4,7},
                {1,3,4,8},
                {2,2,3,8},
                {2,2,3,3},
                {2,3,3,1},
                {2,3,3,2},
                {2,3,4,2},
                {2,3,4,3},
        };
        Map<Integer, Map<Integer, Map<Integer, List<int[]>>>> map =
                Arrays.stream(data).collect(
                        Collectors.groupingBy(arr -> arr[0],
                                Collectors.groupingBy(arr -> arr[1],
                                        Collectors.groupingBy(arr -> arr[2]))));
        System.out.println(map);
    }

}
