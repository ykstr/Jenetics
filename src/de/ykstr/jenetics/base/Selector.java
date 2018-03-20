package de.ykstr.jenetics.base;

public abstract class Selector<T> {

    public abstract T select(Population<T> p);
}
