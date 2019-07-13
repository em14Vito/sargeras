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
public class Q206 {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while( curr != null){
          ListNode nextTemp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = nextTemp;
      }
      return prev;
  }
  public ListNode reverseList_recursive(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode p = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return p;
  }

  public static void main(String[] args) {
      ListNode listNode = new ListNode(1);
      listNode.next = new ListNode(2);
      listNode.next.next = new ListNode(3);
      listNode.next.next.next = new ListNode(4);
      listNode.next.next.next.next = null;

      ListNode re  = new Q206().reverseList(listNode);
    System.out.println(re);
  }
}
