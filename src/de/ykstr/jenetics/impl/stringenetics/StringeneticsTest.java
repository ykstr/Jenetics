package de.ykstr.jenetics.impl.stringenetics;

import de.ykstr.jenetics.base.Population;
import de.ykstr.jenetics.base.utilities.WeightedRandomSelector;
import de.ykstr.jenetics.impl.stringenetics.*;

public class StringeneticsTest {
    public static void main(String[] args) {
        final String GOAL = "HelloWorld";
        StringGenerator g = new StringGenerator(GOAL.length());
        Population<String> population = new Population<>(g,5,0);
        StringFitnessCalculator sfc = new StringFitnessCalculator(GOAL);
        StringMutator mutator = new StringMutator();
        WeightedRandomSelector<String> selector = new WeightedRandomSelector<>(sfc, g);


        population.getIndividuals().forEach(System.out::println);
        for(int i = 0; i<5; i++){
            population.iterate(selector,mutator,sfc);
            population.getIndividuals().forEach(System.out::println);
            //System.out.println(population.averageFitness(sfc));
            //System.out.println(population.highestFitness(sfc));

        }

    }
}
