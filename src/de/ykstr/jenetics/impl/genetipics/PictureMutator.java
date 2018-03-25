package de.ykstr.jenetics.impl.genetipics;

import de.ykstr.jenetics.base.Mutator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PictureMutator extends Mutator<BufferedImage>{

    private Random random = new Random();
    private final int MUTATIONS;

    public PictureMutator(int mutations){
        this.MUTATIONS = mutations;
    }

    @Override
    public BufferedImage mutate(BufferedImage individual) {
        for(int i = 0; i<MUTATIONS; i++){
            int x = random.nextInt(individual.getWidth());
            int y = random.nextInt(individual.getHeight());
            individual.setRGB(x,y,mutate(individual.getRGB(x,y)));
        }
        return individual;
    }

    public int mutate(int rgb){
        Color c = new Color(rgb);
        int r = c.getRed()+random.nextInt(20)-10;
        if(r > 255){
            r = 255;
        }else if(r<0){
            r = 0;
        }

        int g = c.getGreen()+random.nextInt(20)-10;
        if(g > 255){
            g = 255;
        }else if(g<0){
            g = 0;
        }

        int b = c.getBlue()+random.nextInt(20)-10;
        if(b > 255){
            b = 255;
        }else if(b<0){
            b = 0;
        }

        return new Color(r,g,b).getRGB();
    }
}
