package de.ykstr.jenetics.base;

public abstract class Mutator<T> {
    public abstract T mutate(T individual);
}
