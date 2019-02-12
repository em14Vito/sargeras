package cn.com.denny.sargeras.javase.leetcode;

import java.util.*;

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
 * Question: <a> https://leetcode.com/problems/single-number/ </a>
 * </p>
 *
 * @author denny
 * @version 1.0.0 2019/2/10
 **/
@SuppressWarnings("ALL")
public class Q136 {

    /**
     * self solution
     *
     * @param nums
     * @return
     */
    public int singleNumber_self_1(int[] nums) {
        HashMap mappingValue = new HashMap(nums.length);
        for (int value : nums) {
            if (mappingValue.get(value) == null) {
                mappingValue.put(value, 1);
            } else {
                mappingValue.remove(value);
            }
        }
        return (int) mappingValue.keySet().iterator().next();
    }

    /**
     * online methods.
     * theory: 2∗(a+b+c)−(a+a+b+b+c)=c
     *
     * @param nums
     * @return
     */
    public int singleNumber_math(int[] nums) {
        Set no_duplicate = new HashSet(nums.length);
        Arrays.stream(nums).forEach(value -> no_duplicate.add(value));
        int total = 2 * (Integer) no_duplicate.stream().reduce((a, b) -> (Integer) a + (Integer) b).get();
        int min = Arrays.stream(nums).reduce((a, b) -> a + b).getAsInt();
        return total - min;
    }

    /**
     * best solution.
     * 与或 运算方式.
     * @param nums
     * @return
     */
    public int singleNumber_xorWay(int[] nums){
        int result = 0;
        for(int value : nums){
            result ^= value;
        }
        return result;
    }

    public static void main(String[] args) {

        //test method
        int[] demo =new int[]{4,1,3,5,1,5,2,2,3};
//        int[] demo = new int[]{1, 0, 1};
        new Q136().singleNumber_xorWay(demo);
    }

}
