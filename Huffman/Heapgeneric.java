package com.company.Online;

import java.util.ArrayList;

public class Heapgeneric<T extends Comparable<T>> {
    ArrayList<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
        unheapify(data.size() - 1);
    }

    private void unheapify(int ci) {
        int pi = (ci - 1) / 2;
        if (islarger(data.get(ci),data.get(pi))<0) {
            swap(pi, ci);
            unheapify(pi);
        }

    }

    private void swap(int i, int j) {
        T ith = data.get(i);
        T jth = data.get(j);

        data.set(i, jth);
        data.set(j, ith);
    }

    public void display() {
        System.out.println(data);
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public T remove() {
        swap(0, data.size() - 1);
        T rv = this.data.remove(data.size() - 1);
        downheapify(0);

        return rv;

    }

    private void downheapify(int pi) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int mini = pi;
        if (lci < data.size() && islarger(data.get(lci), data.get(mini))<0) {
            mini = lci;
        }
        if (rci < data.size() && islarger(data.get(rci), data.get(mini))<0) {
            mini = rci;
        }
        if (mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }
    public T get(){
        return this.data.get(0);
    }
    //if t is having priority then return +ve value else return -ve
    public int islarger(T t,T o){
        return t.compareTo(o);
    }
}
