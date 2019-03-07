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
 *<p>Question: <a> https://leetcode.com/problems/sort-array-by-parity-ii/ </a>
 *
 * @author denny
 * @version 1.0.0 2019/3/7
 **/
public class Q922 {
    public int[] sortArrayByParityII_Myself(int[] A) {
        int[] result = new int[A.length];
        int evenIndex = -2,oddIndex = -1;

        for (int item : A) {
            if (item % 2 == 0) {
                //even
                result[evenIndex=evenIndex+2] = item;
            } else {
                result[oddIndex=oddIndex+2] = item;
            }
        }
        return result;
    }
}
