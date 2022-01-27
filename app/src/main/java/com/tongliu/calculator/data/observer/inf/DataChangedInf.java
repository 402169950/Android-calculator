package com.tongliu.calculator.data.observer.inf;

public interface DataChangedInf {
    /**
     * The callback function of the observers.
     * @param newStr The returned new data. This usually needs to be displayed on View.
     */
    void onDataChanged(String newStr);
}
