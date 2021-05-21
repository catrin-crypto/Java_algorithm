package lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] myArr = new int[20];
        int[] copyArr;
        Random rand = new Random();

        long start1 = System.nanoTime();
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = rand.nextInt();
        }
        myArr[3] = 23;
        long finish1 = System.nanoTime();

        long start = System.nanoTime();
        copyArr = Arrays.copyOf(myArr, myArr.length);
        long finish = System.nanoTime();

//      System.out.println("Original array: " + Arrays.toString(myArr) + "\n" + "Array copy: " + Arrays.toString(copyArr));
        System.out.println("Copying array time: " + (finish - start) + "ns");
        System.out.println("Filling array time: " + (finish1 - start1) + "ns");

        Arrays.sort(myArr);
        System.out.println("Sorted array: " + Arrays.toString(myArr));

        int foundIndex = -1;
        int key = 23;
        long startLinear = System.nanoTime();
        foundIndex = linearSearch(myArr, key);
        long finishLinear = System.nanoTime();
        System.out.println("Linear search time: " + (finishLinear - startLinear) + "ns");
        if (foundIndex != -1) {
            System.out.println("Found index " + foundIndex);
        } else {
            System.out.println("Element not found!");
        }

        int elementToSearch = 23;
        foundIndex = -1;
        long startBinary = System.nanoTime();
        foundIndex = binarySearch(myArr, elementToSearch);
        long finishBinary = System.nanoTime();
        System.out.println("Binary search time: " + (finishBinary - startBinary) + "ns");
        if (foundIndex != -1) {
            System.out.println("Found index " + foundIndex);
        } else {
            System.out.println("Element not found!");
        }

        int[] arrForSort = new int[400];
        for (int i = 0; i < arrForSort.length; i++) {
            arrForSort[i] = (int) (Math.random() * 100);
        }
        int[] arrForBubbleSort = Arrays.copyOf(arrForSort, arrForSort.length);
        //System.out.println("CopyArr " + Arrays.toString(arrForBubbleSort));
        long startSort = System.nanoTime();
        Arrays.sort(arrForSort);
        long finishSort = System.nanoTime();
        System.out.println("Sorted array: " + Arrays.toString(arrForSort) + "\n" + "Sort time: " + (finishSort - startSort) + "ns");

        long startBubbleSort = System.nanoTime();
        bubbleSort(arrForBubbleSort);
        long finishBubbleSort = System.nanoTime();
        System.out.println("Bubble sorted array: " + Arrays.toString(arrForBubbleSort) + "\n" + "Bubble sort time: " + (finishBubbleSort - startBubbleSort) + "ns");

        int[] arrForChoiceSort = new int[400];
        for (int i = 0; i < arrForChoiceSort.length; i++) {
            arrForChoiceSort[i] = (int) (Math.random() * 100);
        }
        int[] arrForInsertSort = Arrays.copyOf(arrForChoiceSort, arrForChoiceSort.length);
//        System.out.println("For choice sort array" + Arrays.toString(arrForChoiceSort));
//        System.out.println("For insert sort array " + Arrays.toString(arrForInsertSort));

        long startInsertSort = System.nanoTime();
        insertSort(arrForInsertSort);
        long finishInsertSort = System.nanoTime();
        System.out.println("Insert sorted array: " + Arrays.toString(arrForInsertSort) + "\n" + "Sorting time: " + (finishInsertSort - startInsertSort) + "ns");

        long startChoiceSort = System.nanoTime();
        for (int i = 0; i < arrForChoiceSort.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrForChoiceSort.length; j++) {
                if (arrForChoiceSort[j] < arrForChoiceSort[min]) {
                    min = j;
                }
            }
            choiceSort(arrForChoiceSort, i, min);
        }
        long finishChoiceSort = System.nanoTime();
        System.out.println("Choice sorted: " + Arrays.toString(arrForChoiceSort) + "\n" + "Choice sort time: " + (finishChoiceSort - startChoiceSort) + "ns");
    }

    public static int linearSearch(int[] arr, int key) {
        int result = -1;
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == key) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public static int binarySearch(int[] arr, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (arr[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            } else if (arr[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int buff;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sorted = false;
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
        }
    }

    public static void choiceSort(int[] arr, int first, int last) {
        int buff = arr[first];
        arr[first] = arr[last];
        arr[last] = buff;
    }

    public static void insertSort(int[] arr) {
        int insertValue;
        int buff;
        for (int i = 1; i < arr.length; i++) {
            buff = arr[i];
            insertValue = i;
            while (insertValue > 0 && arr[insertValue - 1] >= buff) {
                arr[insertValue] = arr[insertValue - 1];
                --insertValue;
            }
            arr[insertValue] = buff;
        }
    }
}
