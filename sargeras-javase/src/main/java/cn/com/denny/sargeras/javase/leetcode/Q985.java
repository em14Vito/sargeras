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
 * @author denny
 * @version 1.0.0 2019/2/14
 **/
public class Q985 {
    /**
     * @param A
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries_self(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int startIndex = 0;
        for (int[] query : queries) {
            int index = query[1];
            int value = query[0];
            int result = 0;
            A[index] = A[index] + value;
            for (int v: A){
                result = result + (Math.abs(v) % 2 == 0 ? v:0);
            }
            ans[startIndex++] = result;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int [] A = {1,2,3,4};
        int[] result = new Q985().sumEvenAfterQueries_self(A,queries);
        for (int value: result ){
            System.out.println(value);
        }


    }
}
