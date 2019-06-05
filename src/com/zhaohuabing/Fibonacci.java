/**
 * Copyright 2017 ZTE Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.zhaohuabing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Huabing Zhao
 *
 */
public class Fibonacci {
    //Key n, value Fibonacci of n
    static Map<Integer, Long> cache = new HashMap<Integer, Long>();

    public static long fibonacciRecursion(int n) {
        cache.put(1, 1L);
        cache.put(2, 1L);
        return fib(n);
    }

    private static long fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long result = fib(n - 1) + fib(n - 2);
        cache.put(n, result);
        return result;
    }

    public static long fibonacciIteration(int n) {
        long previousPreivousNumber = 0;
        long previousNumber = 1;

        for (int i = 1; i < n; i++) {
            long curNumber = previousPreivousNumber + previousNumber;
            previousPreivousNumber = previousNumber;
            previousNumber = curNumber;
        }
        return previousNumber;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci 100: " + Fibonacci.fibonacciRecursion(100));
        System.out.println("Fibonacci 100: " + Fibonacci.fibonacciIteration(100));
    }
}
