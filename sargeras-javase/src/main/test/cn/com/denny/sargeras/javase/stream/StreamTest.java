package cn.com.denny.sargeras.javase.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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
 * @version 1.0.0 2019/8/7
 */
public class StreamTest {

  @Test
  public void filter_and_foreach() {

    final AtomicInteger foreachCount = new AtomicInteger(0);

    List<Node> values =
        Arrays.asList(
            new Node(1),
            new Node(5),
            new Node(15),
            new Node(2),
            new Node(3));
    for (Node value : values) {
        if(value.getV() >= 10 )
            continue;
      values.stream()
          .filter(item -> value.getV() < 10)
          .forEach(
              item -> {
                System.out.println(item);
                foreachCount.incrementAndGet();
                  value.setV(100);
              });
    }

    System.out.println(foreachCount);
  }

  public static class Node implements Comparable {
    int v;

    public Node(int v) {
      this.v = v;
    }

    public void setV(int v) {
      this.v = v;
    }

    public int getV() {
      return v;
    }

    @Override
    public String toString() {
      return "Node{" + "v=" + v + '}';
    }

    @Override
    public int compareTo(Object o) {
      return this.v - ((Node) o).getV();
    }
  }
}
