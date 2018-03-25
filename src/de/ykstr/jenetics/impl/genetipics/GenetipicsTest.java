package de.ykstr.jenetics.impl.genetipics;

import de.ykstr.jenetics.base.Population;
import de.ykstr.jenetics.base.utilities.WeightedRandomSelector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GenetipicsTest {
    public static void main(String[] args) {

        String[] pictures = {"apple.jpg","cactus.jpg","fogtrees.jpg","mirror.jpg","pictures.jpg","skyline.jpg"};
        final String GOALSTRING = "resources/trees.jpg";
        final BufferedImage GOAL;
        try{
            GOAL = ImageIO.read(new File(GOALSTRING));
        }catch (IOException e){
            System.err.println("Could not read goal!");
            return;
        }

        Population<BufferedImage> images = new Population<>(0);
        for(BufferedImage bi : parseImages(pictures, "resources/")){
            images.addIndividual(bi);
        }

        PictureMutator mutator = new PictureMutator(1);
        PictureGenerator generator = new PictureGenerator();
        PictureFitnessCalculator calculator = new PictureFitnessCalculator(GOAL);
        WeightedRandomSelector<BufferedImage> selector = new WeightedRandomSelector<BufferedImage>(calculator,generator);

        double delta = 0;
        for(int i = 0; i<20;i++){
            images.iterate(selector,mutator,calculator);
            System.out.println("Iteration "+(i+1)+" done");

            System.out.println("Average fitness: "+images.averageFitness(calculator));
            //delta = Math.abs(delta-images.averageFitness(calculator));
            //if(delta < 5)break;
            //if(images.highestFitness(calculator) > 200)break;
        }

        for(int i = 0; i<images.getIndividuals().size(); i++){
            File output = new File("out/result"+i+".jpg");
            try {
                ImageIO.write(images.getIndividuals().get(i), "jpg",output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static ArrayList<BufferedImage> parseImages(String[] paths, String prefix){
        ArrayList<BufferedImage> result = new ArrayList<>();
        for(String p : paths){
            try{
                result.add(ImageIO.read(new File(prefix+p)));
            }catch (IOException e){
                System.err.println("Could not read "+p);
            }
        }
        return result;
    }
}
