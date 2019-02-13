package cn.com.denny.sargeras.javase.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

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
 *
 * <p>
 * Question: <a> https://leetcode.com/problems/squares-of-a-sorted-array/ </a>
 * </p>
 *
 * @author denny
 * @version 1.0.0 2019/2/12
 **/
public class Q977 {

    /**
     * 最简单的方法
     *
     * @param A
     * @return
     */
    public int[] sortedSquares_self_1(int[] A) {
        int[] absValue = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            absValue[i] = A[i] * A[i];
        }
        Arrays.sort(absValue);
        return absValue;
    }

    /**
     * online solution.
     *
     * @param A
     * @return
     */
    public int[] sortedSquares_self_2(int[] A) {
        int totalSize = A.length;
        int minPositivePos = 0;
        while (minPositivePos < totalSize && A[minPositivePos] < 0)
            minPositivePos++;
        int criticalPos = minPositivePos - 1;

        int[] ans = new int[totalSize];
        int t = 0;

        while (criticalPos >= 0 && minPositivePos < totalSize) {
            if (A[criticalPos] * A[criticalPos] < A[minPositivePos] * A[minPositivePos]) {
                ans[t++] = A[criticalPos] * A[criticalPos];
                criticalPos--;
            } else {
                ans[t++] = A[minPositivePos] * A[minPositivePos];
                minPositivePos++;
            }
        }

        while (criticalPos >= 0) {
            ans[t++] = A[criticalPos] * A[criticalPos];
            criticalPos--;
        }
        while (minPositivePos < totalSize) {
            ans[t++] = A[minPositivePos] * A[minPositivePos];
            minPositivePos++;
        }

        return ans;
    }


    /**
     *
     * @param A
     * @return
     */
    public int[] sortedSquares_self_3(int[] A) {
        int size = A.length;
        int left = 0;
        int right = size - 1;
        int[] ans = new int[size];

        for (int maxIndex = size - 1; maxIndex >= 0 ; maxIndex--) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                ans[maxIndex] = A[left] * A[left];
                left++;
            }else {
                ans[maxIndex] = A[right] * A[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] demo = new int[]{-7,-3,2,3,11};
        int[] result = new Q977().sortedSquares_self_3(demo);


        for (int value : result) {
            System.out.print(value + " ");
        }
    }

}
