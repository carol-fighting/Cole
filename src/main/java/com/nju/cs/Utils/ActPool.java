package com.nju.cs.Utils;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by carol on 2017/2/14.
 */
public class ActPool {


    public static final ExecutorService outPool = Executors.newCachedThreadPool();

    public static final ExecutorService localPool = Executors.newFixedThreadPool(2);

    public  static BlockingQueue<Integer> omittedQueue = new ArrayBlockingQueue<Integer>(100);

    //外部调用
    public static void doAct(List<Integer> userIds) {
        outPool.submit(new DeterOmitted(omittedQueue,userIds));
    }

    //常驻线程进行上报
    static {
        localPool.submit(new FixWork());
    }

    public static class FixWork extends Thread {
        @Override
        public void run() {
            while (true) {
                if (omittedQueue.isEmpty()) {
                    try {
                        Thread.sleep(1000l);
                    }
                    catch (InterruptedException e) {

                    }
                }
                else {
                    Integer curr = omittedQueue.poll();
                    //上报的具体逻辑
                    System.out.println("鹅要补报:"+curr);
                }
            }
        }
    }



}
