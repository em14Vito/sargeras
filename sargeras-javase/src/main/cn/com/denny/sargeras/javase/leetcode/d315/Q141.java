package cn.com.denny.sargeras.javase.leetcode.d315;

import javafx.scene.layout.Priority;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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
 * @author denny
 * @version 1.0.0 2019/3/15
 */
public class Q141 {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
    public boolean isValid(String s) {
        Stack symbol = new Stack();
        for(char value: s.toCharArray()){
            if(needPush(value)){
                symbol.push(value);
            }else if(!symbol.empty() && symbolMap((Character) symbol.peek(),value)){
                symbol.pop();
            } else{
                return false;
            }
        }
        return symbol.empty();

    }
    private boolean needPush(char leftSymbol){
        return leftSymbol == '(' ||
                leftSymbol == '{' ||
                leftSymbol == '[' ;
    }
    public boolean symbolMap(char left, char right){
        switch(left){
            case '(':
                return right == ')';
            case '[':
                return right == ']';
            case '{':
                return right == '}';
        }
        ArrayList<int[]> a = new ArrayList<>();

        return false;
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        PriorityQueue q=new PriorityQueue();

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}
