package com.sagr.marketing.system.associationrules;

/**
 * Created by Sasha on 31.05.14.
 */
public class FrequencyWrapper<T> implements Comparable {
    private T o;
    private Integer frequency;

    public FrequencyWrapper(T o, Integer frequency) {
        this.o = o;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Object o) {
        FrequencyWrapper w = (FrequencyWrapper)o;
        return Double.compare(frequency, w.frequency);
    }
}
