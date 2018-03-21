package de.ykstr.jenetics.impl.stringenetics;

import de.ykstr.jenetics.base.Generator;
import de.ykstr.jenetics.base.ParentGenerator;

import java.util.Random;

public class StringGenerator extends ParentGenerator<String> {

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
    public String generate(String left, String right) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<left.length(); i++){
            if(random.nextBoolean()){
                sb.append(left.charAt(i));
            }else{
                sb.append(right.charAt(i));
            }
        }
        return sb.toString();
    }
}
