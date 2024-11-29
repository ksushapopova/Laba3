package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest
{
    private static final int TEST_SIZE = 10000;

    public static void main(String[] args) {
        testListPerformance(new ArrayList<>(), "ArrayList");
        testListPerformance(new LinkedList<>(), "ArrayList");
    }
    private static void testListPerformance(List<Integer> list, String listType){
        long startTime = System.nanoTime();
        for(int i=0; i < TEST_SIZE; i++){
           list.add(i);
        }
        long endTime = System.nanoTime();
        long addTime = endTime - startTime;


        System.out.printf("%s:\n", listType);
        System.out.printf("  add: %d ms\n", addTime / 1_000_000);

        System.out.println();
    }
}
