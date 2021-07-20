
package lesson5;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 15;
        long result;
        long startRecursiveCount = System.nanoTime();
        result = recursiveCountFactorial(n);
        long finishRecursiveCount = System.nanoTime();
        System.out.println("Result is: " + result + "\n Function time: " + (finishRecursiveCount - startRecursiveCount) + "ms");

        n = 15;
        long startCycleCount = System.nanoTime();
        result = cycleCountFactorial(n);
        long finishCycleCount = System.nanoTime();
        System.out.println("Result is: " + result + "\n Function time: " + (finishCycleCount - startCycleCount) + "ms");

        int[] arr = new int[10];
        arr[0] = 22;
        Random rand = new Random();
        for (int i = 1; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        long startRecursiveBinary = System.nanoTime();
        System.out.println(recursiveBinarySearch(22, 0, arr.length - 1, arr));
        long finishRecursiveBinary = System.nanoTime();
        System.out.println("Recursive binary search time: " + (finishRecursiveBinary - startRecursiveBinary) + "ms");


        int[] arrForMerge = new int[10];
        for (int i = 1; i < arrForMerge.length; i++) {
            arrForMerge[i] = rand.nextInt();
        }
        System.out.println(Arrays.toString(arrForMerge));
        long startRecursiveMerge = System.nanoTime();
        System.out.println(Arrays.toString(mergingSort(arrForMerge)));
        long finishRecursiveMerge = System.nanoTime();
        System.out.println("Recursive merge sort time: " + (finishRecursiveMerge - startRecursiveMerge) + "ms");
    }

    //бесконечная рекурсия будет без if(n > 1)
    public static long recursiveCountFactorial(int n) {
        if (n > 1) {
            return n * recursiveCountFactorial(n - 1);
        } else return 1;
    }

    public static long cycleCountFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static int recursiveBinarySearch(int searchKey, int front, int rear, int[] arr) {

        if (front > rear) {
            return arr.length;
        }
        int middle = (front + rear) / 2;
        if (arr[middle] == searchKey) {
            return middle;
        } else if (arr[middle] < searchKey) {
            return recursiveBinarySearch(searchKey, front + 1, rear, arr);
        } else return recursiveBinarySearch(searchKey, front, rear - 1, arr);
    }

    public static int[] mergingSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        return merge(mergingSort(Arrays.copyOfRange(arr, 0, middle)), mergingSort(Arrays.copyOfRange(arr, middle, len)));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
