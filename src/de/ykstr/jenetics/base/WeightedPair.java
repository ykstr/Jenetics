package de.ykstr.jenetics.base;

public class WeightedPair<T> {
    private T item;
    private int value;

    public WeightedPair(T item, int value){
        this.item = item;
        this.value = value;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("<%s, %d>",getItem().toString(), getValue());
    }
}
