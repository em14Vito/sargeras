package cn.com.denny.sargeras.javase;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
 * @version 1.0.0 2019/3/1
 */
public class DeadLockSample extends Thread {
  private String first;
  private String second;

  public DeadLockSample(String name, String first, String second) {
    super(name);
    this.first = first;
    this.second = second;
  }

  public void run() {
    synchronized (first) {
      System.out.println(this.getName() + " obtained: " + first);
      try {
        Thread.sleep(1000L);
        synchronized (second) {
          System.out.println(this.getName() + " obtained: " + second);
        }
      } catch (InterruptedException e) {
        // Do nothing
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
    Runnable dlCheck =
        new Runnable() {

          @Override
          public void run() {
            long[] threadIds = mbean.findDeadlockedThreads();
            if (threadIds != null) {
              ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
              System.out.println("Detected deadlock threads:");
              for (ThreadInfo threadInfo : threadInfos) {
                System.out.println(threadInfo.getThreadName());
              }
            }
          }
        };

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    // 稍等 5 秒，然后每 10 秒进行一次死锁扫描
    scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);
    // 死锁样例代码…

    String lockA = "lockA";
    String lockB = "lockB";
    DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
    DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}
