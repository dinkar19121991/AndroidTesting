package com.dinkark.androidtesting.unit.basic;

/**
 * Created by dinkark on 16/09/16.
 */
public class Counter {
    //class level variable
    static int classCount=0;
    //instance level variable
    int instanceCount=0;
    public void increaseInstanceCounter(){
        instanceCount++;
    }
    public void increaseClassCounter(){
        classCount++;
    }
}
