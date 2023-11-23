package hw1;

import java.util.Arrays;
import java.util.List;

import static hw1.Task1.averageAllEven;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> numbers10 = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
    List<Integer> numbersEmpty = List.of();

    @org.junit.jupiter.api.Test
    void averageAllEvenTest() {
        assertEquals(6.0, averageAllEven(numbers));
        assertEquals(55.0, averageAllEven(numbers10));
        assertEquals(0.0, averageAllEven(numbersEmpty));
    }
}