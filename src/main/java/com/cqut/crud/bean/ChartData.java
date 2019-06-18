package com.cqut.crud.bean;

/**
 * @author ChenTengfei
 * @date 2019/6/2 13:05
 **/
public class ChartData<T> {
    private T value;
    private String name;

    public ChartData(T value, String name) {
        this.value = value;
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}