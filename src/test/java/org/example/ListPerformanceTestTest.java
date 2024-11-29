package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ListPerformanceTestTest {

    private static final int TEST_SIZE = 1000; // Уменьшено для тестов

    @Test
    public void testArrayListPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        performTests(arrayList, "ArrayList");
    }

    @Test
    public void testLinkedListPerformance() {
        List<Integer> linkedList = new LinkedList<>();
        performTests(linkedList, "LinkedList");
    }

    private void performTests(List<Integer> list, String listType) {
        // Тестирование добавления элементов
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        long addTime = endTime - startTime;

        // Проверка на количество добавленных элементов
        assertEquals(TEST_SIZE, list.size(), "Size of the list after adding elements should be equal to TEST_SIZE");

        // Тестирование получения элементов
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long getTime = endTime - startTime;

        // Тестирование удаления элементов
        startTime = System.nanoTime();
        for (int i = TEST_SIZE - 1; i >= 0; i--) {
            list.remove(i);
        }
        endTime = System.nanoTime();
        long removeTime = endTime - startTime;

        // Проверка на количество оставшихся элементов
        assertEquals(0, list.size(), "Size of the list after removing elements should be 0");

        // Вывод результатов (можно оставить для отладки, но не обязательно в тестах)
        System.out.printf("%s:\n", listType);
        System.out.printf("  add: %d ms\n", addTime / 100000);
        System.out.printf("  get: %d ms\n", getTime / 100000);
        System.out.printf("  remove: %d ms\n", removeTime / 100000);
        System.out.println();
    }
}
