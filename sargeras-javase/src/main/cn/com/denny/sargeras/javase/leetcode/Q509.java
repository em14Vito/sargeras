package cn.com.denny.sargeras.javase.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * <p>Question: <a> https://leetcode.com/problems/fibonacci-number/ </a>
 *
 * @author denny
 * @version 1.0.0 2019/3/6
 */
public class Q509 {

  public int fib_myself(int N) {
    if (N == 0) return 0;
    if (N == 1) return 1;
    return fib_myself(N - 1) + fib_myself(N - 2);
  }

  /**
   *
   * @param N
   * @return
   */
  public int fib_online(int N) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(0);
    list.add(1);
    if (N < 2) return list.get(N);
    for (int i = 2; i <= N; i++) {

      list.add(list.get(i - 1) + list.get(i - 2));
    }
    return list.get(N);
  }

  public static void main(String[] args) {
    System.out.println(new Q509().fib_myself(4));
  }
}
