package com.iyuba.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public class Data {

    private List<String> datas = new  ArrayList<String>();
    private static  Data instance;
    private Data(){
        datas.add("英语四级听力1");
        datas.add("英语四级听力2");
        datas.add("英语四级听力3");
        datas.add("英语四级听力4");
        datas.add("英语四级听力5");
        datas.add("英语四级听力6");
    };
    public synchronized static Data  getInstance(){
        if(instance==null){
            instance = new Data();
        }
        return  instance;
    }

    public List<String> getDatas(){
        return datas;
    }
}

