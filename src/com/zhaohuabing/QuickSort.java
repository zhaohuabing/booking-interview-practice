package com.zhaohuabing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huabing Zhao
 *
 */
public class QuickSort {

    public static List<Integer> quickSortWithNewArray(List<Integer> array) {
        if (array.size() <= 1) {
            return array;
        }
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        int pivot = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            int n = array.get(i);
            if (n > pivot) {
                right.add(n);
            } else {
                left.add(n);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.addAll(quickSortWithNewArray(left));
        result.add(pivot);
        result.addAll(quickSortWithNewArray(right));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        array.add(5);
        array.add(1);
        array.add(9);
        array.add(3);
        array.add(2);
        array.add(10);
        array.add(4);
        array.add(6);
        array.add(8);
        array.add(7);
        List result = QuickSort.quickSortWithNewArray(array);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
    }
}
