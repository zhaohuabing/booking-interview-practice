package com.zhaohuabing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given arrays for N (>=  2) users, each representing the IDs of hotels visited, 
 *find the common IDs of the hotels visited amongst the users.
 *Input:
 *userA = { 2, 3, 1 }
 *userB = { 2, 5, 3 }
 *userC = { 7, 3, 1 }
 *Output:
 *3
 *
 *Each array may contain duplicated hotel IDs
 */
public class CommonHotel {
    public static void lookUpUsers(int[][] users) {
        Set<Integer> previousUser = new HashSet<Integer>();
        for (int i = 0; i < users[0].length; i++) {
            previousUser.add(users[0][i]);
        }

        for (int i = 0; i < users.length; i++) {
            Set<Integer> curUser = new HashSet<Integer>();
            for (int j = 0; j < users[i].length; j++) {
                if (previousUser.contains(users[i][j])) {
                    curUser.add(users[i][j]);
                }
            }
            previousUser = curUser;
        }

        Iterator<Integer> hotels = previousUser.iterator();
        while (hotels.hasNext()) {
            System.out.println(hotels.next());
        }
    }

    public static void main(String[] args) {
        CommonHotel.lookUpUsers(new int[][] {{2, 3, 1}, {2, 5, 3}, {7, 3, 1, 1}});
    }
}
