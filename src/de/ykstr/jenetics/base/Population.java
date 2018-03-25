package de.ykstr.jenetics.base;

import java.util.ArrayList;

public class Population<T> {

    private ArrayList<T> individuals = new ArrayList<>();
    private double mutationRate;

    public Population(double mutationRate){
        this.mutationRate = mutationRate;
    }

    public Population(Generator<T> g, int populationSize, double mutationRate){
        this(mutationRate);
        for(int i = 0; i<populationSize; i++)individuals.add(g.generate());
    }

    public void addIndividual(T t){
        individuals.add(t);
    }

    public void iterate(Selector<T> selector, Mutator<T> mutator, FitnessCalculator<T> calculator){
        ArrayList<T> nextGen = new ArrayList<>();
        for(int i = 0; i<individuals.size(); i++){
            T child = selector.select(this);
            if(Math.random()>(1-mutationRate)){
                child = mutator.mutate(child);
            }
            nextGen.add(child);
        }
        this.individuals = nextGen;
    }

    public double averageFitness(FitnessCalculator<T> calculator){
        double fitness = 0;
        for(T individual : individuals)fitness += calculator.calculateFitness(individual);
        return fitness/individuals.size();
    }

    public int highestFitness(FitnessCalculator<T> calculator){
        int fitness = 0;
        for(T individual : individuals)fitness = Math.max(fitness, calculator.calculateFitness(individual));
        return fitness;
    }

    public T getHighestFitnessIndividual(FitnessCalculator<T> calculator){
        int fitness = 0;
        T result = null;
        for(T individual : individuals){
            int temp = calculator.calculateFitness(individual);
            if(temp > fitness){
                result = individual;
                fitness = temp;
            }
        }
        return result;
    }

    public ArrayList<T> getIndividuals() {
        return individuals;
    }

    public boolean contains(T individual){
        return individuals.contains(individual);
    }
}
