
package com.zhaohuabing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *  https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * You are given  queries. Each query is of the form two integers described below: 
 * -1 x  : Insert x in your data structure. 
 * -2 y  : Delete one occurence of y from your data structure, if present. 
 * -3 z  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
 * 
 * The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element. For example, you are given array . The results of each operation are:
 * 
 * Operation   Array   Output
 * (1,1)       [1]
 * (2,2)       [1]
 * (3,2)                   0
 * (1,1)       [1,1]
 * (1,1)       [1,1,1]
 * (2,1)       [1,1]
 * (3,2)                   1
 * Return an array with the output: .
 * 
 * Function Description
 * 
 * Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.
 * 
 * freqQuery has the following parameter(s):
 * 
 * queries: a 2-d array of integers
 * Input Format
 * 
 * The first line contains of an integer , the number of queries. 
 * Each of the next  lines contains two integers denoting the 2-d array .
 * 
 * Constraints
 * 
 * All 
 * Output Format
 * 
 * Return an integer array consisting of all the outputs of queries of type .
 * 
 * Sample Input 0
 * 
 * 8
 * 1 5
 * 1 6
 * 3 2
 * 1 10
 * 1 10
 * 1 6
 * 2 5
 * 3 2
 * Sample Output 0
 * 
 * 0
 * 1
 * Explanation 0
 * 
 * For the first query of type , there is no integer whose frequency is  (). So answer is . 
 * For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .
 * 
 * Sample Input 1
 * 
 * 4
 * 3 4
 * 2 1003
 * 1 16
 * 3 1
 * Sample Output 1
 * 
 * 0
 * 1
 * Explanation 1
 * 
 * For the first query of type , there is no integer of frequency . The answer is . 
 * For the second query of type , there is one integer,  of frequency  so the answer is .
 * 
 * Sample Input 2
 * 
 * 10
 * 1 3
 * 2 3
 * 3 2
 * 1 4
 * 1 5
 * 1 5
 * 1 4
 * 3 2
 * 2 4
 * 3 2
 * Sample Output 2
 * 
 * 0
 * 1
 * 1
 * Explanation 2
 * 
 * When the first output query is run, the array is empty. We insert two 's and two 's before the second output query,  
 * so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the instances of  satisfy the query.
 */
public class FrequencyQueries {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        //key number, value count
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        //key count, value occurs
        Map<Integer, Integer> occursMap = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < queries.size(); i++) {
            int op = queries.get(i).get(0);
            int value = queries.get(i).get(1);

            switch (op) {
                case 1:
                    int count = 0;
                    if (numberMap.containsKey(value)) {
                        count = numberMap.get(value) + 1;
                    } else {
                        count = 1;
                    }
                    numberMap.put(value, count);

                    int occurs = 0;
                    if (occursMap.containsKey(count)) {
                        occurs = occursMap.get(count) + 1;
                    } else {
                        occurs = 1;
                    }
                    occursMap.put(count, occurs);

                    if (--count > 0) {
                        if (occursMap.containsKey(count)) {
                            occurs = occursMap.get(count) - 1;
                        }
                        occursMap.put(count, occurs);
                    }

                    break;
                case 2:
                    count = 0;
                    if (numberMap.containsKey(value)) {
                        count = numberMap.get(value);
                        if (--count > 0) {
                            numberMap.put(value, count);
                        } else {
                            numberMap.remove(value);
                        }

                        if (count > 0) {
                            if (occursMap.containsKey(count)) {
                                occurs = occursMap.get(count);
                                occursMap.put(count, occurs + 1);
                            }
                        }
                        if (occursMap.containsKey(count + 1)) {
                            occurs = occursMap.get(count + 1);
                            occursMap.put(count, occurs - 1);
                        }
                    }

                    break;
                case 3:
                    if (occursMap.containsKey(value)) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;

                default:
                    break;
            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> queries = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(6);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(3);
        temp.add(2);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(10);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(10);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(6);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(5);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(3);
        temp.add(2);
        queries.add(temp);

        List<Integer> result = freqQuery(queries);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(3);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(3);
        temp.add(2);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(4);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(4);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(5);
        queries.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(4);
        queries.add(temp);
        temp.add(3);
        temp.add(2);
        queries.add(temp);
        temp.add(2);
        temp.add(4);
        queries.add(temp);
        temp.add(3);
        temp.add(2);
        queries.add(temp);

        result = freqQuery(queries);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
