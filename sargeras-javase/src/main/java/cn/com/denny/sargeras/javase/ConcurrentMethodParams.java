package cn.com.denny.sargeras.javase;

import java.awt.*;

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
 * 测试：如果在方法内，将入参加synchronized锁, 会怎样
 *
 * @author denny
 * @version 1.0.0 2019/3/5
 */
public class ConcurrentMethodParams implements Runnable {
  POJO pojo;

  ConcurrentMethodParams(POJO pojo) {
    this.pojo = pojo;
  }

  @Override
  public void run() {
    test(this.pojo);
  }

  private void test(POJO pojo) {
    try {
      Thread.sleep(10);
      synchronized (pojo) {
        if(Thread.currentThread().getName().equalsIgnoreCase("thread1")){
          System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000*1);
        }
        System.out.println(Thread.currentThread().getName()+"Halo");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
      POJO pojo = new POJO();
      new Thread(new ConcurrentMethodParams(pojo),"thread1").start();
      new Thread(new ConcurrentMethodParams(pojo),"thread2").start();
      new Thread(new ConcurrentMethodParams(pojo),"thread3").start();

  }

}
