package ru.geekbrains.chendyreva.homework6;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class Task1 {
    public static void main(String[] args) {
        // Задание 1
        int array [] = {  1, 2, 4, 4, 2, 3, 4, 1, 7  };

        int result1 [] = new Task1().returnAfterLastNumber(array, 4);
        System.out.println(Arrays.toString(result1));

        // Задание 2
        int array2 [] = {1, 1, 1, 1, 4, 1, 4, 1, 1  };

        boolean result2 = new Task1().testArrayContent(array2, 1,4);
        if (result2) {
            System.out.printf("Все хорошо, массив содержит только указанные числа!\n");
        } else {
            System.err.printf("Что то пошло не так!\n");
        }
    }

    /**
     * 2.  метод, который проверяет что массив состоит только из чисел 1 и 4.
     */
    public boolean testArrayContent(int[] array, int ... testNumbers) {

        // Проверка на то что элементы массива входят в диапазон тестовых
        Set<Integer> collect1 = Arrays.stream(testNumbers).boxed().collect(Collectors.toSet());
        for (int testedNumber : array) {
            if(!collect1.contains(testedNumber)) return false;
        }

        // Проверка на то что тестовые числа точно в массиве
        Set<Integer> collect2 = Arrays.stream(array).boxed().collect(Collectors.toSet());
        for (int testNumber : testNumbers) {
            if(!collect2.contains(testNumber)) return false;
        }

        return true;
    }
    /**
     * 1.  метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив, метод должен
     */
    public int[] returnAfterLastNumber ( int[] ar, int number){
        if (!contains(ar, number)) {
            throw new RuntimeException("Массив не содержит " + number);
        }

        int index = 0;
        for (int i = ar.length - 1; i >= 0; i--) {
            if (ar[i] == number) {
                index = i + 1;
                break;
            }
        }

        return Arrays.copyOfRange(ar, index, ar.length);
    }

    private static boolean contains ( int[] ar, int num){
        return Arrays.stream(ar).parallel().anyMatch(value -> value == num);
    }
}




