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

/**
 * @author Huabing Zhao
 *
 */
public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int move = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            //P can't get higher than 2 of it's original position because anyone can bride only twice
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            /*
            From here on out, we don't care if P has moved forwards, it is better to count how many times
            P has RECEIVED a bribe, by looking at who is ahead of P.  P's original position is the value
            of P.
            Anyone who bribed P cannot get to higher than one position in front if P's original position,
            so we need to look from one position in front of P's original position to one in front of P's
            current position, and see how many of those positions in Q contain a number large than P.
            In other words we will look from P-1 to i-1, which in Python is range(P-1,i-1+1), or simply
            range(P-1,i).  To make sure we don't try an index less than zero, replace P-1 with max(P-1,0)
                           检查有多少人对P行贿，如果P前面的人的序号比P大，则该人就对P行贿了。由于一个人只能行贿两次，对P行贿的人不可能
                           超过P原来位置的前一个位置，因此从q[j]-1开始计算。
            */
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i])
                    move++;
        }
        System.out.println(move);
    }


    public static void main(String[] args) {
        NewYearChaos.minimumBribes(new int[] {1, 2, 5, 3, 7, 8, 6, 4});
    }

}
