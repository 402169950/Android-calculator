package com.tongliu.calculator.data.observer;

import com.tongliu.calculator.data.observer.inf.DataChangedInf;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataObs {
    private static DataObs mInstance;
    private List<DataChangedInf> observerList;
    private DataObs(){
        observerList = new ArrayList<DataChangedInf>();
    }

    /**
     * Retrieve an singleton instance of {@link DataObs}
     * @return
     */
    public static DataObs getInstance(){
        return mInstance = mInstance == null? new DataObs():mInstance;
    }

    /**
     * Add an observer to the observer list.
     * @param observer the observer.
     */
    public void addObserver(DataChangedInf observer){
        observerList.add(observer);
    }
    public void notify(String newStr){
    for(DataChangedInf cur: observerList){
        cur.onDataChanged(newStr);
    }
    }
}
