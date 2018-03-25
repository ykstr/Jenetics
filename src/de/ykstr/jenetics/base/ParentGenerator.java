package de.ykstr.jenetics.base;

public abstract class ParentGenerator<T> {
    public abstract T generate(T left, T right);
}
