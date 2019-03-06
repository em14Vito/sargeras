package cn.com.denny.sargeras.javase.leetcode;

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
 * Question: <a> https://leetcode.com/problems/flipping-an-image/ </a>
 * </p>
 *
 * @author denny
 * @version 1.0.0 2019/2/13
 **/
public class Q832 {
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int right = A[i].length;
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = ((A[i][j] ^ A[i][right - 1]) == 0 ? A[i][j] : 1);
                System.out.print(A[i][j]);
                A[i][j] = A[i][j] == 1 ? 0 : 1;
                right--;
            }
            System.out.println();
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] demo = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] result = new Q832().flipAndInvertImage(demo);


        for (int[] value : result) {
            for (int v : value) {
                System.out.print(v + " ");
            }
            System.out.println("|||");
        }
    }

}
