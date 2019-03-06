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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducer {
  public static final String EXIT_MSG = "Good bye!";

  public static void main(String[] args) {
    // 使用较小的队列，以更好地在输出中展示其影响
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    Producer producer = new Producer(queue);
    Consumer consumer = new Consumer(queue);
    new Thread(producer).start();
    new Thread(consumer).start();
  }

  static class Producer implements Runnable {
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> q) {
      this.queue = q;
    }

    @Override
    public void run() {
      for (int i = 0; i < 20; i++) {
        try {
          Thread.sleep(5L);
          String msg = "Message" + i;
          System.out.println("Produced new item: " + msg);
          queue.put(msg);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      try {
        System.out.println("Time to say good bye!");
        queue.put(EXIT_MSG);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> q) {
      this.queue = q;
    }

    @Override
    public void run() {
      try {
        String msg;
        while (!EXIT_MSG.equalsIgnoreCase((msg = queue.take()))) {
          System.out.println("Consumed item: " + msg);
          Thread.sleep(10L);
        }
        System.out.println("Got exit message, bye!");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
