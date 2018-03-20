package de.ykstr.jenetics.impl.stringenetics;

import de.ykstr.jenetics.base.FitnessCalculator;

public class StringFitnessCalculator extends FitnessCalculator<String> {

    String target;

    public StringFitnessCalculator(String target){
        this.target = target;
    }

    @Override
    public int calculateFitness(String individual) {
        int result = 0;
        for(int i = 0; i<Math.min(individual.length(), target.length());i++){
            if(individual.charAt(i) == target.charAt(i))result++;
        }
        return result;
    }
}
