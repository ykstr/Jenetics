package de.ykstr.jenetics.impl;

import de.ykstr.jenetics.base.Population;
import de.ykstr.jenetics.impl.stringenetics.StringFitnessCalculator;
import de.ykstr.jenetics.impl.stringenetics.StringGenerator;
import de.ykstr.jenetics.impl.stringenetics.StringMutator;
import de.ykstr.jenetics.impl.stringenetics.StringSelector;

public class Main {
    public static void main(String[] args) {
        final String GOAL = "HelloWorld";
        StringGenerator g = new StringGenerator(GOAL.length());
        Population<String> population = new Population<>(g,5,0);
        StringFitnessCalculator sfc = new StringFitnessCalculator(GOAL);
        StringMutator mutator = new StringMutator();
        StringSelector selector = new StringSelector(sfc, g);


        population.getIndividuals().forEach(System.out::println);
        for(int i = 0; i<5; i++){
            population.iterate(selector,mutator,sfc);
            population.getIndividuals().forEach(System.out::println);
            //System.out.println(population.averageFitness(sfc));
            //System.out.println(population.highestFitness(sfc));

        }

    }
}
