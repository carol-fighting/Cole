package com.nju.cs.Utils;



import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Queue;

/**
 * Created by carol on 2017/2/14.
 */
public class DeterOmitted extends Thread {

    private Queue<Integer> omittedQueue;
    private List<Integer> latentIds;

    public DeterOmitted(Queue<Integer> omittedQueue,List<Integer> latentIds) {
        this.omittedQueue = omittedQueue;
        this.latentIds = latentIds;
    }

    //判断id是否漏报的具体逻辑
    public boolean isOmitted(Integer id){
        if(id%2==0){
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if (!CollectionUtils.isEmpty(latentIds)) {
            for (Integer id : latentIds) {
                try {
                    if (isOmitted(id)) {
                        omittedQueue.offer(id);
                    }
                }
                catch (Exception e) {

                }
            }
        }
    }

}
