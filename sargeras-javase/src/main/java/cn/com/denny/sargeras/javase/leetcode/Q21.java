package cn.com.denny.sargeras.javase.leetcode;

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
 * @version 1.0.0 2019/3/13
 */
public class Q21 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = null, current = null;

    while (l1 != null || l2 != null) {
      int min;
      if (l1 == null) {
        min = l2.val;
        l2 = l2.next;
      } else if (l2 == null) {
        min = l1.val;
        l1 = l1.next;
      } else if (l1.val > l2.val) {
        min = l2.val;
        l2 = l2.next;
      } else {
        min = l1.val;
        l1 = l1.next;
      }
      if (result == null) {
        result = new ListNode(min);
        current = result;
      } else {
        current.next = new ListNode(min);
        current = current.next;
      }
    }
    return result;
  }

  public String longestPalindrome(String s) {
    int left = 0, right = 0;
    String value = "";
    for (int i = right = 1; left < s.length() -1 ; ) {
      if (s.charAt(left) == s.charAt(right)) {
        value =
            value.length() > s.substring(left, right+1).length() ? value : s.substring(left, right+1);
        left++;
      } else {
          if( right >= s.length() -1){
              left++;
          } else{
              right++;
          }
      }
    }
    return value;
  }

  public static void main(String[] args) {
    new Q21().longestPalindrome("aaabaaaa");
  }

  public ListNode mergeTwoLists_recursion(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val > l2.val) {
      l2.next = mergeTwoLists_recursion(l1, l2.next);
      return l2;
    } else {
      l1.next = mergeTwoLists_recursion(l1.next, l2);
      return l1;
    }
  }
}
