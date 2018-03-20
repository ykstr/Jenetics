package de.ykstr.jenetics.impl.stringenetics;

import de.ykstr.jenetics.base.Generator;
import de.ykstr.jenetics.base.Population;
import de.ykstr.jenetics.base.Selector;
import de.ykstr.jenetics.base.WeightedRandomList;

public class StringSelector extends Selector<String> {

    StringFitnessCalculator calculator;
    StringGenerator generator;

    public StringSelector(StringFitnessCalculator f, StringGenerator generator ){
        this.calculator = f;
        this.generator = generator;
    }

    @Override
    public String select(Population<String> p) {
        WeightedRandomList<String> randomList = new WeightedRandomList<>();
        for(String s : p.getIndividuals()){
            randomList.add(s, calculator.calculateFitness(s));
        }
        return generator.generate(randomList.getRandomItem(), randomList.getRandomItem());
    }
}
