package de.ykstr.jenetics.impl.stringenetics;

import de.ykstr.jenetics.base.Mutator;
import java.util.Random;

public class StringMutator extends Mutator<String> {

    Random random = new Random();

    @Override
    public String mutate(String individual) {
        int index = random.nextInt(individual.length());
        char randomChar = (char) ('A'+random.nextInt('z'-'A'));
        return individual.substring(0,index)+randomChar+individual.substring(index+1);
    }
}
