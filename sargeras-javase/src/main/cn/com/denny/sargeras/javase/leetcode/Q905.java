package cn.com.denny.sargeras.javase.leetcode;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Question:
 * Sort Array By Parity. <a> https://leetcode.com/problems/sort-array-by-parity/</a>
 *
 * @author denny
 * @version 1.0.0 2019/1/13
 **/
public class Q905 {

    /**
     * self method
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int[] odd = new int[A.length];
        int total = 0;
        int oddSize = 0;

        for (int item : A) {
            if (item % 2 == 0) {
                //even
                result[total++] = item;
            } else {
                odd[oddSize++] = item;
            }
        }

        for (int i = 0; i < oddSize; i++) {
            result[total++] = odd[i];
        }
        return result;
    }

    public int[] sortArrayByParity_self_1(int[] A) {
        int[] result = new int[A.length];
        int i = 0,j = A.length -1;

        for (int item : A) {
            if (item % 2 == 0) {
                //even
                result[i++] = item;
            } else {
                result[j--] = item;
            }
        }
        return result;
    }

    /**
     * sort way by online
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity_Sort(int[] A) {

        return Arrays.stream(A)
                .boxed()
                .sorted((a, b) -> Integer.compare(a % 2, b % 2))
                .mapToInt(i -> i)
                .toArray();
    }


    public static void main(String[] args) {
        int[] aa = new Q905().sortArrayByParity_self_1(new int[]{3,1,2,4});
        System.out.println(aa);
    }

}
