package de.ykstr.jenetics.base.utilities;

import de.ykstr.jenetics.base.*;

public class WeightedRandomSelector<T> extends Selector<T> {

    FitnessCalculator<T> calculator;
    ParentGenerator<T> generator;

    public WeightedRandomSelector(FitnessCalculator<T> f, ParentGenerator<T> generator ){
        this.calculator = f;
        this.generator = generator;
    }

    @Override
    public T select(Population<T> p) {
        WeightedRandomList<T> randomList = new WeightedRandomList<>();
        for(T t : p.getIndividuals()){
            randomList.add(t, calculator.calculateFitness(t));
        }
        return generator.generate(randomList.getRandomItem(), randomList.getRandomItem());
    }
}
