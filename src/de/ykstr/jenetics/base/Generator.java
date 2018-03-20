package de.ykstr.jenetics.base;

public abstract class Generator<T> {
    public abstract T generate();
    public abstract T generate(T ... parents);
}
