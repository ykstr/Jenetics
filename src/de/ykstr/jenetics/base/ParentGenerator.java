package de.ykstr.jenetics.base;

public abstract class ParentGenerator<T> extends Generator {
    public abstract T generate(T left, T right);
}
