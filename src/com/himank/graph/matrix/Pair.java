package com.himank.graph.matrix;

import java.io.Serializable;

public class Pair<K, V> implements Serializable, Comparable<Pair> {

    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Pair)) {
            return false;
        } else {
            Pair pair = (Pair)o;
            if (this.key != null) {
                if (!this.key.equals(pair.key)) {
                    return false;
                }
            } else if (pair.key != null) {
                return false;
            }

            if (this.value != null) {
                if (!this.value.equals(pair.value)) {
                    return false;
                }
            } else if (pair.value != null) {
                return false;
            }

            return true;
        }
    }

    @Override
    public int compareTo(Pair pair) {
        return (int) this.value - (int) pair.value;
    }
}
