package cn.com.denny.sargeras.javase;

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
 * @version 1.0.0 2019/3/2
 */
import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class UsualSemaphoreSample {
    public static HashMap map = new HashMap(10);
  //  public static ConcurrentHashMap map = new ConcurrentHashMap(10);
  public static AtomicInteger atomicInteger = new AtomicInteger(0);
  public static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

  public static void main(String[] args) throws InterruptedException {

      int a = 2147483647;
    System.out.println(++a);

    System.out.println("Action...GO!");
    Semaphore semaphore = new Semaphore(3);
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(new SemaphoreWorker(semaphore));
      t.start();
    }
  }
}

class SemaphoreWorker implements Runnable {
  private String name;
  private Semaphore semaphore;

  public SemaphoreWorker(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    try {
      UsualSemaphoreSample.cyclicBarrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
    try {
      log("is waiting for a permit!");
      semaphore.acquire();
      UsualSemaphoreSample.atomicInteger.incrementAndGet();
      //      UsualSemaphoreSample.map.put(Thread.currentThread().getName(), "1");
      log("acquired a permit!");
      log("executed!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      log("released a permit!");
      //      UsualSemaphoreSample.map.remove(Thread.currentThread().getName());
      semaphore.release();
      UsualSemaphoreSample.atomicInteger.decrementAndGet();
    }
  }

  private void log(String msg) {
    if (name == null) {
      name = Thread.currentThread().getName();
    }
    System.out.println(name + " " + msg + "  size is " + UsualSemaphoreSample.atomicInteger.get());
  }
}
