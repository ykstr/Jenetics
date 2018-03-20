package de.ykstr.jenetics.base;

import java.util.ArrayList;
import java.util.Random;

public class WeightedRandomList<T> {
    private ArrayList<WeightedPair<T>> items = new ArrayList<>();
    private Random random = new Random();

    public T getRandomItem(){
        return getRandomPair().getItem();
    }

    public WeightedPair<T> getRandomPair(){
        if(weightSum()>0) {
            int r = random.nextInt(weightSum());
            int i = 0;
            for(WeightedPair<T> p : items){
                i+= p.getValue();
                if(i >= r)return p;
            }
        }else {
            return items.get(random.nextInt(items.size()));
        }



        throw new IllegalStateException();
    }

    public int weightSum(){
        int result = 0;
        for(WeightedPair<T> p : items)result+=p.getValue();
        return result;
    }

    public void add(T item, int weight){
        items.add(new WeightedPair<T>(item, weight));
    }
}
