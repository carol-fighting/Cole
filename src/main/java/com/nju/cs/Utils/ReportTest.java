package com.nju.cs.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carol on 2017/2/14.
 */
public class ReportTest {

    public static void main(String []args){
        List<Integer> latentIds=new ArrayList<Integer>();
        latentIds.add(1);latentIds.add(2);latentIds.add(3);
        ActPool.doAct(latentIds);
    }
}
