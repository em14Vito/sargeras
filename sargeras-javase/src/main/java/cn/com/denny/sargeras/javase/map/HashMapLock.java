package cn.com.denny.sargeras.javase.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashMapLock {

    private static HashMap map = new HashMap();

    public HashMapLock() {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 500300; i++) {
                    map.put(new Integer(i), i);
                }
                System.out.println("t1 over");
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 502000; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t2 over");
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                for (int i = 0; i < 500100; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t3 over");
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                for (int i = 0; i < 501000; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t4 over");
            }
        };

        Thread t5 = new Thread() {
            public void run() {
                for (int i = 0; i < 500300; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t5 over");
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public void runTest() throws Exception {
        final Map<Integer, String> map = new HashMap<Integer, String>();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        map.put(i, "wow");
                    }
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        try {
            new HashMapLock().runTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
