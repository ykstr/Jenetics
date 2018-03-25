package de.ykstr.jenetics.impl.genetipics;

import de.ykstr.jenetics.base.ParentGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PictureGenerator extends ParentGenerator<BufferedImage>{

    Random random = new Random();

    @Override
    public BufferedImage generate(BufferedImage left, BufferedImage right) {
        BufferedImage result = new BufferedImage(left.getWidth(), left.getHeight(),BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x<left.getWidth(); x++){
            for(int y = 0; y<left.getHeight(); y++){
                if(random.nextBoolean()){
                    result.setRGB(x,y,left.getRGB(x,y));
                }else{
                    result.setRGB(x,y,right.getRGB(x,y));
                }
            }
        }
        return result;
    }

    public Color mix(Color a, Color b){
        int red = (int)Math.round((a.getRed()+b.getRed())/2.0);
        int green = (int)Math.round((a.getGreen()+b.getGreen())/2.0);
        int blue = (int)Math.round((a.getBlue()+b.getBlue())/2.0);
        return new Color(red,green, blue);
    }
}
