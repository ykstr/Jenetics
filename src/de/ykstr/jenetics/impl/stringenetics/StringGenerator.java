package de.ykstr.jenetics.impl.stringenetics;

import de.ykstr.jenetics.base.Generator;

import java.util.Random;
import java.util.stream.Collectors;

public class StringGenerator extends Generator<String> {

    private int length;
    private Random random = new Random();

    public StringGenerator(int length){
        this.length = length;
    }

    @Override
    public String generate() {
        int[] chars = random.ints('A','z').limit(length).toArray();
        StringBuilder sb = new StringBuilder();
        for(int i : chars){
            sb.append((char)i);
        }
        return sb.toString();
    }

    @Override
    public String generate(String... parents) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<parents[0].length(); i++){
            sb.append(parents[random.nextInt(parents.length)].charAt(i));
        }
        return sb.toString();
    }
}
