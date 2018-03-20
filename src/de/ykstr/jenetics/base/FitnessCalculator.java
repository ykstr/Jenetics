package de.ykstr.jenetics.base;

public abstract class FitnessCalculator<T> {
    public abstract int calculateFitness(T individual);
}
