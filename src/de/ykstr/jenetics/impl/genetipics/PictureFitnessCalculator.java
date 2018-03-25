package de.ykstr.jenetics.impl.genetipics;

import de.ykstr.jenetics.base.FitnessCalculator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PictureFitnessCalculator extends FitnessCalculator<BufferedImage> {

    private final BufferedImage GOAL;

    public PictureFitnessCalculator(BufferedImage goal){
        this.GOAL = goal;
    }

    @Override
    public int calculateFitness(BufferedImage individual) {
        double fitness = 0;
        for(int x = 0; x<individual.getWidth(); x++){
            for(int y = 0; y<individual.getHeight(); y++){
                Color ic = new Color(individual.getRGB(x,y));
                Color gc = new Color(GOAL.getRGB(x,y));

                int rdiff = Math.abs(ic.getRed()-gc.getRed());
                int gdiff = Math.abs(ic.getGreen()-gc.getGreen());
                int bdiff = Math.abs(ic.getBlue()-gc.getBlue());

                fitness += (int)(255-Math.round((rdiff+gdiff+bdiff)/3.0));
            }
        }
        return (int) Math.round(fitness/(individual.getWidth()*individual.getHeight()));
    }
}
