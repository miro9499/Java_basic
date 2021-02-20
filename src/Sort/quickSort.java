package Sort;

import java.util.*;

public class quickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) return array;

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int pivotIndex = findPivotAndPartition(array, left, right);

        quickSort(array, left, pivotIndex-1);
        quickSort(array, pivotIndex+1, right);
    }

    private int findPivotAndPartition(int[] array, int left, int right) {
        Random rd = new Random();
        int pivotIndex = left + rd.nextInt( right - (left - 1));
        int pivotValue = array[pivotIndex];

        swap(array, right, pivotIndex);

        int leftI = left;
        int rightI = right - 1;

        while (leftI <= rightI) {
            if (array[leftI] < pivotValue) {
                leftI++;
            } else if (array[rightI] > pivotValue) {
                rightI--;
            } else {
                swap(array, leftI++, rightI--);
            }
        }
        swap(array, leftI, right);
        return leftI;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        quickSort solution = new quickSort();

        int[] array = null;
        array = new int[] {2, 4, 1, 5, 3};
        array = solution.quickSort(array);
        System.out.println(Arrays.toString(array));

    }
}

