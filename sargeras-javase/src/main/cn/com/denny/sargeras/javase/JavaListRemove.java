package cn.com.denny.sargeras.javase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
 * @version 1.0.0 2019/3/5
 **/
public class JavaListRemove {
  public static void main(String[] args) {
      List<Integer> list = new ArrayList<>();
      list.add(0);
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      list.add(7);

      Iterator<Integer> iterator = list.iterator();
      while (iterator .hasNext()){
          Integer item = iterator.next();
          if (item%2 ==0)
              iterator.remove();
      }

    list.forEach(System.out::println);

    System.out.println(list.size());
  }
}
